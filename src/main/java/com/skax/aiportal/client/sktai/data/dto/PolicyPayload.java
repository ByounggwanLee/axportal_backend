package com.skax.aiportal.client.sktai.data.dto;

import lombok.Getter;

import java.util.List;

/**
 * 정책 페이로드 타입 정의
 * 
 * <p>SKT AI 플랫폼의 정책 페이로드는 BasePolicyPayload의 배열입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
public class PolicyPayload extends java.util.ArrayList<BasePolicyPayload> {
    
    /**
     * 기본 생성자
     */
    public PolicyPayload() {
        super();
    }

    /**
     * 컬렉션을 이용한 생성자
     * 
     * @param policies 정책 페이로드 목록
     */
    public PolicyPayload(List<BasePolicyPayload> policies) {
        super(policies);
    }

    /**
     * 정적 팩토리 메서드
     * 
     * @param policies 정책 페이로드 목록
     * @return PolicyPayload 인스턴스
     */
    public static PolicyPayload of(List<BasePolicyPayload> policies) {
        return new PolicyPayload(policies);
    }

    /**
     * 단일 정책으로 생성하는 정적 팩토리 메서드
     * 
     * @param policy 단일 정책 페이로드
     * @return PolicyPayload 인스턴스
     */
    public static PolicyPayload of(BasePolicyPayload policy) {
        PolicyPayload payload = new PolicyPayload();
        payload.add(policy);
        return payload;
    }
}
