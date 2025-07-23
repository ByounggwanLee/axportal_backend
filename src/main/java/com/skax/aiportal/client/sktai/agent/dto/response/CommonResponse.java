package com.skax.aiportal.client.sktai.agent.dto.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * SKT AI Agent API 공통 응답 DTO
 *
 * <p>SKT AI Agent API의 표준 응답 형식입니다.
 * 모든 Agent API 응답은 이 형식을 따르며, 타임스탬프, 상태 코드, 메시지, 데이터를 포함합니다.</p>
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Schema(
    title = "SKT AI Agent API 공통 응답",
    description = "SKT AI Agent API의 표준 응답 형식"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommonResponse {

    /**
     * 응답 타임스탬프
     * 
     * <p>API 응답이 생성된 시간입니다.</p>
     */
    @Schema(
        description = "응답 생성 타임스탬프",
        example = "2025-07-23T10:30:00",
        type = "string",
        format = "date-time"
    )
    private LocalDateTime timestamp;

    /**
     * 응답 코드
     * 
     * <p>API 처리 결과를 나타내는 상태 코드입니다.</p>
     */
    @Schema(
        description = "응답 상태 코드",
        example = "200",
        minimum = "100",
        maximum = "599"
    )
    private Integer code;

    /**
     * 응답 상세 메시지
     * 
     * <p>API 처리 결과에 대한 상세한 설명입니다.</p>
     */
    @Schema(
        description = "응답 상세 메시지",
        example = "요청이 성공적으로 처리되었습니다.",
        maxLength = 500
    )
    private String detail;

    /**
     * 추적 ID
     * 
     * <p>요청을 추적하기 위한 고유 식별자입니다.</p>
     */
    @Schema(
        description = "요청 추적 ID",
        example = "trace-12345-abcde",
        maxLength = 100
    )
    @JsonProperty("traceId")
    private String traceId;

    /**
     * 응답 데이터
     * 
     * <p>API 처리 결과 데이터입니다. 타입은 API에 따라 다릅니다.</p>
     */
    @Schema(
        description = "응답 데이터",
        example = "{\"result\": \"success\"}"
    )
    private Object data;

    /**
     * 페이징 정보
     * 
     * <p>목록 조회 API의 경우 페이징 관련 정보가 포함됩니다.</p>
     */
    @Schema(
        description = "페이징 정보 (목록 조회 시)",
        example = "{\"page\": 1, \"size\": 10, \"total\": 100}"
    )
    private Object payload;
}
