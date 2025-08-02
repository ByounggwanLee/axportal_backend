package com.skax.aiplatform.client.sktax.knowledge.dto;

import java.util.List;

/**
 * 정책 페이로드 타입 (BasePolicyPayload의 배열)
 * OpenAPI 명세: PolicyPayload
 * 
 * @author ByounggwanLee
 * @since 2025-01-01
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
