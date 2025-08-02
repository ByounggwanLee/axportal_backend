package com.skax.aiplatform.client.sktax.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 유효성 검사 오류 DTO
 * 
 * <p>유효성 검사에서 발생한 오류 정보를 담는 데이터 모델입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidationError {

    /**
     * 오류 위치 (필수)
     */
    @JsonProperty("loc")
    private List<Object> loc;

    /**
     * 오류 메시지 (필수)
     */
    @JsonProperty("msg")
    private String msg;

    /**
     * 오류 타입 (필수)
     */
    @JsonProperty("type")
    private String type;
}
