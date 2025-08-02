package com.skax.aiplatform.client.sktax.model.dto;

import java.util.List;

/**
 * 정책 페이로드 타입 (BasePolicyPayload 배열)
 * OpenAPI 명세에 따라 PolicyPayload는 BasePolicyPayload의 배열입니다.
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

    public PolicyPayload(BasePolicyPayload... policies) {
        super(List.of(policies));
    }
}
