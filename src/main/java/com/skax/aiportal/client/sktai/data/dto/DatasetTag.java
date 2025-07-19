package com.skax.aiportal.client.sktai.data.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 데이터셋 태그 클래스
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DatasetTag {
    @NotBlank(message = "태그 이름은 필수입니다")
    private String name;
}