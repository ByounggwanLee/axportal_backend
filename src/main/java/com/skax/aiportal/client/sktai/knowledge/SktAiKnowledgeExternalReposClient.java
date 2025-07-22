package com.skax.aiportal.client.sktai.knowledge;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.knowledge.dto.request.ExternalRepoCreateRequest;
import com.skax.aiportal.client.sktai.knowledge.dto.request.ExternalRepoTestRequest;
import com.skax.aiportal.client.sktai.knowledge.dto.response.KnowledgeResponse;

/**
 * SKT AI Knowledge External Repository 관리 API Feign 클라이언트
 *
 * <p>외부 Knowledge Repository의 등록, 수정, 삭제, 조회 및 테스트 기능을 제공합니다.</p>
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@FeignClient(
    name = "skt-ai-knowledge-external-repos",
    url = "${skt.ai.knowledge.url:https://aip-stg.sktai.io}",
    path = "/api/v1/knowledge",
    configuration = SktAiClientConfig.class
)
public interface SktAiKnowledgeExternalReposClient {

    /**
     * External Knowledge 목록 조회
     *
     * @param page 페이지 번호 (기본값: 1)
     * @param size 페이지 크기 (기본값: 10)
     * @param sort 정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return External Knowledge 목록 응답
     */
    @GetMapping("/repos/external")
    KnowledgeResponse<Object> getExternalRepos(
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size,
        @RequestParam(required = false) String sort,
        @RequestParam(required = false) String filter,
        @RequestParam(required = false) String search
    );

    /**
     * External Knowledge Repo 등록
     *
     * @param request External Repository 생성 요청
     * @return External Repository 생성 응답
     */
    @PostMapping("/repos/external")
    KnowledgeResponse<Object> createExternalRepo(@RequestBody ExternalRepoCreateRequest request);

    /**
     * External Knowledge Repo 동작 Test
     *
     * @param request External Repository 테스트 요청
     * @return External Repository 테스트 응답
     */
    @PostMapping("/repos/external/test")
    KnowledgeResponse<Object> testExternalRepo(@RequestBody ExternalRepoTestRequest request);

    /**
     * Repo ID로 External Knowledge Repo 상세 조회
     *
     * @param repoId Repository ID
     * @return External Repository 상세 정보 응답
     */
    @GetMapping("/repos/external/{repo_id}")
    KnowledgeResponse<Object> getExternalRepoById(@PathVariable("repo_id") String repoId);

    /**
     * External Knowledge Repo 수정
     *
     * @param repoId Repository ID
     * @param request External Repository 수정 요청
     * @return External Repository 수정 응답
     */
    @PutMapping("/repos/external/{repo_id}")
    KnowledgeResponse<Object> updateExternalRepo(@PathVariable("repo_id") String repoId, @RequestBody Object request);

    /**
     * Repo ID로 External Knowledge Repo 삭제
     *
     * @param repoId Repository ID
     */
    @DeleteMapping("/repos/external/{repo_id}")
    void deleteExternalRepo(@PathVariable("repo_id") String repoId);
}
