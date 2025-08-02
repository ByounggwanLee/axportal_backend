package com.skax.aiplatform.client.sktax.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Dataset Tags DTO
 * 
 * <p>데이터셋에 적용되는 태그 정보를 담는 데이터 모델입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-01-21
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DatasetTags {
    
    /**
     * 태그 이름 (필수)
     */
    @JsonProperty("name")
    private String name;
}
