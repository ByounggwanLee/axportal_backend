package com.skax.aiplatform.client.sktax.finetuning.dto;

/**
 * 정책 페이로드 배열 타입 정의
 * OpenAPI 명세에 따라 PolicyPayload는 BasePolicyPayload의 배열입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
public class PolicyPayload extends java.util.ArrayList<BasePolicyPayload> {
    
    /**
     * 기본 생성자
     */
    public PolicyPayload() {
        super();
    }
    
    /**
     * 정책 목록으로 초기화하는 생성자
     */
    public PolicyPayload(java.util.List<BasePolicyPayload> policies) {
        super(policies);
    }
    
    /**
     * 가변 인자로 정책을 받는 생성자
     */
    public PolicyPayload(BasePolicyPayload... policies) {
        super(java.util.Arrays.asList(policies));
    }
}
