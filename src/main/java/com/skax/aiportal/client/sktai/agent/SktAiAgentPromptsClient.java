package com.skax.aiportal.client.sktai.agent;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.skax.aiportal.client.sktai.agent.dto.request.PromptCommentCreateRequest;
import com.skax.aiportal.client.sktai.agent.dto.request.PromptCopyRequest;
import com.skax.aiportal.client.sktai.agent.dto.request.PromptCreateRequest;
import com.skax.aiportal.client.sktai.agent.dto.request.PromptUpdateRequest;
import com.skax.aiportal.client.sktai.agent.dto.response.CommonResponse;
import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.interceptor.SktAiAuthInterceptor;
import com.skax.aiportal.client.sktai.interceptor.SktAiLoggingInterceptor;

/**
 * SKT AI Agent Inference Prompt 관리 API Feign 클라이언트
 *
 * <p>추론용 프롬프트의 생성, 조회, 수정, 삭제 및 버전 관리 기능을 제공합니다.</p>
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@FeignClient(
    name = "skt-ai-agent-prompts", url = "${sktai.api.base-url:https://aip-stg.sktai.io}", configuration = {
        SktAiClientConfig.class,
        SktAiAuthInterceptor.class,
        SktAiLoggingInterceptor.class
})
public interface SktAiAgentPromptsClient {

    /**
     * Prompt 목록 조회
     *
     * @param projectId 프로젝트 ID
     * @param page 페이지 번호 (기본값: 1)
     * @param size 페이지 크기 (기본값: 10)
     * @param sort 정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return Prompt 목록 응답
     */
    @GetMapping("/inference-prompts")
    CommonResponse getAllPrompts(
        @RequestParam(name = "project_id", required = false) String projectId,
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size,
        @RequestParam(required = false) String sort,
        @RequestParam(required = false) String filter,
        @RequestParam(required = false) String search
    );

    /**
     * Prompt 생성
     *
     * @param request Prompt 생성 요청
     * @return Prompt 생성 응답
     */
    @PostMapping("/inference-prompts")
    CommonResponse createPrompt(@RequestBody PromptCreateRequest request);

    /**
     * Prompt 상세 조회
     *
     * @param promptUuid Prompt UUID
     * @return Prompt 상세 정보 응답
     */
    @GetMapping("/inference-prompts/{prompt_uuid}")
    CommonResponse getPrompt(@PathVariable("prompt_uuid") String promptUuid);

    /**
     * Prompt 수정
     *
     * @param promptUuid Prompt UUID
     * @param request Prompt 수정 요청
     * @return Prompt 수정 응답
     */
    @PutMapping("/inference-prompts/{prompt_uuid}")
    CommonResponse updatePrompt(@PathVariable("prompt_uuid") String promptUuid, @RequestBody PromptUpdateRequest request);

    /**
     * Prompt 삭제 (soft delete)
     *
     * @param promptUuid Prompt UUID
     */
    @DeleteMapping("/inference-prompts/{prompt_uuid}")
    void deletePrompt(@PathVariable("prompt_uuid") String promptUuid);

    /**
     * Prompt 최신 버전 조회
     *
     * @param promptUuid Prompt UUID
     * @return 최신 버전 Prompt 응답
     */
    @GetMapping("/inference-prompts/versions/{prompt_uuid}/latest")
    CommonResponse getLatestVersion(@PathVariable("prompt_uuid") String promptUuid);

    /**
     * Prompt 버전 목록 조회
     *
     * @param promptUuid Prompt UUID
     * @return Prompt 버전 목록 응답
     */
    @GetMapping("/inference-prompts/versions/{prompt_uuid}")
    CommonResponse getVersionList(@PathVariable("prompt_uuid") String promptUuid);

    /**
     * Prompt 메시지 조회
     *
     * @param versionId 버전 ID
     * @return Prompt 메시지 응답
     */
    @GetMapping("/inference-prompts/messages/{version_id}")
    CommonResponse getPromptMessages(@PathVariable("version_id") String versionId);

    /**
     * Prompt 변수 조회
     *
     * @param versionId 버전 ID
     * @return Prompt 변수 응답
     */
    @GetMapping("/inference-prompts/variables/{version_id}")
    CommonResponse getPromptVariables(@PathVariable("version_id") String versionId);

    /**
     * Prompt 태그 조회 (버전별)
     *
     * @param versionId 버전 ID
     * @return Prompt 태그 응답
     */
    @GetMapping("/inference-prompts/tags/{version_id}")
    CommonResponse getPromptTagsByVersion(@PathVariable("version_id") String versionId);

    /**
     * 전체 Prompt 태그 목록 조회
     *
     * @return 전체 Prompt 태그 목록 응답
     */
    @GetMapping("/inference-prompts/list/tags")
    CommonResponse getPromptTags();

    /**
     * 태그로 Prompt 검색
     *
     * @param filters 태그 필터
     * @return 태그별 Prompt 목록 응답
     */
    @GetMapping("/inference-prompts/search/tags")
    CommonResponse getPromptsByTags(@RequestParam String filters);

    /**
     * Prompt 복사
     *
     * @param promptUuid Prompt UUID
     * @param request Prompt 복사 요청
     * @return Prompt 복사 응답
     */
    @PostMapping("/inference-prompts/copy/{prompt_uuid}")
    CommonResponse copyPrompt(@PathVariable("prompt_uuid") String promptUuid, @RequestBody PromptCopyRequest request);

    /**
     * Prompt 댓글 목록 조회
     *
     * @param versionId 버전 ID
     * @param page 페이지 번호
     * @param size 페이지 크기 (기본값: 10)
     * @return 댓글 목록 응답
     */
    @GetMapping("/inference-prompts/comments/{version_id}")
    CommonResponse getComments(
        @PathVariable("version_id") String versionId,
        @RequestParam(required = false) Integer page,
        @RequestParam(defaultValue = "10") Integer size
    );

    /**
     * Prompt 댓글 생성
     *
     * @param versionId 버전 ID
     * @param request 댓글 생성 요청
     * @return 댓글 생성 응답
     */
    @PostMapping("/inference-prompts/comments/{version_id}")
    CommonResponse createComment(@PathVariable("version_id") String versionId, @RequestBody PromptCommentCreateRequest request);

    /**
     * Prompt 댓글 수정
     *
     * @param commentUuid 댓글 UUID
     * @param request 댓글 수정 요청
     * @return 댓글 수정 응답
     */
    @PutMapping("/inference-prompts/comments/{comment_uuid}")
    CommonResponse updateComment(@PathVariable("comment_uuid") String commentUuid, @RequestBody PromptCommentCreateRequest request);

    /**
     * Prompt 댓글 삭제
     *
     * @param commentUuid 댓글 UUID
     */
    @DeleteMapping("/inference-prompts/comments/{comment_uuid}")
    void deleteComment(@PathVariable("comment_uuid") String commentUuid);

    /**
     * Prompt 버전 삭제
     *
     * @param versionId 버전 ID
     */
    @DeleteMapping("/inference-prompts/versions/{version_id}")
    void deleteVersion(@PathVariable("version_id") String versionId);

    /**
     * Prompt API 조회 (내부 연동용)
     *
     * @param promptUuid Prompt UUID
     * @return Prompt API 응답
     */
    @GetMapping("/inference-prompts/api/{prompt_uuid}")
    CommonResponse getPromptApi(@PathVariable("prompt_uuid") String promptUuid);

    /**
     * Prompt 변수 검증 API (내부 연동용)
     *
     * @param promptUuid Prompt UUID
     * @return Prompt 변수 검증 응답
     */
    @GetMapping("/inference-prompts/api/variables/{prompt_uuid}")
    CommonResponse getPromptVariablesApi(@PathVariable("prompt_uuid") String promptUuid);

    /**
     * Prompt 테스트 (통합 예제)
     *
     * @param promptUuid Prompt UUID
     * @return Prompt 테스트 응답
     */
    @GetMapping("/inference-prompts/test/{prompt_uuid}")
    CommonResponse testPrompt(@PathVariable("prompt_uuid") String promptUuid);

    /**
     * Prompt 변수 검증 테스트
     *
     * @param promptUuid Prompt UUID
     * @param request 변수 검증 요청
     * @return 변수 검증 테스트 응답
     */
    @PostMapping("/inference-prompts/test/variables/{prompt_uuid}")
    CommonResponse testPromptVariables(@PathVariable("prompt_uuid") String promptUuid, @RequestBody Object request);

    /**
     * 태그로 Prompt ID 조회 테스트
     *
     * @param filters 태그 필터 (기본값: "agent,built-in")
     * @return 태그별 Prompt ID 테스트 응답
     */
    @GetMapping("/inference-prompts/test-search-tags/from-tags")
    CommonResponse testPromptFromTags(@RequestParam(defaultValue = "agent,built-in") String filters);

    /**
     * 내장 Prompt 템플릿 조회
     *
     * @return 내장 Prompt 템플릿 목록 응답
     */
    @GetMapping("/inference-prompts/templates/builtin")
    CommonResponse getBuiltinTemplates();

    /**
     * 삭제 표시된 모든 Prompt 완전 삭제 (hard delete)
     */
    @DeleteMapping("/inference-prompts/hard-delete")
    void hardDeletePrompts();
}
