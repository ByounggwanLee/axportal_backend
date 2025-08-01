package com.skax.aiplatform.client.sktax.config;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * SKTAX API 에러 디코더
 * 
 * <p>SKTAX API 응답 에러를 적절한 예외로 변환합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Slf4j
public class SktAxErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        HttpStatus httpStatus = HttpStatus.valueOf(response.status());
        String errorMessage = extractErrorMessage(response);
        
        log.error("SKTAX API 에러 발생 - 메서드: {}, 상태코드: {}, 메시지: {}", 
                 methodKey, httpStatus, errorMessage);

        switch (httpStatus) {
            case BAD_REQUEST:
                return new SktAxClientException("잘못된 요청입니다: " + errorMessage, httpStatus);
            case UNAUTHORIZED:
                return new SktAxClientException("인증이 필요합니다: " + errorMessage, httpStatus);
            case FORBIDDEN:
                return new SktAxClientException("접근이 거부되었습니다: " + errorMessage, httpStatus);
            case NOT_FOUND:
                return new SktAxClientException("요청한 리소스를 찾을 수 없습니다: " + errorMessage, httpStatus);
            case TOO_MANY_REQUESTS:
                return new SktAxClientException("요청 한도를 초과했습니다: " + errorMessage, httpStatus);
            case INTERNAL_SERVER_ERROR:
                return new SktAxServerException("서버 내부 오류가 발생했습니다: " + errorMessage, httpStatus);
            case BAD_GATEWAY:
            case SERVICE_UNAVAILABLE:
            case GATEWAY_TIMEOUT:
                return new SktAxServerException("서비스를 사용할 수 없습니다: " + errorMessage, httpStatus);
            default:
                return defaultErrorDecoder.decode(methodKey, response);
        }
    }

    /**
     * 응답에서 에러 메시지 추출
     * 
     * @param response Feign 응답
     * @return 에러 메시지
     */
    private String extractErrorMessage(Response response) {
        try {
            if (response.body() != null) {
                return new String(response.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            log.warn("에러 응답 본문을 읽을 수 없습니다: {}", e.getMessage());
        }
        return "알 수 없는 오류가 발생했습니다.";
    }

    /**
     * SKTAX 클라이언트 예외 (4xx 에러)
     */
    public static class SktAxClientException extends RuntimeException {
        private final HttpStatus status;

        public SktAxClientException(String message, HttpStatus status) {
            super(message);
            this.status = status;
        }

        public HttpStatus getStatus() {
            return status;
        }
    }

    /**
     * SKTAX 서버 예외 (5xx 에러)
     */
    public static class SktAxServerException extends RuntimeException {
        private final HttpStatus status;

        public SktAxServerException(String message, HttpStatus status) {
            super(message);
            this.status = status;
        }

        public HttpStatus getStatus() {
            return status;
        }
    }
}
