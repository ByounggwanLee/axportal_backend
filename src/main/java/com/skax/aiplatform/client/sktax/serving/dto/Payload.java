package com.skax.aiplatform.client.sktax.serving.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Payload DTO
 * 페이지네이션 정보를 포함하는 페이로드 클래스입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payload {

    /**
     * 페이지네이션 정보
     */
    @JsonProperty("pagination")
    private Pagination pagination;
}
