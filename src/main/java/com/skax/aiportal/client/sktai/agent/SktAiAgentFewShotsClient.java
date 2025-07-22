package com.skax.aiportal.client.sktai.agent;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.skax.aiportal.client.sktai.agent.dto.request.FewShotCommentCreateRequest;
import com.skax.aiportal.client.sktai.agent.dto.request.FewShotsCreateRequest;
import com.skax.aiportal.client.sktai.agent.dto.request.FewShotsUpdateRequest;
import com.skax.aiportal.client.sktai.agent.dto.response.CommonResponse;
import com.skax.aiportal.client.sktai.config.SktAiClientConfig;

/**
 * SKT AI Agent FewShots 관리 API Feign 클라이언트
 *
 * <p>Few-shot 예시 데이터의 생성, 조회, 수정, 삭제 및 버전 관리 기능을 제공합니다.</p>
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@FeignClient(
    name = "skt-ai-agent-fewshots",
    url = "${skt.ai.agent.url:https://aip-stg.sktai.io}",
    path = "/api/v1/agent",
    configuration = SktAiClientConfig.class
)
public interface SktAiAgentFewShotsClient {

    /**
     * FewShots 목록 조회
     *
     * @param projectId 프로젝트 ID
     * @param page 페이지 번호 (기본값: 1)
     * @param size 페이지 크기 (기본값: 10)
     * @param sort 정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return FewShots 목록 응답
     */
    @GetMapping("/few-shots")
    CommonResponse getAllFewShots(
        @RequestParam(name = "project_id", required = false) String projectId,
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size,
        @RequestParam(required = false) String sort,
        @RequestParam(required = false) String filter,
        @RequestParam(required = false) String search
    );

    /**
     * FewShots 생성
     *
     * @param request FewShots 생성 요청
     * @return FewShots 생성 응답
     */
    @PostMapping("/few-shots")
    CommonResponse createFewShots(@RequestBody FewShotsCreateRequest request);

    /**
     * FewShots 상세 조회
     *
     * @param fewShotUuid FewShot UUID
     * @return FewShots 상세 정보 응답
     */
    @GetMapping("/few-shots/{few_shot_uuid}")
    CommonResponse getFewShots(@PathVariable("few_shot_uuid") String fewShotUuid);

    /**
     * FewShots 수정
     *
     * @param fewShotUuid FewShot UUID
     * @param request FewShots 수정 요청
     * @return FewShots 수정 응답
     */
    @PutMapping("/few-shots/{few_shot_uuid}")
    CommonResponse updateFewShots(@PathVariable("few_shot_uuid") String fewShotUuid, @RequestBody FewShotsUpdateRequest request);

    /**
     * FewShots 삭제 (soft delete)
     *
     * @param fewShotUuid FewShot UUID
     */
    @DeleteMapping("/few-shots/{few_shot_uuid}")
    void deleteFewShots(@PathVariable("few_shot_uuid") String fewShotUuid);

    /**
     * FewShots Excel 템플릿 내보내기
     *
     * @return Excel 템플릿 응답
     */
    @GetMapping("/few-shots/export/templates")
    CommonResponse exportTemplates();

    /**
     * FewShots 템플릿 기반 가져오기
     *
     * @param versionId 버전 ID
     * @param files 업로드할 파일들
     * @return 가져오기 응답
     */
    @PostMapping(value = "/few-shots/import/{version_id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    CommonResponse importTemplates(
        @PathVariable("version_id") String versionId,
        @RequestPart("files") MultipartFile[] files
    );

    /**
     * FewShots 최신 버전 조회
     *
     * @param fewShotUuid FewShot UUID
     * @return 최신 버전 FewShots 응답
     */
    @GetMapping("/few-shots/versions/{few_shot_uuid}/latest")
    CommonResponse getLatestVersion(@PathVariable("few_shot_uuid") String fewShotUuid);

    /**
     * FewShots 아이템 조회
     *
     * @param versionId 버전 ID
     * @param page 페이지 번호 (기본값: 1)
     * @param size 페이지 크기 (기본값: 10)
     * @param sort 정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return FewShots 아이템 응답
     */
    @GetMapping("/few-shots/items/{version_id}")
    CommonResponse getItems(
        @PathVariable("version_id") String versionId,
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size,
        @RequestParam(required = false) String sort,
        @RequestParam(required = false) String filter,
        @RequestParam(required = false) String search
    );

    /**
     * FewShots 의존성 조회
     *
     * @param versionId 버전 ID
     * @return FewShots 의존성 응답
     */
    @GetMapping("/few-shots/dependency/{version_id}")
    CommonResponse getDependency(@PathVariable("version_id") String versionId);

    /**
     * FewShots 태그 조회 (버전별)
     *
     * @param versionId 버전 ID
     * @return FewShots 태그 응답
     */
    @GetMapping("/few-shots/tags/{version_id}")
    CommonResponse getTagsByVersion(@PathVariable("version_id") String versionId);

    /**
     * 전체 FewShots 태그 목록 조회
     *
     * @return 전체 FewShots 태그 목록 응답
     */
    @GetMapping("/few-shots/list/tags")
    CommonResponse getTags();

    /**
     * FewShots 댓글 목록 조회
     *
     * @param versionId 버전 ID
     * @param page 페이지 번호
     * @param size 페이지 크기 (기본값: 10)
     * @return 댓글 목록 응답
     */
    @GetMapping("/few-shots/comments/{version_id}")
    CommonResponse getComments(
        @PathVariable("version_id") String versionId,
        @RequestParam(required = false) Integer page,
        @RequestParam(defaultValue = "10") Integer size
    );

    /**
     * FewShots 댓글 생성
     *
     * @param versionId 버전 ID
     * @param request 댓글 생성 요청
     * @return 댓글 생성 응답
     */
    @PostMapping("/few-shots/comments/{version_id}")
    CommonResponse createComment(@PathVariable("version_id") String versionId, @RequestBody FewShotCommentCreateRequest request);

    /**
     * FewShots 버전 목록 조회
     *
     * @param fewShotUuid FewShot UUID
     * @return FewShots 버전 목록 응답
     */
    @GetMapping("/few-shots/versions/{few_shot_uuid}")
    CommonResponse getVersionList(@PathVariable("few_shot_uuid") String fewShotUuid);

    /**
     * FewShots 댓글 수정
     *
     * @param commentUuid 댓글 UUID
     * @param request 댓글 수정 요청
     * @return 댓글 수정 응답
     */
    @PutMapping("/few-shots/comments/{comment_uuid}")
    CommonResponse updateComment(@PathVariable("comment_uuid") String commentUuid, @RequestBody FewShotCommentCreateRequest request);

    /**
     * FewShots 댓글 삭제
     *
     * @param commentUuid 댓글 UUID
     */
    @DeleteMapping("/few-shots/comments/{comment_uuid}")
    void deleteComment(@PathVariable("comment_uuid") String commentUuid);

    /**
     * FewShots API 조회 (내부 연동용)
     *
     * @param fewShotUuid FewShot UUID
     * @return FewShots API 응답
     */
    @GetMapping("/few-shots/api/{few_shot_uuid}")
    CommonResponse getFewShotsApi(@PathVariable("few_shot_uuid") String fewShotUuid);

    /**
     * FewShots 테스트 (통합 예제)
     *
     * @param fewShotUuid FewShot UUID
     * @return FewShots 테스트 응답
     */
    @GetMapping("/few-shots/test/{few_shot_uuid}")
    CommonResponse testFewShots(@PathVariable("few_shot_uuid") String fewShotUuid);

    /**
     * 삭제 표시된 모든 FewShots 완전 삭제 (hard delete)
     */
    @DeleteMapping("/few-shots/hard-delete")
    void hardDeleteFewShots();
}
