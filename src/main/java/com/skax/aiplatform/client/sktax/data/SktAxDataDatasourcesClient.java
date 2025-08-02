package com.skax.aiplatform.client.sktax.data;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import com.skax.aiplatform.client.sktax.data.dto.DataSourceDetail;
import com.skax.aiplatform.client.sktax.data.dto.request.DataSourceCreate;



/**
 * SKT AX Data API 데이터소스 클라이언트
 * 
 * <p>데이터소스 관련 API를 호출하기 위한 Feign Client입니다.
 * 데이터소스의 생성, 조회, 수정, 삭제, 파일 업로드/다운로드 기능을 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-01-21
 * @version 1.0
 */
@FeignClient(
    name = "skt-ax-data-datasources",
    url = "${sktax.data.base-url:https://aip-stg.sktai.io}",
    configuration = SktAxFeignConfig.class
)
public interface SktAxDataDatasourcesClient {
    
    /**
     * 파일 업로드 (임시)
     * 
     * @param files 업로드할 파일들
     * @return 업로드된 임시 파일 정보
     */
    @PostMapping(value = "/api/v1/datasources/upload/files", consumes = "multipart/form-data")
    ResponseEntity<Object> uploadFiles(@RequestPart("files") Object[] files);
    
    /**
     * 파일 다운로드
     * 
     * @param datasourceFileId 데이터소스 파일 ID
     * @return 파일 데이터
     */
    @GetMapping("/api/v1/datasources/download/{datasource_file_id}")
    ResponseEntity<Object> downloadFile(@PathVariable("datasource_file_id") String datasourceFileId);
    
    /**
     * API Key를 사용한 파일 다운로드
     * 
     * @param datasourceFileId 데이터소스 파일 ID
     * @return 파일 데이터
     */
    @GetMapping("/api/v1/datasources/download/apikey/{datasource_file_id}")
    ResponseEntity<Object> downloadFileWithApiKey(@PathVariable("datasource_file_id") String datasourceFileId);
    
    /**
     * 데이터소스 목록 조회
     * 
     * @param page 페이지 번호
     * @param size 페이지 크기
     * @param sort 정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return 데이터소스 목록
     */
    @GetMapping("/api/v1/datasources")
    ResponseEntity<Object> getDatasources(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "search", required = false) String search
    );
    
    /**
     * 데이터소스 생성
     * 
     * @param request 데이터소스 생성 요청
     * @return 생성된 데이터소스
     */
    @PostMapping("/api/v1/datasources")
    ResponseEntity<DataSourceDetail> createDatasource(@RequestBody DataSourceCreate request);
    
    /**
     * 데이터소스 상세 조회
     * 
     * @param datasourceId 데이터소스 ID
     * @return 데이터소스 상세 정보
     */
    @GetMapping("/api/v1/datasources/{datasource_id}")
    ResponseEntity<Object> getDatasourceById(@PathVariable("datasource_id") String datasourceId);
    
    /**
     * 데이터소스 수정
     * 
     * @param datasourceId 데이터소스 ID
     * @param request 수정 요청
     * @return 수정된 데이터소스
     */
    @PutMapping("/api/v1/datasources/{datasource_id}")
    ResponseEntity<Object> updateDatasource(
            @PathVariable("datasource_id") String datasourceId,
            @RequestBody Object request
    );
    
    /**
     * 데이터소스 삭제 (소프트 삭제)
     * 
     * @param datasourceId 데이터소스 ID
     * @return 삭제 결과
     */
    @DeleteMapping("/api/v1/datasources/{datasource_id}")
    ResponseEntity<Void> deleteDatasource(@PathVariable("datasource_id") String datasourceId);
    
    /**
     * 파일명으로 활성 파일 ID 조회
     * 
     * @param datasourceId 데이터소스 ID
     * @param fileName 파일명
     * @return 파일 ID
     */
    @GetMapping("/api/v1/datasources/{datasource_id}/files")
    ResponseEntity<Object> getActiveFileIdByName(
            @PathVariable("datasource_id") String datasourceId,
            @RequestParam("file_name") String fileName
    );
    
    /**
     * 모든 삭제된 데이터소스 하드 삭제
     * 
     * @return 삭제 결과
     */
    @PostMapping("/api/v1/datasources/hard-delete")
    ResponseEntity<Object> hardDeleteAllDatasources();
    
    /**
     * 데이터소스 하드 삭제
     * 
     * @param datasourceId 데이터소스 ID
     * @return 삭제 결과
     */
    @DeleteMapping("/api/v1/datasources/{datasource_id}/hard_delete")
    ResponseEntity<Void> hardDeleteDatasource(@PathVariable("datasource_id") String datasourceId);
    
    /**
     * 파일 메타데이터 업데이트
     * 
     * @param datasourceId 데이터소스 ID
     * @param fileId 파일 ID
     * @param metadata 메타데이터
     * @return 업데이트 결과
     */
    @PutMapping("/api/v1/datasources/{datasource_id}/files/{file_id}/metadata")
    ResponseEntity<Object> updateFileMetadata(
            @PathVariable("datasource_id") String datasourceId,
            @PathVariable("file_id") String fileId,
            @RequestBody Object metadata
    );
    
    /**
     * TaskManager에 의한 데이터소스 태스크 업데이트
     * 
     * @param datasourceId 데이터소스 ID
     * @param request 업데이트 요청
     * @return 업데이트된 태스크
     */
    @PutMapping("/api/v1/datasources/{datasource_id}/tasks")
    ResponseEntity<Object> updateDatasourceTaskByTaskmanager(
            @PathVariable("datasource_id") String datasourceId,
            @RequestBody Object request
    );
    
    /**
     * 데이터소스 태스크 생성
     * 
     * @param datasourceId 데이터소스 ID
     * @param request 태스크 생성 요청
     * @return 생성된 태스크
     */
    @PostMapping("/api/v1/datasources/{datasource_id}/tasks")
    ResponseEntity<Object> createDatasourceTask(
            @PathVariable("datasource_id") String datasourceId,
            @RequestBody Object request
    );
}
