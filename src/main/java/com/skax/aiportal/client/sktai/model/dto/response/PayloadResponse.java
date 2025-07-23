package com.skax.aiportal.client.sktai.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 페이지네이션 정보를 포함한 Payload 응답 클래스
 * 
 * <p>SKT AI Model 서비스에서 목록 조회 시 페이지네이션 정보를 포함하는 응답 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(
    title = "페이지네이션 Payload 응답",
    description = "페이지네이션 정보를 포함한 응답 데이터"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PayloadResponse {
    
    /**
     * 페이지네이션 정보
     * 
     * <p>현재 페이지, 총 페이지 수, 페이지 크기 등의 정보를 포함합니다.</p>
     */
    @Schema(
        description = "페이지네이션 정보",
        implementation = PaginationResponse.class
    )
    @JsonProperty("pagination")
    private PaginationResponse pagination;
}
