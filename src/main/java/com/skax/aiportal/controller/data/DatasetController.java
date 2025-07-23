package com.skax.aiportal.controller.data;

import static com.skax.aiportal.constant.DatasetConstants.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skax.aiportal.dto.CustomApiResponse;
import com.skax.aiportal.dto.data.request.DatasetCreateReq;
import com.skax.aiportal.dto.data.request.DatasetDeleteReq;
import com.skax.aiportal.dto.data.request.DatasetGetReq;
import com.skax.aiportal.dto.data.request.DatasetListReq;
import com.skax.aiportal.dto.data.request.DatasetPreviewReq;
import com.skax.aiportal.dto.data.request.DatasetTagDeleteReq;
import com.skax.aiportal.dto.data.request.DatasetTagUpdateReq;
import com.skax.aiportal.dto.data.request.DatasetUpdateReq;
import com.skax.aiportal.dto.data.request.DatasetUploadFileReq;
import com.skax.aiportal.dto.data.response.DatasetCreateRes;
import com.skax.aiportal.dto.data.response.DatasetDeleteRes;
import com.skax.aiportal.dto.data.response.DatasetGetRes;
import com.skax.aiportal.dto.data.response.DatasetHardDeleteRes;
import com.skax.aiportal.dto.data.response.DatasetListRes;
import com.skax.aiportal.dto.data.response.DatasetUpdateRes;
import com.skax.aiportal.service.data.DatasetService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 데이터셋 관리 API 컨트롤러
 * 
 * <p>SKT AI 플랫폼의 데이터셋 관리 REST API를 제공하는 컨트롤러입니다.
 * 데이터셋의 생성, 조회, 수정, 삭제, 파일 업로드, 미리보기, 태그 관리 등의 기능을 제공합니다.</p>
 * 
 * <p>주요 기능:</p>
 * <ul>
 *   <li>데이터셋 목록 조회 (페이징, 필터링, 검색)</li>
 *   <li>데이터셋 생성 및 파일 업로드</li>
 *   <li>데이터셋 상세 조회</li>
 *   <li>데이터셋 정보 수정</li>
 *   <li>데이터셋 삭제 (소프트/하드)</li>
 *   <li>데이터셋 미리보기</li>
 *   <li>데이터셋 태그 관리</li>
 * </ul>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Tag(
    name = API_TAG_NAME,
    description = API_TAG_DESCRIPTION
)
@Slf4j
@RestController
@RequestMapping(API_BASE_PATH)
@RequiredArgsConstructor
public class DatasetController {

    private final DatasetService datasetService;

    /**
     * 데이터셋 목록 조회
     * 
     * <p>페이징, 정렬, 검색 조건을 적용하여 데이터셋 목록을 조회합니다.
     * 프로젝트별 필터링과 키워드 검색을 지원합니다.</p>
     * 
     * @param page 페이지 번호 (기본값: 0)
     * @param size 페이지당 아이템 수 (기본값: 20)
     * @param sortBy 정렬 기준 필드 (기본값: createdAt)
     * @param projectId 프로젝트 ID 필터
     * @param searchKeyword 검색 키워드
     * @return 데이터셋 목록 응답
     */
    @Operation(
        summary = OPERATION_DATASET_LIST,
        description = OPERATION_DATASET_LIST_DESC
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = HTTP_200_DESCRIPTION,
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = HTTP_400_DESCRIPTION,
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "500",
            description = HTTP_500_DESCRIPTION,
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        )
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomApiResponse<DatasetListRes>> getDatasets(
            @Parameter(description = PARAM_PAGE_DESCRIPTION) 
            @RequestParam(defaultValue = "0") int page,
            @Parameter(description = PARAM_SIZE_DESCRIPTION) 
            @RequestParam(defaultValue = "20") int size,
            @Parameter(description = PARAM_SORT_BY_DESCRIPTION) 
            @RequestParam(defaultValue = DEFAULT_SORT_BY) String sortBy,
            @Parameter(description = PARAM_PROJECT_ID_DESCRIPTION) 
            @RequestParam(required = false) String projectId,
            @Parameter(description = PARAM_SEARCH_KEYWORD_DESCRIPTION) 
            @RequestParam(required = false) String searchKeyword) {
        
        DatasetListReq request = DatasetListReq.builder()
                .page(page)
                .size(size)
                .sort(sortBy)
                .filter(projectId)
                .search(searchKeyword)
                .build();
        
        log.info(LOG_DATASET_LIST_START, page, size, sortBy, projectId, searchKeyword);
        
        DatasetListRes response = datasetService.getDatasets(request);
        
        log.info(LOG_DATASET_LIST_SUCCESS, "N/A", response.getProcessingTimeMs());
        
        return ResponseEntity.ok(
            CustomApiResponse.success(response, DATASET_LIST_SUCCESS_MESSAGE)
        );
    }

