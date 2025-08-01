package com.skax.aiplatform.client.sktax.intercept;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skax.aiplatform.common.exception.BusinessException;
import com.skax.aiplatform.common.exception.ErrorCode;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * SKTAX API 호출 시 발생하는 오류를 처리하는 에러 디코더
 * 
 * <p>외부 API 호출 시 발생하는 HTTP 오류를 내부 예외로 변환합니다:</p>
 * <ul>
 *   <li>401: 인증 오류</li>
 *   <li>403: 권한 오류</li>
 *   <li>404: 리소스 없음</li>
 *   <li>422: 유효성 검증 오류</li>
 *   <li>5xx: 서버 오류</li>
 * </ul>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class SktAxErrorDecoder implements ErrorDecoder {

    private final ObjectMapper objectMapper;
    private final ErrorDecoder defaultErrorDecoder = new Default();

    /**
     * Feign Response를 내부 예외로 변환
     * 
     * @param methodKey 호출된 메서드명
     * @param response Feign Response
     * @return 변환된 예외
     */
    @Override
    public Exception decode(String methodKey, Response response) {
        HttpStatus httpStatus = HttpStatus.valueOf(response.status());
        String errorMessage = extractErrorMessage(response);

        log.error("SKTAX API Error - Method: {}, Status: {}, Message: {}", 
                 methodKey, httpStatus, errorMessage);

        return switch (httpStatus) {
            case UNAUTHORIZED -> new BusinessException(ErrorCode.EXTERNAL_API_UNAUTHORIZED, 
                    String.format("SKTAX API 인증 실패: %s", errorMessage));
            
            case FORBIDDEN -> new BusinessException(ErrorCode.EXTERNAL_API_FORBIDDEN, 
                    String.format("SKTAX API 권한 없음: %s", errorMessage));
            
            case NOT_FOUND -> new BusinessException(ErrorCode.EXTERNAL_API_NOT_FOUND, 
                    String.format("SKTAX API 리소스 없음: %s", errorMessage));
            
            case UNPROCESSABLE_ENTITY -> new BusinessException(ErrorCode.EXTERNAL_API_VALIDATION_ERROR, 
                    String.format("SKTAX API 유효성 검증 실패: %s", errorMessage));
            
            case BAD_REQUEST -> new BusinessException(ErrorCode.EXTERNAL_API_BAD_REQUEST, 
                    String.format("SKTAX API 잘못된 요청: %s", errorMessage));
            
            case INTERNAL_SERVER_ERROR, BAD_GATEWAY, SERVICE_UNAVAILABLE, GATEWAY_TIMEOUT -> 
                    new BusinessException(ErrorCode.EXTERNAL_API_SERVER_ERROR, 
                    String.format("SKTAX API 서버 오류: %s", errorMessage));
            
            default -> defaultErrorDecoder.decode(methodKey, response);
        };
    }

    /**
     * Response에서 에러 메시지 추출
     * 
     * @param response Feign Response
     * @return 추출된 에러 메시지
     */
    private String extractErrorMessage(Response response) {
        try {
            if (response.body() != null) {
                InputStream inputStream = response.body().asInputStream();
                String body = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
                
                // JSON 응답에서 메시지 추출 시도
                try {
                    var errorNode = objectMapper.readTree(body);
                    if (errorNode.has("message")) {
                        return errorNode.get("message").asText();
                    }
                    if (errorNode.has("detail")) {
                        return errorNode.get("detail").asText();
                    }
                } catch (Exception e) {
                    log.debug("Failed to parse error response as JSON: {}", e.getMessage());
                }
                
                return body;
            }
        } catch (IOException e) {
            log.error("Failed to read error response body", e);
        }
        
        return "Unknown error occurred";
    }
}
