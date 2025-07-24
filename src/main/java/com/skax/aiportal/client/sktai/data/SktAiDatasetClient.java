package com.skax.aiportal.client.sktai.data;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.skax.aiportal.client.sktai.data.dto.DatasetTag;
import com.skax.aiportal.client.sktai.data.dto.request.DatasetCreateRequest;
import com.skax.aiportal.client.sktai.data.dto.request.DatasetUpdateRequest;
import com.skax.aiportal.client.sktai.data.dto.response.DatasetListResponse;
import com.skax.aiportal.client.sktai.data.dto.response.DatasetResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * SKT AI 데이터셋 관리 API 클라이언트
 * 
 * <p>SKT AI 플랫폼의 데이터셋 관리 API를 호출합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Tag(name = "SKT AI 데이터셋 API", description = "SKT AI 플랫폼 데이터셋 관리 서비스 연동")
@FeignClient(
    name = "sktAiDatasetClient",
    url = "${sktai.api.base-url:https://aip-stg.sktai.io}",
    configuration = com.skax.aiportal.client.sktai.config.SktAiClientConfig.class
)
public interface SktAiDatasetClient {

    /**
     * 데이터셋 목록 조회 (페이징)
     * 
     * @param page 페이지 번호
     * @param size 페이지 크기
     * @param sort 정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return 데이터셋 목록 응답
     */
    @Operation(summary = "데이터셋 목록 조회", description = "모든 데이터셋을 페이징하여 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "데이터셋 목록 조회 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @GetMapping(value="/api/v1/datasets", produces = "application/json")
    DatasetListResponse getDatasets(
            @Parameter(description = "페이지 번호")
            @RequestParam(value = "page", defaultValue = "1") int page,
            
            @Parameter(description = "페이지 크기") 
            @RequestParam(value = "size", defaultValue = "10") int size,
            
            @Parameter(description = "정렬 기준")
            @RequestParam(value = "sort", required = false) String sort,
            
            @Parameter(description = "필터 조건")
            @RequestParam(value = "filter", required = false) String filter,
            
            @Parameter(description = "검색어")
            @RequestParam(value = "search", required = false) String search
    );

    /**
     * 데이터셋 생성
     * 
     * @param createRequest 데이터셋 생성 요청
     * @return 생성된 데이터셋 정보
     */
    @Operation(summary = "데이터셋 생성", description = "새로운 데이터셋을 생성합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "데이터셋 생성 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @PostMapping("/api/v1/datasets")
    DatasetResponse createDataset(@RequestBody DatasetCreateRequest createRequest);

    /**
     * 특정 데이터셋 조회
     * 
     * @param datasetId 데이터셋 ID
     * @return 데이터셋 상세 정보
     */
    @Operation(summary = "데이터셋 상세 조회", description = "데이터셋 ID로 특정 데이터셋 정보를 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "데이터셋 조회 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @GetMapping("/api/v1/datasets/{dataset_id}")
    DatasetResponse getDatasetById(
            @Parameter(description = "데이터셋 ID", required = true)
            @PathVariable("dataset_id") String datasetId
    );

    /**
     * 데이터셋 정보 수정
     * 
     * @param datasetId 데이터셋 ID
     * @param updateRequest 데이터셋 수정 요청
     * @return 수정된 데이터셋 정보
     */
    @Operation(summary = "데이터셋 정보 수정", description = "데이터셋 정보를 수정합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "데이터셋 수정 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @PutMapping("/api/v1/datasets/{dataset_id}")
    Object updateDataset(
            @Parameter(description = "데이터셋 ID", required = true)
            @PathVariable("dataset_id") String datasetId,
            
            @RequestBody DatasetUpdateRequest updateRequest
    );

    /**
     * 데이터셋 삭제 (소프트 삭제)
     * 
     * @param datasetId 데이터셋 ID
     */
    @Operation(summary = "데이터셋 삭제", description = "데이터셋을 삭제 상태로 표시합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "데이터셋 삭제 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @DeleteMapping("/api/v1/datasets/{dataset_id}")
    void deleteDataset(
            @Parameter(description = "데이터셋 ID", required = true)
            @PathVariable("dataset_id") String datasetId
    );

    /**
     * 모든 삭제된 데이터셋 하드 삭제
     * 
     * @return 삭제 결과
     */
    @Operation(summary = "삭제된 데이터셋 하드 삭제", description = "삭제 상태인 모든 데이터셋을 완전히 제거합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "하드 삭제 성공")
    })
    @PostMapping("/api/v1/datasets/hard-delete")
    Object hardDeleteAllDatasets();

    /**
     * 파일 업로드를 통한 데이터셋 생성
     * 
     * @param file 업로드할 파일
     * @param name 데이터셋 이름
     * @param type 데이터셋 타입
     * @param status 데이터셋 상태
     * @param description 데이터셋 설명
     * @param tags 데이터셋 태그
     * @param projectId 프로젝트 ID
     * @param createdBy 생성자
     * @param updatedBy 수정자
     * @param payload 추가 페이로드
     * @return 생성된 데이터셋 정보
     */
    @Operation(summary = "파일 업로드 데이터셋 생성", description = "파일을 직접 업로드하여 데이터셋을 생성합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "데이터셋 생성 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @PostMapping(value = "/api/v1/datasets/upload/files", consumes = "multipart/form-data")
    DatasetResponse uploadFileDataset(
            @Parameter(description = "업로드할 파일", required = true)
            @RequestParam("file") Object file,
            
            @Parameter(description = "데이터셋 이름", required = true)
            @RequestParam("name") String name,
            
            @Parameter(description = "데이터셋 타입", required = true)
            @RequestParam("type") String type,
            
            @Parameter(description = "데이터셋 상태")
            @RequestParam(value = "status", defaultValue = "processing") String status,
            
            @Parameter(description = "데이터셋 설명")
            @RequestParam(value = "description", required = false) String description,
            
            @Parameter(description = "데이터셋 태그")
            @RequestParam(value = "tags", required = false) String tags,
            
            @Parameter(description = "프로젝트 ID", required = true)
            @RequestParam("project_id") String projectId,
            
            @Parameter(description = "생성자")
            @RequestParam(value = "created_by", required = false) String createdBy,
            
            @Parameter(description = "수정자")
            @RequestParam(value = "updated_by", required = false) String updatedBy,
            
            @Parameter(description = "추가 페이로드")
            @RequestParam(value = "payload", required = false) String payload
    );

    /**
     * 데이터셋 미리보기
     * 
     * @param datasetId 데이터셋 ID
     * @param chunksize 청크 크기
     * @return 데이터셋 미리보기 데이터
     */
    @Operation(summary = "데이터셋 미리보기", description = "데이터셋의 일부 데이터를 미리보기로 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "미리보기 조회 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @GetMapping("/api/v1/datasets/{dataset_id}/previews")
    Object getDatasetPreview(
            @Parameter(description = "데이터셋 ID", required = true)
            @PathVariable("dataset_id") String datasetId,
            
            @Parameter(description = "청크 크기", required = true)
            @RequestParam("chunksize") int chunksize
    );

    /**
     * 데이터셋 태그 업데이트
     * 
     * @param datasetId 데이터셋 ID
     * @param tags 태그 목록
     * @return 업데이트된 데이터셋 정보
     */
    @Operation(summary = "데이터셋 태그 업데이트", description = "데이터셋의 태그 정보를 업데이트합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "태그 업데이트 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @PutMapping("/api/v1/datasets/{dataset_id}/tags")
    DatasetResponse updateDatasetTags(
            @Parameter(description = "데이터셋 ID", required = true)
            @PathVariable("dataset_id") String datasetId,
            @RequestBody List<DatasetTag> tags
    );

    /**
     * 데이터셋 태그 삭제
     * 
     * @param datasetId 데이터셋 ID
     * @param tags 삭제할 태그 목록
     * @return 업데이트된 데이터셋 정보
     */
    @Operation(summary = "데이터셋 태그 삭제", description = "데이터셋의 특정 태그들을 삭제합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "태그 삭제 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @DeleteMapping("/api/v1/datasets/{dataset_id}/tags")
    DatasetResponse deleteDatasetTags(
            @Parameter(description = "데이터셋 ID", required = true)
            @PathVariable("dataset_id") String datasetId,
            
            @RequestBody List<DatasetTag> tags
    );
}
