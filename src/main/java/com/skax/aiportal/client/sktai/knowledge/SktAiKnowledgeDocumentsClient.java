package com.skax.aiportal.client.sktai.knowledge;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.knowledge.dto.request.DocumentMetadataRequest;
import com.skax.aiportal.client.sktai.knowledge.dto.request.DocumentUpdateRequest;
import com.skax.aiportal.client.sktai.knowledge.dto.response.KnowledgeResponse;

/**
 * SKT AI Knowledge Documents 관리 API Feign 클라이언트
 *
 * <p>Knowledge Repository의 문서 관리 및 처리 기능을 제공합니다.</p>
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@FeignClient(
    name = "skt-ai-knowledge-documents",
    url = "${skt.ai.knowledge.url:https://aip-stg.sktai.io}",
    path = "/api/v1/knowledge",
    configuration = SktAiClientConfig.class
)
public interface SktAiKnowledgeDocumentsClient {

    /**
     * Knowledge Repo Document 목록 조회
     *
     * @param repoId Repository ID
     * @param page 페이지 번호 (기본값: 1)
     * @param size 페이지 크기 (기본값: 10)
     * @param sort 정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return Document 목록 응답
     */
    @GetMapping("/repos/{repo_id}/documents")
    KnowledgeResponse<Object> getDocuments(
        @PathVariable("repo_id") String repoId,
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size,
        @RequestParam(required = false) String sort,
        @RequestParam(required = false) String filter,
        @RequestParam(required = false) String search
    );

    /**
     * Document 상세 설정
     *
     * @param repoId Repository ID
     * @param request Document 업데이트 요청
     * @return Document 업데이트 응답
     */
    @PutMapping("/repos/{repo_id}/documents")
    KnowledgeResponse<Object> updateDocuments(@PathVariable("repo_id") String repoId, @RequestBody DocumentUpdateRequest request);

    /**
     * Document 삭제 (복수)
     *
     * @param repoId Repository ID
     * @param documentIds 삭제할 문서 ID 목록
     */
    @DeleteMapping("/repos/{repo_id}/documents")
    void deleteDocuments(@PathVariable("repo_id") String repoId, @RequestBody List<String> documentIds);

    /**
     * Document 상세 조회
     *
     * @param repoId Repository ID
     * @param documentId Document ID
     * @return Document 상세 정보 응답
     */
    @GetMapping("/repos/{repo_id}/documents/{document_id}")
    KnowledgeResponse<Object> getDocumentById(@PathVariable("repo_id") String repoId, @PathVariable("document_id") String documentId);

    /**
     * Document metadata 변경시 metadata 수정 및 document indexing 실행
     *
     * @param repoId Repository ID
     * @param documentId Document ID
     * @param request 메타데이터 요청
     * @return Document 메타데이터 업데이트 응답
     */
    @PostMapping("/repos/{repo_id}/documents/{document_id}")
    KnowledgeResponse<Object> updateDocumentMetadata(@PathVariable("repo_id") String repoId, @PathVariable("document_id") String documentId, @RequestBody DocumentMetadataRequest request);

    /**
     * Document enable/disable 수정
     *
     * @param repoId Repository ID
     * @param documentId Document ID
     * @param isActive 활성 상태
     * @return Document 활성 상태 수정 응답
     */
    @PutMapping("/repos/{repo_id}/documents/{document_id}")
    KnowledgeResponse<Object> updateDocumentActive(@PathVariable("repo_id") String repoId, @PathVariable("document_id") String documentId, @RequestParam("is_active") Boolean isActive);

    /**
     * Document 삭제 (단일)
     *
     * @param repoId Repository ID
     * @param documentId Document ID
     */
    @DeleteMapping("/repos/{repo_id}/documents/{document_id}")
    void deleteDocument(@PathVariable("repo_id") String repoId, @PathVariable("document_id") String documentId);

    /**
     * Document indexing
     *
     * @param repoId Repository ID
     * @param documentId Document ID
     * @param targetStep 대상 단계 (기본값: embedding_and_indexing)
     * @return Document 인덱싱 응답
     */
    @PostMapping("/repos/{repo_id}/documents/{document_id}/indexing")
    KnowledgeResponse<Object> indexingDocument(@PathVariable("repo_id") String repoId, @PathVariable("document_id") String documentId, @RequestParam(name = "target_step", defaultValue = "embedding_and_indexing") String targetStep);

    /**
     * Document load, chunk, embedding 등 작업 이력 조회
     *
     * @param repoId Repository ID
     * @param documentId Document ID
     * @param page 페이지 번호 (기본값: 1)
     * @param size 페이지 크기 (기본값: 10)
     * @param sort 정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return Document 이력 응답
     */
    @GetMapping("/repos/{repo_id}/documents/{document_id}/history")
    KnowledgeResponse<Object> getDocumentHistory(
        @PathVariable("repo_id") String repoId,
        @PathVariable("document_id") String documentId,
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size,
        @RequestParam(required = false) String sort,
        @RequestParam(required = false) String filter,
        @RequestParam(required = false) String search
    );

    /**
     * Document Chunk 목록 조회
     *
     * @param repoId Repository ID
     * @param documentId Document ID
     * @param page 페이지 번호 (기본값: 1)
     * @param size 페이지 크기 (기본값: 10)
     * @param sort 정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return Chunk 목록 응답
     */
    @GetMapping("/repos/{repo_id}/documents/{document_id}/chunks")
    KnowledgeResponse<Object> getDocumentChunks(
        @PathVariable("repo_id") String repoId,
        @PathVariable("document_id") String documentId,
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size,
        @RequestParam(required = false) String sort,
        @RequestParam(required = false) String filter,
        @RequestParam(required = false) String search
    );
}
