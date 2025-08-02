package com.skax.aiplatform.client.sktax.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * SKT AX Data API S3 설정
 * 
 * <p>S3 연결을 위한 설정 정보입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-01-21
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class S3Config {
    
    /**
     * S3 버킷 이름 (필수)
     */
    @JsonProperty("bucket_name")
    private String bucketName;
    
    /**
     * 액세스 키 (필수)
     */
    @JsonProperty("access_key")
    private String accessKey;
    
    /**
     * 시크릿 키 (필수)
     */
    @JsonProperty("secret_key")
    private String secretKey;
    
    /**
     * 리전 (필수)
     */
    @JsonProperty("region")
    private String region;
    
    /**
     * 프리픽스
     */
    @JsonProperty("prefix")
    private String prefix;
}
