package com.skax.aiplatform.client.sktax.knowledge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 페이로드 DTO
 * 
 * <p>API 응답의 추가 정보를 담는 페이로드입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payload {

    /**
     * 페이지네이션 정보
     */
    @JsonProperty("pagination")
    private Pagination pagination;
}
