package com.skax.aiportal.client.sktai.data;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.skax.aiportal.client.sktai.data.dto.request.DatasourceCreateRequest;
import com.skax.aiportal.client.sktai.data.dto.response.DatasourceResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * SKT AI 데이터소스 관리 API 클라이언트
 * 
 * <p>SKT AI 플랫폼의 데이터소스 관리 API를 호출합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Tag(name = "SKT AI 데이터소스 API", description = "SKT AI 플랫폼 데이터소스 관리 서비스 연동")
@FeignClient(
    name = "sktAiDatasourceClient",
    url = "${sktai.api.base-url:https://aip-stg.sktai.io}",
    configuration = com.skax.aiportal.client.sktai.config.SktAiClientConfig.class
)
public interface SktAiDatasourceClient {

    /**
     * 데이터소스 목록 조회 (페이징)
     * 
     * @param page 페이지 번호
     * @param size 페이지 크기
     * @param sort 정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return 데이터소스 목록 응답
     */
    @Operation(summary = "데이터소스 목록 조회", description = "모든 데이터소스를 페이징하여 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "데이터소스 목록 조회 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @GetMapping("/api/v1/datasources")
    Object getDatasources(
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
     * 데이터소스 생성
     * 
     * @param createRequest 데이터소스 생성 요청
     * @return 생성된 데이터소스 정보
     */
    @Operation(summary = "데이터소스 생성", description = "새로운 데이터소스를 생성합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "데이터소스 생성 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @PostMapping("/api/v1/datasources")
    DatasourceResponse createDatasource(@RequestBody DatasourceCreateRequest createRequest);

    /**
     * 특정 데이터소스 조회
     * 
     * @param datasourceId 데이터소스 ID
     * @return 데이터소스 상세 정보
     */
    @Operation(summary = "데이터소스 상세 조회", description = "데이터소스 ID로 특정 데이터소스 정보를 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "데이터소스 조회 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @GetMapping("/api/v1/datasources/{datasource_id}")
    DatasourceResponse getDatasourceById(
            @Parameter(description = "데이터소스 ID", required = true)
            @PathVariable("datasource_id") String datasourceId
    );

    /**
     * 데이터소스 정보 수정
     * 
     * @param datasourceId 데이터소스 ID
     * @param updateRequest 데이터소스 수정 요청
     * @return 수정된 데이터소스 정보
     */
    @Operation(summary = "데이터소스 정보 수정", description = "데이터소스 정보를 수정합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "데이터소스 수정 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @PutMapping("/api/v1/datasources/{datasource_id}")
    DatasourceResponse updateDatasource(
            @Parameter(description = "데이터소스 ID", required = true)
            @PathVariable("datasource_id") String datasourceId,
            
            @RequestBody Object updateRequest
    );

    /**
     * 데이터소스 삭제 (소프트 삭제)
     * 
     * @param datasourceId 데이터소스 ID
     */
    @Operation(summary = "데이터소스 삭제", description = "데이터소스를 삭제 상태로 표시합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "데이터소스 삭제 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @DeleteMapping("/api/v1/datasources/{datasource_id}")
    void deleteDatasource(
            @Parameter(description = "데이터소스 ID", required = true)
            @PathVariable("datasource_id") String datasourceId
    );

    /**
     * 데이터소스 하드 삭제
     * 
     * @param datasourceId 데이터소스 ID
     */
    @Operation(summary = "데이터소스 하드 삭제", description = "데이터소스와 관련 파일을 완전히 삭제합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "하드 삭제 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @DeleteMapping("/api/v1/datasources/{datasource_id}/hard_delete")
    void hardDeleteDatasource(
            @Parameter(description = "데이터소스 ID", required = true)
            @PathVariable("datasource_id") String datasourceId
    );

    /**
     * 모든 삭제된 데이터소스 하드 삭제
     * 
     * @return 삭제 결과
     */
    @Operation(summary = "삭제된 데이터소스 하드 삭제", description = "삭제 상태인 모든 데이터소스를 완전히 제거합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "하드 삭제 성공")
    })
    @PostMapping("/api/v1/datasources/hard-delete")
    Object hardDeleteAllDatasources();

    /**
     * 데이터소스 파일 이름으로 파일 ID 조회
     * 
     * @param datasourceId 데이터소스 ID
     * @param fileName 파일 이름
     * @return 파일 ID 정보
     */
    @Operation(summary = "파일 ID 조회", description = "데이터소스의 파일 이름으로 활성 파일 ID를 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "파일 ID 조회 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @GetMapping("/api/v1/datasources/{datasource_id}/files")
    Object getActiveFileIdByName(
            @Parameter(description = "데이터소스 ID", required = true)
            @PathVariable("datasource_id") String datasourceId,
            
            @Parameter(description = "검색할 파일 이름", required = true)
            @RequestParam("file_name") String fileName
    );

    /**
     * 파일 메타데이터 업데이트
     * 
     * @param datasourceId 데이터소스 ID
     * @param fileId 파일 ID
     * @param metadata 메타데이터 정보
     * @return 업데이트된 파일 정보
     */
    @Operation(summary = "파일 메타데이터 업데이트", description = "데이터소스의 특정 파일 메타데이터를 업데이트합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "메타데이터 업데이트 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @PutMapping("/api/v1/datasources/{datasource_id}/files/{file_id}/metadata")
    Object updateFileMetadata(
            @Parameter(description = "데이터소스 ID", required = true)
            @PathVariable("datasource_id") String datasourceId,
            
            @Parameter(description = "파일 ID", required = true)
            @PathVariable("file_id") String fileId,
            
            @RequestBody Object metadata
    );

    /**
     * 데이터소스 작업 생성
     * 
     * @param datasourceId 데이터소스 ID
     * @param taskRequest 작업 생성 요청
     * @return 생성된 작업 정보
     */
    @Operation(summary = "데이터소스 작업 생성", description = "새로운 데이터소스 작업을 생성합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "작업 생성 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @PostMapping("/api/v1/datasources/{datasource_id}/tasks")
    Object createDatasourceTask(
            @Parameter(description = "데이터소스 ID", required = true)
            @PathVariable("datasource_id") String datasourceId,
            
            @RequestBody Object taskRequest
    );

    /**
     * 데이터소스 작업 업데이트 (TaskManager 용)
     * 
     * @param datasourceId 데이터소스 ID
     * @param taskUpdate 작업 업데이트 요청
     * @return 업데이트된 작업 정보
     */
    @Operation(summary = "데이터소스 작업 업데이트", description = "TaskManager에 의한 데이터소스 작업 상태를 업데이트합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "작업 업데이트 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @PutMapping("/api/v1/datasources/{datasource_id}/tasks")
    Object updateDatasourceTaskByTaskmanager(
            @Parameter(description = "데이터소스 ID", required = true)
            @PathVariable("datasource_id") String datasourceId,
            
            @RequestBody Object taskUpdate
    );

    /**
     * 데이터소스 파일 다운로드
     * 
     * @param datasourceFileId 데이터소스 파일 ID
     * @return 파일 다운로드 응답
     */
    @Operation(summary = "데이터소스 파일 다운로드", description = "서버에서 데이터소스 파일을 다운로드합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "파일 다운로드 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @GetMapping("/api/v1/datasources/download/{datasource_file_id}")
    Object downloadFile(
            @Parameter(description = "데이터소스 파일 ID", required = true)
            @PathVariable("datasource_file_id") String datasourceFileId
    );

    /**
     * API 키를 사용한 데이터소스 파일 다운로드
     * 
     * @param datasourceFileId 데이터소스 파일 ID
     * @return 파일 다운로드 응답
     */
    @Operation(summary = "API 키 파일 다운로드", description = "API 키 인증을 통해 데이터소스 파일을 다운로드합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "파일 다운로드 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @GetMapping("/api/v1/datasources/download/apikey/{datasource_file_id}")
    Object downloadFileWithApikey(
            @Parameter(description = "데이터소스 파일 ID", required = true)
            @PathVariable("datasource_file_id") String datasourceFileId
    );

    /**
     * 파일 업로드 (임시)
     * 
     * @param files 업로드할 파일 목록
     * @return 임시 파일 정보
     */
    @Operation(summary = "파일 업로드", description = "서버에 파일을 임시로 업로드합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "파일 업로드 성공"),
        @ApiResponse(responseCode = "422", description = "요청 데이터 검증 오류")
    })
    @PostMapping(value = "/api/v1/datasources/upload/files", consumes = "multipart/form-data")
    Object uploadFiles(
            @Parameter(description = "업로드할 파일 목록", required = true)
            @RequestParam("files") Object[] files
    );
}
