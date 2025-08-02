package com.skax.aiplatform.client.sktax.knowledge;

import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import com.skax.aiplatform.client.sktax.knowledge.dto.request.RepoCreateRequest;
import com.skax.aiplatform.client.sktax.knowledge.dto.response.MultiResponse;
import com.skax.aiplatform.client.sktax.knowledge.dto.response.RepoCreateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * SKT AI Platform Knowledge Repositories API Client
 * 
 * <p>Knowledge Repository 관리 기능을 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@FeignClient(
    name = "skt-ax-knowledge-repos",
    url = "${sktax.knowledge.url:https://aip-stg.sktai.io}",
    configuration = SktAxFeignConfig.class
)
public interface SktAxKnowledgeReposClient {

    /**
     * Knowledge 목록 조회
     * 
     * @param isActive 활성 상태 필터
     * @param page 페이지 번호
     * @param size 페이지 크기
     * @param sort 정렬 조건
     * @param filter 필터 조건
     * @param search 검색어
     * @return Knowledge 목록
     */
    @GetMapping("/api/v1/knowledge/repos")
    MultiResponse getRepos(
        @RequestParam(value = "is_active", required = false) Boolean isActive,
        @RequestParam(value = "page", defaultValue = "1") Integer page,
        @RequestParam(value = "size", defaultValue = "10") Integer size,
        @RequestParam(value = "sort", required = false) String sort,
        @RequestParam(value = "filter", required = false) String filter,
        @RequestParam(value = "search", required = false) String search
    );

    /**
     * Knowledge Repo 신규 생성
     * 
     * @param request Knowledge Repo 생성 요청
     * @return 생성된 Knowledge Repo 정보
     */
    @PostMapping("/api/v1/knowledge/repos")
    RepoCreateResponse createRepo(@RequestBody RepoCreateRequest request);

    /**
     * Repo ID로 Knowledge에 Retrieval하기 위한 상세 정보 조회
     * 
     * @param repoId Repository ID
     * @param projectId Project ID
     * @param isExternal 외부 여부
     * @return Retrieval 정보
     */
    @GetMapping("/api/v1/knowledge/repos/retrieval_info")
    Object getRepoRetrievalInfo(
        @RequestParam("repo_id") String repoId,
        @RequestParam("project_id") String projectId,
        @RequestParam(value = "is_external", defaultValue = "false") Boolean isExternal
    );

    /**
     * Repo ID로 Knowledge Repo 상세 조회
     * 
     * @param repoId Repository ID
     * @return Knowledge Repo 상세 정보
     */
    @GetMapping("/api/v1/knowledge/repos/{repo_id}")
    Object getRepo(@PathVariable("repo_id") String repoId);

    /**
     * Knowledge Repo에 datasource 변경 사항 반영 수정
     * 
     * @param repoId Repository ID
     * @param request 수정 요청
     * @return 수정된 Repository 정보
     */
    @PutMapping("/api/v1/knowledge/repos/{repo_id}")
    Object updateRepo(
        @PathVariable("repo_id") String repoId,
        @RequestBody Object request
    );

    /**
     * Repo ID로 Knowledge Repo 삭제
     * 
     * @param repoId Repository ID
     */
    @DeleteMapping("/api/v1/knowledge/repos/{repo_id}")
    void deleteRepo(@PathVariable("repo_id") String repoId);

    /**
     * 지정한 Knowledge repo의 대상 파일의 Indexing 진행
     * 
     * @param repoId Repository ID
     * @param targetStep 대상 단계
     * @return 인덱싱 결과
     */
    @PostMapping("/api/v1/knowledge/repos/{repo_id}/indexing")
    Object indexingRepo(
        @PathVariable("repo_id") String repoId,
        @RequestParam(value = "target_step", defaultValue = "embedding_and_indexing") String targetStep
    );

    /**
     * 지정한 Knowledge repo의 진행중인 Indexing 작업을 중지
     * 
     * @param repoId Repository ID
     * @return 중지 결과
     */
    @PostMapping("/api/v1/knowledge/repos/{repo_id}/stop_indexing")
    Object stopIndexingRepo(@PathVariable("repo_id") String repoId);
}
