package com.skax.aiportal.client.sktai.knowledge;

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

import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import com.skax.aiportal.client.sktai.knowledge.dto.response.KnowledgeResponse;

/**
 * SKT AI Knowledge Custom Scripts 관리 API Feign 클라이언트
 *
 * <p>커스텀 스크립트의 생성, 수정, 삭제, 조회 및 테스트 기능을 제공합니다.</p>
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@FeignClient(
    name = "skt-ai-knowledge-custom-scripts",
    url = "${skt.ai.knowledge.url:https://aip-stg.sktai.io}",
    path = "/api/v1/knowledge",
    configuration = SktAiClientConfig.class
)
public interface SktAiKnowledgeCustomScriptsClient {

    /**
     * Custom script 목록 조회
     *
     * @param page 페이지 번호 (기본값: 1)
     * @param size 페이지 크기 (기본값: 10)
     * @param sort 정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @param customScriptType 커스텀 스크립트 타입 (loader, splitter)
     * @return Custom script 목록 응답
     */
    @GetMapping("/custom_scripts")
    KnowledgeResponse<Object> getCustomScripts(
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size,
        @RequestParam(required = false) String sort,
        @RequestParam(required = false) String filter,
        @RequestParam(required = false) String search,
        @RequestParam(name = "custom_script_type", required = false) String customScriptType
    );

    /**
     * Custom script 등록
     *
     * @param name 이름
     * @param description 설명
     * @param scriptType 스크립트 타입
     * @param script 커스텀 스크립트 파일
     * @param policy 정책 설정
     * @return Custom script 생성 응답
     */
    @PostMapping(value = "/custom_scripts", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    KnowledgeResponse<Object> createCustomScript(
        @RequestPart("name") String name,
        @RequestPart("description") String description,
        @RequestPart("script_type") String scriptType,
        @RequestPart("script") MultipartFile script,
        @RequestPart(value = "policy", required = false) String policy
    );

    /**
     * Custom script 단건 조회
     *
     * @param scriptId Script ID
     * @return Custom script 상세 정보 응답
     */
    @GetMapping("/custom_scripts/{script_id}")
    KnowledgeResponse<Object> getCustomScriptById(@PathVariable("script_id") String scriptId);

    /**
     * Custom script 수정
     *
     * @param scriptId Script ID
     * @param name 이름
     * @param description 설명
     * @param script 커스텀 스크립트 파일
     * @return Custom script 수정 응답
     */
    @PutMapping(value = "/custom_scripts/{script_id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    KnowledgeResponse<Object> updateCustomScript(
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
    @DeleteMapping("/custom_scripts/{script_id}")
    void deleteCustomScript(@PathVariable("script_id") String scriptId);

    /**
     * Custom loader script test
     *
     * @param documentFile 처리 검토 문서 파일
     * @param fileMetadata 커스텀 파일 메타데이터 파일 (JSON)
     * @param loaderScriptFile 로더 스크립트 파일
     * @return 로더 스크립트 테스트 결과
     */
    @PostMapping(value = "/custom_scripts/test/loader", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    KnowledgeResponse<Object> testLoaderScript(
        @RequestPart("document_file") MultipartFile documentFile,
        @RequestPart(value = "file_metadata", required = false) String fileMetadata,
        @RequestPart("loader_script_file") MultipartFile loaderScriptFile
    );

    /**
     * Custom splitter script test
     *
     * @param documentFile 처리 검토 문서 파일
     * @param fileMetadata 커스텀 파일 메타데이터 파일 (JSON)
     * @param loaderType 로더 타입
     * @param customLoaderId 커스텀 로더 스크립트 ID (로더 타입이 CustomLoader인 경우 필수)
     * @param toolId Ingestion Tool ID (로더 타입이 DataIngestionTool인 경우 필수)
     * @param splitterScriptFile 스플리터 스크립트 파일
     * @return 스플리터 스크립트 테스트 결과
     */
    @PostMapping(value = "/custom_scripts/test/splitter", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    KnowledgeResponse<Object> testSplitterScript(
        @RequestPart("document_file") MultipartFile documentFile,
        @RequestPart(value = "file_metadata", required = false) String fileMetadata,
        @RequestPart("loader_type") String loaderType,
        @RequestPart(value = "custom_loader_id", required = false) String customLoaderId,
        @RequestPart(value = "tool_id", required = false) String toolId,
        @RequestPart("splitter_script_file") MultipartFile splitterScriptFile
    );
}
