package com.skax.aiplatform.client.sktax.evaluation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.evaluation.dto.PolicyPayload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 인증 승인 요청 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorizeRequest {
    
    @JsonProperty("url_path")
    private String urlPath;
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("policy_payload")
    private PolicyPayload policyPayload;
}
