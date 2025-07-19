package com.skax.aiportal.client.sktai.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * S3 설정 클래스
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class S3Config {

    @NotBlank(message = "버킷 이름은 필수입니다")
    @JsonProperty("bucket_name")
    private String bucketName;

    @NotBlank(message = "액세스 키는 필수입니다")
    @JsonProperty("access_key")
    private String accessKey;

    @NotBlank(message = "시크릿 키는 필수입니다")
    @JsonProperty("secret_key")
    private String secretKey;

    @NotBlank(message = "리전은 필수입니다")
    private String region;

    private String prefix;
}