package com.skax.aiportal.client.sktai.knowledge;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.knowledge.dto.request.RetrievalRequest;
import com.skax.aiportal.client.sktai.knowledge.dto.request.TestRetrievalRequest;
import com.skax.aiportal.client.sktai.knowledge.dto.response.RetrievalResponse;

/**
 * SKT AI Knowledge Queries (검색) API Feign 클라이언트
 *
 * <p>Knowledge Repository에서 문서 검색 기능을 제공합니다.</p>
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@FeignClient(
    name = "skt-ai-knowledge-queries",
    url = "${skt.ai.knowledge.url:https://aip-stg.sktai.io}",
    path = "/api/v1/knowledge",
    configuration = SktAiClientConfig.class
)
public interface SktAiKnowledgeQueriesClient {

    /**
     * 사용자 질의 관련 유사도 높은 문서 검색
     *
     * @param request 검색 요청
     * @return 검색 결과 응답
     */
    @PostMapping("/queries")
    RetrievalResponse queries(@RequestBody RetrievalRequest request);

    /**
     * 사용자 질의 관련 유사도 높은 문서 검색 (전문가용)
     *
     * @param request 고급 검색 요청
     * @return 검색 결과 응답
     */
    @PostMapping("/queries/advanced")
    RetrievalResponse queriesAdvanced(@RequestBody RetrievalRequest request);

    /**
     * 사용자 질의 관련 유사도 높은 문서 검색 (테스트용)
     *
     * @param request 테스트 검색 요청
     * @return 검색 결과 응답
     */
    @PostMapping("/queries/test")
    RetrievalResponse testQueries(@RequestBody TestRetrievalRequest request);

    /**
     * 사용자 질의 관련 유사도 높은 문서 검색 (테스트 전문가용)
     *
     * @param request 테스트 고급 검색 요청
     * @return 검색 결과 응답
     */
    @PostMapping("/queries/test/advanced")
    RetrievalResponse testQueriesAdvanced(@RequestBody RetrievalRequest request);
}
