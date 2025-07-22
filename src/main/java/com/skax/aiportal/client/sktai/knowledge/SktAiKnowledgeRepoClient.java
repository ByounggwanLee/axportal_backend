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
import com.skax.aiportal.client.sktai.knowledge.dto.request.RepoCreateRequest;
import com.skax.aiportal.client.sktai.knowledge.dto.request.RepoEditRequest;
import com.skax.aiportal.client.sktai.knowledge.dto.request.RepoUpdateRequest;
import com.skax.aiportal.client.sktai.knowledge.dto.response.KnowledgeResponse;

/**
 * SKT AI Knowledge Repository 관리 API Feign 클라이언트
 *
 * <p>Knowledge Repository의 생성, 수정, 삭제, 조회 및 인덱싱 기능을 제공합니다.</p>
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@FeignClient(
    name = "skt-ai-knowledge-repos",
    url = "${skt.ai.knowledge.url:https://aip-stg.sktai.io}",
    path = "/api/v1/knowledge",
    configuration = SktAiClientConfig.class
)
public interface SktAiKnowledgeRepoClient {

    /**
     * Knowledge 목록 조회
     *
     * @param isActive 활성 상태 필터
     * @param page 페이지 번호 (기본값: 1)
     * @param size 페이지 크기 (기본값: 10)
     * @param sort 정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return Knowledge 목록 응답
     */
    @GetMapping("/repos")
    KnowledgeResponse<Object> getRepos(
        @RequestParam(name = "is_active", required = false) Boolean isActive,
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size,
        @RequestParam(required = false) String sort,
        @RequestParam(required = false) String filter,
        @RequestParam(required = false) String search
    );

    /**
     * Knowledge Repo 신규 생성
     *
     * @param request Repository 생성 요청
     * @return Repository 생성 응답
     */
    @PostMapping("/repos")
    KnowledgeResponse<Object> createRepo(@RequestBody RepoCreateRequest request);

    /**
     * Repo ID로 Knowledge Repo 상세 조회
     *
     * @param repoId Repository ID
     * @return Repository 상세 정보 응답
     */
    @GetMapping("/repos/{repo_id}")
    KnowledgeResponse<Object> getRepoById(@PathVariable("repo_id") String repoId);

    /**
     * Knowledge Repo 에 datasource 변경 사항 반영 수정
     *
     * @param repoId Repository ID
     * @param request Repository 업데이트 요청
     * @return Repository 업데이트 응답
     */
    @PutMapping("/repos/{repo_id}")
    KnowledgeResponse<Object> updateRepo(@PathVariable("repo_id") String repoId, @RequestBody RepoUpdateRequest request);

    /**
     * Repo ID로 Knowledge Repo 삭제
     *
     * @param repoId Repository ID
     */
    @DeleteMapping("/repos/{repo_id}")
    void deleteRepo(@PathVariable("repo_id") String repoId);

    /**
     * Knowledge Repo 이름 및 default loader, chunk 정보 수정
     *
     * @param repoId Repository ID
     * @param request Repository 편집 요청
     * @return Repository 편집 응답
     */
    @PutMapping("/repos/{repo_id}/edit")
    KnowledgeResponse<Object> editRepo(@PathVariable("repo_id") String repoId, @RequestBody RepoEditRequest request);

    /**
     * 지정한 Knowledge repo의 대상 파일의 Indexing 진행
     *
     * @param repoId Repository ID
     * @param targetStep 대상 단계 (loading_docs, chunking_docs, embedding_and_indexing)
     * @return Indexing 응답
     */
    @PostMapping("/repos/{repo_id}/indexing")
    KnowledgeResponse<Object> indexingRepo(@PathVariable("repo_id") String repoId, @RequestParam(name = "target_step", defaultValue = "embedding_and_indexing") String targetStep);

    /**
     * 지정한 Knowledge repo의 진행중인 Indexing 작업을 중지
     *
     * @param repoId Repository ID
     * @return 인덱싱 중지 응답
     */
    @PostMapping("/repos/{repo_id}/stop_indexing")
    KnowledgeResponse<Object> stopIndexingRepo(@PathVariable("repo_id") String repoId);

    /**
     * Repo ID로 Knowledge에 Retrieval하기 위한 상세 정보를 조회합니다
     *
     * @param repoId Repository ID
     * @param projectId 프로젝트 ID
     * @param isExternal 외부 여부 (기본값: false)
     * @return Repository Retrieval 정보 응답
     */
    @GetMapping("/repos/retrieval_info")
    KnowledgeResponse<Object> getRepoRetrievalInfo(
        @RequestParam("repo_id") String repoId,
        @RequestParam("project_id") String projectId,
        @RequestParam(name = "is_external", defaultValue = "false") Boolean isExternal
    );
}
