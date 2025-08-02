package com.skax.aiplatform.client.sktax.agent;

import com.skax.aiplatform.client.sktax.agent.dto.request.FewShotsCreateRequest;
import com.skax.aiplatform.client.sktax.agent.dto.request.FewShotsUpdateRequest;
import com.skax.aiplatform.client.sktax.agent.dto.request.FewShotCommentCreateRequest;
import com.skax.aiplatform.client.sktax.agent.dto.response.CommonResponse;
import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import jakarta.validation.Valid;

/**
 * SKTAX Agent Few-Shots 관리 Feign Client
 * 
 * <p>Few-Shot 예제 데이터 관리를 위한 클라이언트입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@FeignClient(
    name = "sktax-agent-fewshots", 
    url = "${sktax.agent.url:https://aip-stg.sktai.io}",
    path = "/api/v1/agent",
    configuration = SktAxFeignConfig.class
)
public interface SktAxAgentFewShotsClient {

    /**
     * Few-Shot 목록 조회
     */
    @GetMapping("/few-shots")
    CommonResponse getFewShots(
        @RequestParam(value = "project_id", defaultValue = "d89a7451-3d40-4bab-b4ee-6aecd55b4f32") String projectId,
        @RequestParam(value = "page", defaultValue = "1") Integer page,
        @RequestParam(value = "size", defaultValue = "10") Integer size,
        @RequestParam(value = "sort", required = false) String sort,
        @RequestParam(value = "filter", required = false) String filter,
        @RequestParam(value = "search", required = false) String search
    );

    /**
     * Few-Shot 생성
     */
    @PostMapping("/few-shots")
    CommonResponse createFewShot(@Valid @RequestBody FewShotsCreateRequest request);

    /**
     * Few-Shot 상세 조회
     */
    @GetMapping("/few-shots/{few_shot_uuid}")
    CommonResponse getFewShot(@PathVariable("few_shot_uuid") String fewShotUuid);

    /**
     * Few-Shot 수정
     */
    @PutMapping("/few-shots/{few_shot_uuid}")
    CommonResponse updateFewShot(
        @PathVariable("few_shot_uuid") String fewShotUuid,
        @Valid @RequestBody FewShotsUpdateRequest request
    );

    /**
     * Few-Shot 삭제
     */
    @DeleteMapping("/few-shots/{few_shot_uuid}")
    void deleteFewShot(@PathVariable("few_shot_uuid") String fewShotUuid);

    /**
     * Few-Shot 최신 버전 조회
     */
    @GetMapping("/few-shots/versions/{few_shot_uuid}/latest")
    CommonResponse getLatestFewShotVersion(@PathVariable("few_shot_uuid") String fewShotUuid);

    /**
     * Few-Shot 버전 목록 조회
     */
    @GetMapping("/few-shots/versions/{few_shot_uuid}")
    CommonResponse getFewShotVersions(@PathVariable("few_shot_uuid") String fewShotUuid);

    /**
     * Few-Shot 아이템 목록 조회
     */
    @GetMapping("/few-shots/items/{version_id}")
    CommonResponse getFewShotItems(
        @PathVariable("version_id") String versionId,
        @RequestParam(value = "page", defaultValue = "1") Integer page,
        @RequestParam(value = "size", defaultValue = "10") Integer size,
        @RequestParam(value = "sort", required = false) String sort,
        @RequestParam(value = "filter", required = false) String filter,
        @RequestParam(value = "search", required = false) String search
    );

    /**
     * Few-Shot 의존성 조회
     */
    @GetMapping("/few-shots/dependency/{version_id}")
    CommonResponse getFewShotDependency(@PathVariable("version_id") String versionId);

    /**
     * Few-Shot 태그 조회 (버전별)
     */
    @GetMapping("/few-shots/tags/{version_id}")
    CommonResponse getFewShotTagsByVersion(@PathVariable("version_id") String versionId);

    /**
     * Few-Shot 태그 목록 조회
     */
    @GetMapping("/few-shots/list/tags")
    CommonResponse getFewShotTags();

    /**
     * Few-Shot 댓글 목록 조회
     */
    @GetMapping("/few-shots/comments/{version_id}")
    CommonResponse getFewShotComments(
        @PathVariable("version_id") String versionId,
        @RequestParam(value = "page", required = false) Integer page,
        @RequestParam(value = "size", defaultValue = "10") Integer size
    );

    /**
     * Few-Shot 댓글 생성
     */
    @PostMapping("/few-shots/comments/{version_id}")
    CommonResponse createFewShotComment(
        @PathVariable("version_id") String versionId,
        @Valid @RequestBody FewShotCommentCreateRequest request
    );

    /**
     * Few-Shot 댓글 수정
     */
    @PutMapping("/few-shots/comments/{comment_uuid}")
    CommonResponse updateFewShotComment(
        @PathVariable("comment_uuid") String commentUuid,
        @Valid @RequestBody FewShotCommentCreateRequest request
    );

    /**
     * Few-Shot 댓글 삭제
     */
    @DeleteMapping("/few-shots/comments/{comment_uuid}")
    void deleteFewShotComment(@PathVariable("comment_uuid") String commentUuid);

    /**
     * Few-Shot Excel 템플릿 내보내기
     */
    @GetMapping("/few-shots/export/templates")
    CommonResponse exportFewShotTemplate();

    /**
     * Few-Shot 데이터 가져오기 (템플릿 기반)
     */
    @PostMapping("/few-shots/import/{version_id}")
    CommonResponse importFewShotData(
        @PathVariable("version_id") String versionId,
        @RequestParam("files") MultipartFile[] files
    );

    /**
     * Few-Shot API 통합 (내부용)
     */
    @GetMapping("/few-shots/api/{few_shot_uuid}")
    CommonResponse getFewShotApi(@PathVariable("few_shot_uuid") String fewShotUuid);

    /**
     * Few-Shot 테스트 및 예제
     */
    @GetMapping("/few-shots/test/{few_shot_uuid}")
    CommonResponse testFewShot(@PathVariable("few_shot_uuid") String fewShotUuid);

    /**
     * Few-Shot 하드 삭제 (마크된 모든 항목)
     */
    @DeleteMapping("/few-shots/hard-delete")
    void hardDeleteFewShots();
}
