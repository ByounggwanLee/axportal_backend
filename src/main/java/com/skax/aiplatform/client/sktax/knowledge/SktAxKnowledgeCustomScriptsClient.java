package com.skax.aiplatform.client.sktax.knowledge;

import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import com.skax.aiplatform.client.sktax.knowledge.dto.response.MultiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * SKT AI Platform Knowledge Custom Scripts API Client
 * 
 * <p>Custom Script 관리 기능을 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@FeignClient(
    name = "skt-ax-knowledge-custom-scripts",
    url = "${sktax.knowledge.url:https://aip-stg.sktai.io}",
    configuration = SktAxFeignConfig.class
)
public interface SktAxKnowledgeCustomScriptsClient {

    /**
     * Custom script 목록 조회
     * 
     * @param page 페이지 번호
     * @param size 페이지 크기
     * @param sort 정렬 조건
     * @param filter 필터 조건
     * @param search 검색어
     * @param customScriptType Custom Script 타입
     * @return Custom Script 목록
     */
    @GetMapping("/api/v1/knowledge/custom_scripts")
    MultiResponse getCustomScripts(
        @RequestParam(value = "page", defaultValue = "1") Integer page,
        @RequestParam(value = "size", defaultValue = "10") Integer size,
        @RequestParam(value = "sort", required = false) String sort,
        @RequestParam(value = "filter", required = false) String filter,
        @RequestParam(value = "search", required = false) String search,
        @RequestParam(value = "custom_script_type", required = false) String customScriptType
    );

    /**
     * Custom script 등록
     * 
     * @param name 이름
     * @param description 설명
     * @param scriptType 스크립트 타입
     * @param script 커스텀 스크립트 파일
     * @param policy 정책 설정
     * @return 생성된 Custom Script 정보
     */
    @PostMapping(value = "/api/v1/knowledge/custom_scripts", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Object createCustomScript(
        @RequestPart("name") String name,
        @RequestPart("description") String description,
        @RequestPart("script_type") String scriptType,
        @RequestPart("script") MultipartFile script,
        @RequestPart(value = "policy", required = false) String policy
    );

    /**
     * Custom loader script test
     * 
     * @param documentFile 처리 검토 문서 파일
     * @param fileMetadata 커스텀 파일 메타데이터 파일
     * @param loaderScriptFile 로더 스크립트 파일
     * @return 테스트 결과
     */
    @PostMapping(value = "/api/v1/knowledge/custom_scripts/test/loader", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Object testLoaderScript(
        @RequestPart("document_file") MultipartFile documentFile,
        @RequestPart(value = "file_metadata", required = false) String fileMetadata,
        @RequestPart("loader_script_file") MultipartFile loaderScriptFile
    );

    /**
     * Custom splitter script test
     * 
     * @param documentFile 처리 검토 문서 파일
     * @param fileMetadata 커스텀 파일 메타데이터 파일
     * @param loaderType 로더 타입
     * @param customLoaderId 커스텀 로더 스크립트 ID
     * @param toolId Ingestion Tool ID
     * @param splitterScriptFile 분할기 스크립트 파일
     * @return 테스트 결과
     */
    @PostMapping(value = "/api/v1/knowledge/custom_scripts/test/splitter", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Object testSplitterScript(
        @RequestPart("document_file") MultipartFile documentFile,
        @RequestPart(value = "file_metadata", required = false) String fileMetadata,
        @RequestPart("loader_type") String loaderType,
        @RequestPart(value = "custom_loader_id", required = false) String customLoaderId,
        @RequestPart(value = "tool_id", required = false) String toolId,
        @RequestPart("splitter_script_file") MultipartFile splitterScriptFile
    );

    /**
     * Custom script 단건 조회
     * 
     * @param scriptId Script ID
     * @return Custom Script 정보
     */
    @GetMapping("/api/v1/knowledge/custom_scripts/{script_id}")
    Object getCustomScript(@PathVariable("script_id") String scriptId);

    /**
     * Custom script 수정
     * 
     * @param scriptId Script ID
     * @param name 이름
     * @param description 설명
     * @param script 커스텀 스크립트 파일
     * @return 수정된 Custom Script 정보
     */
    @PutMapping(value = "/api/v1/knowledge/custom_scripts/{script_id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Object updateCustomScript(
        @PathVariable("script_id") String scriptId,
        @RequestPart(value = "name", required = false) String name,
        @RequestPart(value = "description", required = false) String description,
        @RequestPart(value = "script", required = false) MultipartFile script
    );

    /**
     * Custom script 삭제
     * 
     * @param scriptId Script ID
     */
    @DeleteMapping("/api/v1/knowledge/custom_scripts/{script_id}")
    void deleteCustomScript(@PathVariable("script_id") String scriptId);
}
