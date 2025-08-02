package com.skax.aiplatform.client.sktax.evaluation.dto;

import java.util.List;

/**
 * 정책 페이로드 타입 정의
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
public class PolicyPayload extends java.util.ArrayList<BasePolicyPayload> {
    
    public PolicyPayload() {
        super();
    }
    
    public PolicyPayload(List<BasePolicyPayload> policies) {
        super(policies);
    }
}
