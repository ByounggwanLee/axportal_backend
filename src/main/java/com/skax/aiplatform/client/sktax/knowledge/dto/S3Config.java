package com.skax.aiplatform.client.sktax.knowledge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * S3 설정 정보 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class S3Config {

    /**
     * S3 버킷 이름
     */
    @JsonProperty("bucket_name")
    private String bucketName;

    /**
     * AWS Access Key
     */
    @JsonProperty("access_key")
    private String accessKey;

    /**
     * AWS Secret Key
     */
    @JsonProperty("secret_key")
    private String secretKey;

    /**
     * AWS 리전
     */
    @JsonProperty("region")
    private String region;

    /**
     * S3 접두사 (선택사항)
     */
    @JsonProperty("prefix")
    private String prefix;
}
