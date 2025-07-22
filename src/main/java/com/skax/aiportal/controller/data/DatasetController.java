package com.skax.aiportal.controller.data;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.skax.aiportal.dto.data.request.DatasetCreateRequest;
import com.skax.aiportal.dto.data.request.DatasetUpdateRequest;
import com.skax.aiportal.dto.data.request.DatasetUploadRequest;
import com.skax.aiportal.dto.data.request.DatasetTagUpdateRequest;
import com.skax.aiportal.dto.data.response.DatasetResponse;
import com.skax.aiportal.dto.data.response.DatasetListResponse;
import com.skax.aiportal.dto.data.response.DatasetPreviewResponse;
import com.skax.aiportal.service.data.DatasetService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 데이터셋 관리 컨트롤러
 * 
 * <p>데이터셋 관련 REST API 엔드포인트를 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/datasets")
@RequiredArgsConstructor
@Tag(name = "데이터셋 관리", description = "데이터셋 관리 API")
public class DatasetController {

    private final DatasetService datasetService;

    /**
     * 데이터셋 목록 조회 (페이징)
     * 
     * @param page 페이지 번호 (1부터 시작)
     * @param size 페이지 크기
     * @param sort 정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return 데이터셋 목록 응답
     */
    @GetMapping
    @Operation(summary = "데이터셋 목록 조회", description = "모든 데이터셋을 페이징하여 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "데이터셋 목록 조회 성공"),
        @ApiResponse(responseCode = "400", description = "잘못된 요청"),
        @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    public ResponseEntity<DatasetListResponse> getDatasets(
            @Parameter(description = "페이지 번호", example = "1")
            @RequestParam(value = "page", defaultValue = "1") int page,
            
            @Parameter(description = "페이지 크기", example = "10")
            @RequestParam(value = "size", defaultValue = "10") int size,
            
            @Parameter(description = "정렬 기준", example = "created_at:desc")
            @RequestParam(value = "sort", required = false) String sort,
            
            @Parameter(description = "필터 조건", example = "status:completed")
            @RequestParam(value = "filter", required = false) String filter,
            
            @Parameter(description = "검색어", example = "dataset")
            @RequestParam(value = "search", required = false) String search) {
        
        log.info("데이터셋 목록 조회 요청 - page: {}, size: {}, sort: {}, filter: {}, search: {}", 
                page, size, sort, filter, search);
        
        DatasetListResponse response = datasetService.getDatasets(page, size, sort, filter, search);
        
        log.info("데이터셋 목록 조회 완료 - 조회된 데이터셋 수: {}", 
                response.getData() != null ? response.getData().size() : 0);
        
        return ResponseEntity.ok(response);
    }

    /**
     * 데이터셋 상세 조회
     * 
     * @param datasetId 데이터셋 ID
     * @return 데이터셋 상세 정보
     */
    @GetMapping("/{datasetId}")
    @Operation(summary = "데이터셋 상세 조회", description = "데이터셋 ID로 특정 데이터셋 정보를 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "데이터셋 조회 성공"),
        @ApiResponse(responseCode = "404", description = "데이터셋을 찾을 수 없음"),
        @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    public ResponseEntity<DatasetResponse> getDatasetById(
            @Parameter(description = "데이터셋 ID", required = true, example = "dataset-123")
            @PathVariable String datasetId) {
        
        log.info("데이터셋 상세 조회 요청 - datasetId: {}", datasetId);
        
        DatasetResponse response = datasetService.getDatasetById(datasetId);
        
        log.info("데이터셋 상세 조회 완료 - datasetId: {}, name: {}", datasetId, response.getName());
        
        return ResponseEntity.ok(response);
    }

    /**
     * 데이터셋 생성
     * 
     * @param request 데이터셋 생성 요청
     * @return 생성된 데이터셋 정보
     */
    @PostMapping
    @Operation(summary = "데이터셋 생성", description = "새로운 데이터셋을 생성합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "데이터셋 생성 성공"),
        @ApiResponse(responseCode = "400", description = "잘못된 요청"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류"),
        @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    public ResponseEntity<DatasetResponse> createDataset(
            @Parameter(description = "데이터셋 생성 요청", required = true)
            @Valid @RequestBody DatasetCreateRequest request) {
        
        log.info("데이터셋 생성 요청 - name: {}, type: {}, projectId: {}", 
                request.getName(), request.getType(), request.getProjectId());
        
        DatasetResponse response = datasetService.createDataset(request);
        
        log.info("데이터셋 생성 완료 - id: {}, name: {}", response.getId(), response.getName());
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * 데이터셋 정보 수정
     * 
     * @param datasetId 데이터셋 ID
     * @param request 데이터셋 수정 요청
     * @return 수정된 데이터셋 정보
     */
    @PutMapping("/{datasetId}")
    @Operation(summary = "데이터셋 정보 수정", description = "데이터셋 정보를 수정합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "데이터셋 수정 성공"),
        @ApiResponse(responseCode = "400", description = "잘못된 요청"),
        @ApiResponse(responseCode = "404", description = "데이터셋을 찾을 수 없음"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류"),
        @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    public ResponseEntity<Object> updateDataset(
            @Parameter(description = "데이터셋 ID", required = true, example = "dataset-123")
            @PathVariable String datasetId,
            
            @Parameter(description = "데이터셋 수정 요청", required = true)
            @Valid @RequestBody DatasetUpdateRequest request) {
        
        log.info("데이터셋 수정 요청 - datasetId: {}", datasetId);
        
        Object response = datasetService.updateDataset(datasetId, request);
        
        log.info("데이터셋 수정 완료 - datasetId: {}", datasetId);
        
        return ResponseEntity.ok(response);
    }

    /**
     * 데이터셋 삭제 (소프트 삭제)
     * 
     * @param datasetId 데이터셋 ID
     * @return 삭제 완료 응답
     */
    @DeleteMapping("/{datasetId}")
    @Operation(summary = "데이터셋 삭제", description = "데이터셋을 삭제 상태로 표시합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "데이터셋 삭제 성공"),
        @ApiResponse(responseCode = "404", description = "데이터셋을 찾을 수 없음"),
        @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    public ResponseEntity<Void> deleteDataset(
            @Parameter(description = "데이터셋 ID", required = true, example = "dataset-123")
            @PathVariable String datasetId) {
        
        log.info("데이터셋 삭제 요청 - datasetId: {}", datasetId);
        
        datasetService.deleteDataset(datasetId);
        
        log.info("데이터셋 삭제 완료 - datasetId: {}", datasetId);
        
        return ResponseEntity.noContent().build();
    }

    /**
     * 모든 삭제된 데이터셋 하드 삭제
     * 
     * @return 삭제 결과
     */
    @PostMapping("/hard-delete")
    @Operation(summary = "삭제된 데이터셋 하드 삭제", description = "삭제 상태인 모든 데이터셋을 완전히 제거합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "하드 삭제 성공"),
        @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    public ResponseEntity<Object> hardDeleteAllDatasets() {
        
        log.info("모든 삭제된 데이터셋 하드 삭제 요청");
        
        Object response = datasetService.hardDeleteAllDatasets();
        
        log.info("모든 삭제된 데이터셋 하드 삭제 완료");
        
        return ResponseEntity.ok(response);
    }

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
    @PostMapping(value = "/upload/files", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "파일 업로드 데이터셋 생성", description = "파일을 직접 업로드하여 데이터셋을 생성합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "데이터셋 생성 성공"),
        @ApiResponse(responseCode = "400", description = "잘못된 요청"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류"),
        @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    public ResponseEntity<DatasetResponse> uploadFileDataset(
            @Parameter(description = "업로드할 파일", required = true)
            @RequestParam("file") MultipartFile file,
            
            @Parameter(description = "데이터셋 이름", required = true, example = "my-dataset")
            @RequestParam("name") String name,
            
            @Parameter(description = "데이터셋 타입", required = true, example = "unsupervised_finetuning")
            @RequestParam("type") String type,
            
            @Parameter(description = "데이터셋 상태", example = "processing")
            @RequestParam(value = "status", defaultValue = "processing") String status,
            
            @Parameter(description = "데이터셋 설명", example = "Dataset description")
            @RequestParam(value = "description", required = false) String description,
            
            @Parameter(description = "데이터셋 태그", example = "tag1,tag2,tag3")
            @RequestParam(value = "tags", required = false) String tags,
            
            @Parameter(description = "프로젝트 ID", required = true, example = "project-123")
            @RequestParam("project_id") String projectId,
            
            @Parameter(description = "생성자", example = "user123")
            @RequestParam(value = "created_by", required = false) String createdBy,
            
            @Parameter(description = "수정자", example = "user123")
            @RequestParam(value = "updated_by", required = false) String updatedBy,
            
            @Parameter(description = "추가 페이로드 (JSON)", example = "{\"key\":\"value\"}")
            @RequestParam(value = "payload", required = false) String payload) {
        
        log.info("파일 업로드 데이터셋 생성 요청 - name: {}, type: {}, fileName: {}", 
                name, type, file.getOriginalFilename());
        
        DatasetUploadRequest request = DatasetUploadRequest.builder()
                .name(name)
                .type(type)
                .status(status)
                .description(description)
                .tags(tags)
                .projectId(projectId)
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .payload(payload)
                .build();
        
        DatasetResponse response = datasetService.uploadFileDataset(file, request);
        
        log.info("파일 업로드 데이터셋 생성 완료 - id: {}, name: {}", response.getId(), response.getName());
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * 데이터셋 미리보기
     * 
     * @param datasetId 데이터셋 ID
     * @param chunksize 청크 크기
     * @return 데이터셋 미리보기 데이터
     */
    @GetMapping("/{datasetId}/previews")
    @Operation(summary = "데이터셋 미리보기", description = "데이터셋의 일부 데이터를 미리보기로 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "미리보기 조회 성공"),
        @ApiResponse(responseCode = "404", description = "데이터셋을 찾을 수 없음"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류"),
        @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    public ResponseEntity<DatasetPreviewResponse> getDatasetPreview(
            @Parameter(description = "데이터셋 ID", required = true, example = "dataset-123")
            @PathVariable String datasetId,
            
            @Parameter(description = "청크 크기", required = true, example = "100")
            @RequestParam("chunksize") int chunksize) {
        
        log.info("데이터셋 미리보기 조회 요청 - datasetId: {}, chunksize: {}", datasetId, chunksize);
        
        DatasetPreviewResponse response = datasetService.getDatasetPreview(datasetId, chunksize);
        
        log.info("데이터셋 미리보기 조회 완료 - datasetId: {}", datasetId);
        
        return ResponseEntity.ok(response);
    }

    /**
     * 데이터셋 태그 업데이트
     * 
     * @param datasetId 데이터셋 ID
     * @param request 태그 업데이트 요청
     * @return 업데이트된 데이터셋 정보
     */
    @PutMapping("/{datasetId}/tags")
    @Operation(summary = "데이터셋 태그 업데이트", description = "데이터셋의 태그 정보를 업데이트합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "태그 업데이트 성공"),
        @ApiResponse(responseCode = "400", description = "잘못된 요청"),
        @ApiResponse(responseCode = "404", description = "데이터셋을 찾을 수 없음"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류"),
        @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    public ResponseEntity<DatasetResponse> updateDatasetTags(
            @Parameter(description = "데이터셋 ID", required = true, example = "dataset-123")
            @PathVariable String datasetId,
            
            @Parameter(description = "태그 업데이트 요청", required = true)
            @Valid @RequestBody DatasetTagUpdateRequest request) {
        
        log.info("데이터셋 태그 업데이트 요청 - datasetId: {}, tags: {}", datasetId, request.getTags().size());
        
        DatasetResponse response = datasetService.updateDatasetTags(datasetId, request);
        
        log.info("데이터셋 태그 업데이트 완료 - datasetId: {}", datasetId);
        
        return ResponseEntity.ok(response);
    }

    /**
     * 데이터셋 태그 삭제
     * 
     * @param datasetId 데이터셋 ID
     * @param request 태그 삭제 요청
     * @return 업데이트된 데이터셋 정보
     */
    @DeleteMapping("/{datasetId}/tags")
    @Operation(summary = "데이터셋 태그 삭제", description = "데이터셋의 특정 태그들을 삭제합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "태그 삭제 성공"),
        @ApiResponse(responseCode = "400", description = "잘못된 요청"),
        @ApiResponse(responseCode = "404", description = "데이터셋을 찾을 수 없음"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류"),
        @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    public ResponseEntity<DatasetResponse> deleteDatasetTags(
            @Parameter(description = "데이터셋 ID", required = true, example = "dataset-123")
            @PathVariable String datasetId,
            
            @Parameter(description = "태그 삭제 요청", required = true)
            @Valid @RequestBody DatasetTagUpdateRequest request) {
        
        log.info("데이터셋 태그 삭제 요청 - datasetId: {}, tags: {}", datasetId, request.getTags().size());
        
        DatasetResponse response = datasetService.deleteDatasetTags(datasetId, request);
        
        log.info("데이터셋 태그 삭제 완료 - datasetId: {}", datasetId);
        
        return ResponseEntity.ok(response);
    }
}
