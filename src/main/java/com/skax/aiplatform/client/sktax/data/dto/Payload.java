package com.skax.aiplatform.client.sktax.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * SKT AX Data API 페이로드
 * 
 * <p>API 응답에서 페이지네이션 정보를 포함하는 페이로드입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-01-21
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payload {
    
    /**
     * 페이지네이션 정보
     */
    @JsonProperty("pagination")
    private Pagination pagination;
}