    /**
     * 데이터셋 생성
     * 
     * <p>새로운 데이터셋을 생성합니다.
     * 데이터셋 메타데이터와 설정 정보를 포함하여 생성할 수 있습니다.</p>
     * 
     * @param request 데이터셋 생성 요청 정보
     * @return 데이터셋 생성 응답
     */
    @Operation(
        summary = OPERATION_DATASET_CREATE,
        description = OPERATION_DATASET_CREATE_DESC
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "201",
            description = HTTP_201_DESCRIPTION,
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = HTTP_400_DESCRIPTION,
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "500",
            description = HTTP_500_DESCRIPTION,
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        )
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomApiResponse<DatasetCreateRes>> createDataset(
            @Parameter(description = "데이터셋 생성 요청 정보", required = true)
            @Valid @RequestBody DatasetCreateReq request) {
        
        log.info(LOG_DATASET_CREATE_START, request.getName(), request.getType(), request.getDatasourceId());
        
        DatasetCreateRes response = datasetService.createDataset(request);
        
        log.info(LOG_DATASET_CREATE_SUCCESS, response.getDatasetId(), request.getName(), response.getProcessingTimeMs());
        
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CustomApiResponse.success(response, DATASET_CREATE_SUCCESS_MESSAGE));
    }

    /**
     * 데이터셋 상세 조회
     * 
     * <p>데이터셋 ID를 통해 특정 데이터셋의 상세 정보를 조회합니다.
     * 데이터셋의 모든 메타데이터와 설정 정보를 포함합니다.</p>
     * 
     * @param datasetId 조회할 데이터셋의 고유 식별자
     * @return 데이터셋 상세 정보
     */
    @Operation(
        summary = "데이터셋 상세 조회",
        description = "데이터셋 ID로 특정 데이터셋의 상세 정보를 조회합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "데이터셋 조회 성공",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "데이터셋을 찾을 수 없음",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "500",
            description = "서버 내부 오류",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        )
    })
    @GetMapping(value = "/{datasetId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomApiResponse<DatasetGetRes>> getDatasetById(
            @Parameter(description = "조회할 데이터셋의 고유 식별자", required = true, example = "dataset-12345")
            @PathVariable("datasetId") String datasetId) {
        
        log.info("데이터셋 상세 조회 요청: datasetId={}", datasetId);
        
        DatasetGetReq request = DatasetGetReq.builder()
                .datasetId(datasetId)
                .build();
        
        DatasetGetRes response = datasetService.getDatasetById(request);
        
        log.info("데이터셋 상세 조회 완료: datasetId={}, 처리시간={}ms", 
                datasetId, response.getProcessingTimeMs());
        
        return ResponseEntity.ok(
            CustomApiResponse.success(response, "데이터셋 조회가 완료되었습니다.")
        );
    }

    /**
     * 데이터셋 정보 수정
     * 
     * <p>기존 데이터셋의 정보를 수정합니다.
     * 이름, 설명, 상태, 태그 등의 메타데이터를 업데이트할 수 있습니다.</p>
     * 
     * @param datasetId 수정할 데이터셋의 고유 식별자
     * @param request 데이터셋 수정 요청 정보
     * @return 수정된 데이터셋 정보
     */
    @Operation(
        summary = "데이터셋 정보 수정",
        description = "기존 데이터셋의 메타데이터 정보를 수정합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "데이터셋 수정 성공",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = "잘못된 요청 - 유효하지 않은 입력값",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "데이터셋을 찾을 수 없음",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "500",
            description = "서버 내부 오류",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        )
    })
    @PutMapping(value = "/{datasetId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomApiResponse<DatasetUpdateRes>> updateDataset(
            @Parameter(description = "수정할 데이터셋의 고유 식별자", required = true, example = "dataset-12345")
            @PathVariable("datasetId") String datasetId,
            
            @Parameter(description = "데이터셋 수정 요청 정보", required = true)
            @Valid @RequestBody DatasetUpdateReq updateRequest) {
        
        log.info("데이터셋 수정 요청: datasetId={}", datasetId);
        
        // Path Variable을 Request에 설정
        DatasetUpdateReq request = DatasetUpdateReq.builder()
                .datasetId(datasetId)
                .description(updateRequest.getDescription())
                .projectId(updateRequest.getProjectId())
                .build();
        
        DatasetUpdateRes response = datasetService.updateDataset(request);
        
        log.info("데이터셋 수정 완료: datasetId={}, 처리시간={}ms", 
                datasetId, response.getProcessingTimeMs());
        
        return ResponseEntity.ok(
            CustomApiResponse.success(response, "데이터셋 정보가 성공적으로 수정되었습니다.")
        );
    }

    /**
     * 데이터셋 삭제 (소프트 삭제)
     * 
     * <p>데이터셋을 삭제 상태로 표시합니다.
     * 실제 데이터는 삭제되지 않고 삭제 상태로 마킹되어 목록에서 제외됩니다.</p>
     * 
     * @param datasetId 삭제할 데이터셋의 고유 식별자
     * @return 삭제 처리 결과
     */
    @Operation(
        summary = "데이터셋 삭제",
        description = "데이터셋을 삭제 상태로 표시합니다. (소프트 삭제)"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "데이터셋 삭제 성공",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "데이터셋을 찾을 수 없음",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "500",
            description = "서버 내부 오류",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        )
    })
    @DeleteMapping(value = "/{datasetId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomApiResponse<DatasetDeleteRes>> deleteDataset(
            @Parameter(description = "삭제할 데이터셋의 고유 식별자", required = true, example = "dataset-12345")
            @PathVariable("datasetId") String datasetId) {
        
        log.info("데이터셋 삭제 요청: datasetId={}", datasetId);
        
        DatasetDeleteReq request = DatasetDeleteReq.builder()
                .datasetId(datasetId)
                .build();
        
        DatasetDeleteRes response = datasetService.deleteDataset(request);
        
        log.info("데이터셋 삭제 완료: datasetId={}, 처리시간={}ms", 
                datasetId, response.getProcessingTimeMs());
        
        return ResponseEntity.ok(
            CustomApiResponse.success(response, "데이터셋이 성공적으로 삭제되었습니다.")
        );
    }

    /**
     * 모든 삭제된 데이터셋 하드 삭제
     * 
     * <p>삭제 상태로 표시된 모든 데이터셋을 완전히 제거합니다.
     * 이 작업은 되돌릴 수 없으므로 주의가 필요합니다.</p>
     * 
     * @return 하드 삭제 처리 결과
     */
    @Operation(
        summary = "삭제된 데이터셋 하드 삭제",
        description = "삭제 상태인 모든 데이터셋을 완전히 제거합니다. 이 작업은 되돌릴 수 없습니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "하드 삭제 성공",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "500",
            description = "서버 내부 오류",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        )
    })
    @PostMapping(value = "/hard-delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomApiResponse<DatasetHardDeleteRes>> hardDeleteAllDatasets() {
        
        log.info("데이터셋 하드 삭제 요청");
        
        DatasetHardDeleteRes response = datasetService.hardDeleteAllDatasets();
        
        log.info("데이터셋 하드 삭제 완료: 처리시간={}ms", response.getProcessingTimeMs());
        
        return ResponseEntity.ok(
            CustomApiResponse.success(response, "삭제된 모든 데이터셋이 완전히 제거되었습니다.")
        );
    }

    /**
     * 파일 업로드를 통한 데이터셋 생성
     * 
     * <p>파일을 직접 업로드하여 데이터셋을 생성합니다.
     * 지원되는 파일 형식에 따라 자동으로 데이터셋 타입이 결정됩니다.</p>
     * 
     * @param request 파일 업로드 데이터셋 생성 요청 정보
     * @return 생성된 데이터셋 정보
     */
    @Operation(
        summary = "파일 업로드 데이터셋 생성",
        description = "파일을 직접 업로드하여 데이터셋을 생성합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "201",
            description = "데이터셋 생성 성공",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = "잘못된 요청 - 파일 업로드 실패 또는 유효하지 않은 파일",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "422",
            description = "파일 검증 실패",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "500",
            description = "서버 내부 오류",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        )
    })
    @PostMapping(value = "/upload/files", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomApiResponse<DatasetCreateRes>> uploadFileDataset(
            @Parameter(description = "파일 업로드 데이터셋 생성 요청 정보", required = true)
            @Valid DatasetUploadFileReq request) {
        
        log.info("파일 업로드 데이터셋 생성 요청: name={}, type={}, projectId={}", 
                request.getName(), request.getType(), request.getProjectId());
        
        DatasetCreateRes response = datasetService.uploadFileDataset(request);
        
        log.info("파일 업로드 데이터셋 생성 완료: datasetId={}, 처리시간={}ms", 
                response.getDatasetId(), response.getProcessingTimeMs());
        
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CustomApiResponse.success(response, "파일 업로드를 통한 데이터셋이 성공적으로 생성되었습니다."));
    }

    /**
     * 데이터셋 미리보기
     * 
     * <p>데이터셋의 일부 데이터를 미리보기로 조회합니다.
     * 지정된 청크 크기만큼의 데이터 샘플을 반환합니다.</p>
     * 
     * @param datasetId 미리보기할 데이터셋의 고유 식별자
     * @param chunksize 미리보기로 가져올 데이터 크기 (행 수)
     * @return 데이터셋 미리보기 데이터
     */
    @Operation(
        summary = "데이터셋 미리보기",
        description = "데이터셋의 일부 데이터를 미리보기로 조회합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "미리보기 조회 성공",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = "잘못된 요청 - 유효하지 않은 청크 크기",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "데이터셋을 찾을 수 없음",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "500",
            description = "서버 내부 오류",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        )
    })
    @GetMapping(value = "/{datasetId}/previews", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomApiResponse<Object>> getDatasetPreview(
            @Parameter(description = "미리보기할 데이터셋의 고유 식별자", required = true, example = "dataset-12345")
            @PathVariable("datasetId") String datasetId,
            
            @Parameter(description = "미리보기로 가져올 데이터 크기 (행 수)", required = true, example = "100")
            @RequestParam("chunksize") Integer chunksize) {
        
        log.info("데이터셋 미리보기 요청: datasetId={}, chunksize={}", datasetId, chunksize);
        
        DatasetPreviewReq request = DatasetPreviewReq.builder()
                .datasetId(datasetId)
                .chunksize(chunksize)
                .build();
        
        Object response = datasetService.getDatasetPreview(request);
        
        log.info("데이터셋 미리보기 완료: datasetId={}", datasetId);
        
        return ResponseEntity.ok(
            CustomApiResponse.success(response, "데이터셋 미리보기 조회가 완료되었습니다.")
        );
    }

    /**
     * 데이터셋 태그 업데이트
     * 
     * <p>데이터셋의 태그 정보를 업데이트합니다.
     * 기존 태그를 대체하거나 새로운 태그를 추가할 수 있습니다.</p>
     * 
     * @param datasetId 태그를 업데이트할 데이터셋의 고유 식별자
     * @param request 데이터셋 태그 업데이트 요청 정보
     * @return 태그가 업데이트된 데이터셋 정보
     */
    @Operation(
        summary = "데이터셋 태그 업데이트",
        description = "데이터셋의 태그 정보를 업데이트합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "태그 업데이트 성공",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = "잘못된 요청 - 유효하지 않은 태그 정보",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "데이터셋을 찾을 수 없음",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "500",
            description = "서버 내부 오류",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        )
    })
    @PutMapping(value = "/{datasetId}/tags", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomApiResponse<DatasetGetRes>> updateDatasetTags(
            @Parameter(description = "태그를 업데이트할 데이터셋의 고유 식별자", required = true, example = "dataset-12345")
            @PathVariable("datasetId") String datasetId,
            
            @Parameter(description = "데이터셋 태그 업데이트 요청 정보", required = true)
            @Valid @RequestBody DatasetTagUpdateReq updateRequest) {
        
        log.info("데이터셋 태그 업데이트 요청: datasetId={}, tagCount={}", 
                datasetId, updateRequest.getTags().size());
        
        // Path Variable을 Request에 설정
        DatasetTagUpdateReq request = DatasetTagUpdateReq.builder()
                .datasetId(datasetId)
                .tags(updateRequest.getTags())
                .build();
        
        DatasetGetRes response = datasetService.updateDatasetTags(request);
        
        log.info("데이터셋 태그 업데이트 완료: datasetId={}, 처리시간={}ms", 
                datasetId, response.getProcessingTimeMs());
        
        return ResponseEntity.ok(
            CustomApiResponse.success(response, "데이터셋 태그가 성공적으로 업데이트되었습니다.")
        );
    }

    /**
     * 데이터셋 태그 삭제
     * 
     * <p>데이터셋에서 특정 태그들을 삭제합니다.
     * 지정된 태그만 제거하고 나머지 태그는 유지됩니다.</p>
     * 
     * @param datasetId 태그를 삭제할 데이터셋의 고유 식별자
     * @param request 데이터셋 태그 삭제 요청 정보
     * @return 태그가 삭제된 데이터셋 정보
     */
    @Operation(
        summary = "데이터셋 태그 삭제",
        description = "데이터셋에서 특정 태그들을 삭제합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "태그 삭제 성공",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = "잘못된 요청 - 유효하지 않은 태그 정보",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "데이터셋을 찾을 수 없음",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "500",
            description = "서버 내부 오류",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = CustomApiResponse.class)
            )
        )
    })
    @DeleteMapping(value = "/{datasetId}/tags", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomApiResponse<DatasetGetRes>> deleteDatasetTags(
            @Parameter(description = "태그를 삭제할 데이터셋의 고유 식별자", required = true, example = "dataset-12345")
            @PathVariable("datasetId") String datasetId,
            
            @Parameter(description = "데이터셋 태그 삭제 요청 정보", required = true)
            @Valid @RequestBody DatasetTagDeleteReq deleteRequest) {
        
        log.info("데이터셋 태그 삭제 요청: datasetId={}, tagCount={}", 
                datasetId, deleteRequest.getTags().size());
        
        // Path Variable을 Request에 설정
        DatasetTagDeleteReq request = DatasetTagDeleteReq.builder()
                .datasetId(datasetId)
                .tags(deleteRequest.getTags())
                .build();
        
        DatasetGetRes response = datasetService.deleteDatasetTags(request);
        
        log.info("데이터셋 태그 삭제 완료: datasetId={}, 처리시간={}ms", 
                datasetId, response.getProcessingTimeMs());
        
        return ResponseEntity.ok(
            CustomApiResponse.success(response, "데이터셋 태그가 성공적으로 삭제되었습니다.")
        );
    }
}
