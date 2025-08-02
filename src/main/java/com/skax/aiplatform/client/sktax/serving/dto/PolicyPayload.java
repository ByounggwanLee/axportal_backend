package com.skax.aiplatform.client.sktax.serving.dto;

import java.util.List;

/**
 * Policy Payload Type
 * 정책 페이로드 타입 정의입니다.
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
