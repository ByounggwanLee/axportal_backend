package com.skax.aiplatform.client.sktax.knowledge;

import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import com.skax.aiplatform.client.sktax.knowledge.dto.request.RetrievalRequest;
import com.skax.aiplatform.client.sktax.knowledge.dto.request.RetrievalAdvancedRequest;
import com.skax.aiplatform.client.sktax.knowledge.dto.request.TestRetrievalRequest;
import com.skax.aiplatform.client.sktax.knowledge.dto.request.TestRetrievalAdvancedRequest;
import com.skax.aiplatform.client.sktax.knowledge.dto.response.RetrievalResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * SKT AI Platform Knowledge Queries API Client
 * 
 * <p>사용자 질의와 관련된 문서 검색 기능을 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@FeignClient(
    name = "skt-ax-knowledge-queries",
    url = "${sktax.knowledge.url:https://aip-stg.sktai.io}",
    configuration = SktAxFeignConfig.class
)
public interface SktAxKnowledgeQueriesClient {

    /**
     * 사용자 질의 관련 유사도 높은 문서 검색
     * 
     * @param request 검색 요청 정보
     * @return 검색 결과
     */
    @PostMapping("/api/v1/knowledge/queries")
    RetrievalResponse searchDocuments(@RequestBody RetrievalRequest request);

    /**
     * 사용자 질의 관련 유사도 높은 문서 검색 (전문가용)
     * 
     * @param request 고급 검색 요청 정보
     * @return 검색 결과
     */
    @PostMapping("/api/v1/knowledge/queries/advanced")
    RetrievalResponse searchDocumentsAdvanced(@RequestBody RetrievalAdvancedRequest request);

    /**
     * 테스트용 사용자 질의 관련 유사도 높은 문서 검색
     * 
     * @param request 테스트 검색 요청 정보
     * @return 검색 결과
     */
    @PostMapping("/api/v1/knowledge/queries/test")
    RetrievalResponse testSearchDocuments(@RequestBody TestRetrievalRequest request);

    /**
     * 테스트용 사용자 질의 관련 유사도 높은 문서 검색 (전문가용)
     * 
     * @param request 테스트 고급 검색 요청 정보
     * @return 검색 결과
     */
    @PostMapping("/api/v1/knowledge/queries/test/advanced")
    RetrievalResponse testSearchDocumentsAdvanced(@RequestBody TestRetrievalAdvancedRequest request);
}
