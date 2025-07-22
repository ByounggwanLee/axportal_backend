package com.skax.aiportal.dto.data.request;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 데이터셋 태그 업데이트 요청 DTO
 * 
 * <p>데이터셋의 태그를 업데이트하거나 삭제할 때 사용하는 요청 데이터입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DatasetTagUpdateRequest {

    /**
     * 태그 목록
     */
    @NotEmpty(message = "태그 목록은 비어있을 수 없습니다")
    private List<DatasetTag> tags;

    /**
     * 데이터셋 태그 내부 클래스
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DatasetTag {
        
        /**
         * 태그 이름
         */
        private String name;
        
        /**
         * 태그 값
         */
        private String value;
        
        /**
         * 태그 색상
         */
        private String color;
        
        /**
         * 태그 설명
         */
        private String description;
    }
}
