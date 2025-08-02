package com.skax.aiplatform.client.sktax.serving.dto.response;

import com.skax.aiplatform.client.sktax.serving.dto.Pagination;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * API Key 전용 Payload 클래스
 * OpenAPI 명세의 app__models__apikey_model__Payload 구조체에 해당
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiKeyPayload {
    
    /**
     * 페이징 정보
     */
    private Pagination pagination;
}
