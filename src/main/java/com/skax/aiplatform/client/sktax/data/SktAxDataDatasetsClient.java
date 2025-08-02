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
import com.skax.aiplatform.client.sktax.data.dto.Dataset;
import com.skax.aiplatform.client.sktax.data.dto.DatasetTags;
import com.skax.aiplatform.client.sktax.data.dto.request.DatasetCreateRequest;
import com.skax.aiplatform.client.sktax.data.dto.response.DataSetDetail;
import com.skax.aiplatform.client.sktax.data.dto.response.DataSetList;

/**
 * SKT AX Data API 데이터셋 클라이언트
 * 
 * <p>데이터셋 관련 API를 호출하기 위한 Feign Client입니다.
 * 데이터셋의 생성, 조회, 수정, 삭제 기능을 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-01-21
 * @version 1.0
 */
@FeignClient(
    name = "skt-ax-data-datasets",
    url = "${sktax.data.base-url:https://aip-stg.sktai.io}",
    configuration = SktAxFeignConfig.class
)
public interface SktAxDataDatasetsClient {
    
    /**
     * 데이터셋 목록 조회
     * 
     * @param page 페이지 번호 (기본값: 1)
     * @param size 페이지 크기 (기본값: 10)
     * @param sort 정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return 데이터셋 목록
     */
    @GetMapping("/api/v1/datasets")
    ResponseEntity<DataSetList> getDatasets(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "search", required = false) String search
    );
    
    /**
     * 데이터셋 생성
     * 
     * @param request 데이터셋 생성 요청
     * @return 생성된 데이터셋
     */
    @PostMapping("/api/v1/datasets")
    ResponseEntity<Dataset> createDataset(@RequestBody DatasetCreateRequest request);
    
    /**
     * 데이터셋 상세 조회
     * 
     * @param datasetId 데이터셋 ID
     * @return 데이터셋 상세 정보
     */
    @GetMapping("/api/v1/datasets/{dataset_id}")
    ResponseEntity<DataSetDetail> getDatasetById(@PathVariable("dataset_id") String datasetId);
    
    /**
     * 데이터셋 삭제 (소프트 삭제)
     * 
     * @param datasetId 데이터셋 ID
     * @return 삭제 결과
     */
    @DeleteMapping("/api/v1/datasets/{dataset_id}")
    ResponseEntity<Void> deleteDataset(@PathVariable("dataset_id") String datasetId);
    
    /**
     * 데이터셋 수정
     * 
     * @param datasetId 데이터셋 ID
     * @param request 수정 요청
     * @return 수정 결과
     */
    @PutMapping("/api/v1/datasets/{dataset_id}")
    ResponseEntity<Object> updateDataset(
            @PathVariable("dataset_id") String datasetId,
            @RequestBody Object request
    );
    
    /**
     * 모든 삭제된 데이터셋 하드 삭제
     * 
     * @return 삭제 결과
     */
    @PostMapping("/api/v1/datasets/hard-delete")
    ResponseEntity<Object> hardDeleteAllDatasets();
    
    /**
     * 파일 업로드를 통한 데이터셋 생성
     * 
     * @param file 업로드할 파일
     * @param name 데이터셋 이름
     * @param type 데이터셋 타입
     * @param status 상태
     * @param description 설명
     * @param tags 태그
     * @param projectId 프로젝트 ID
     * @param createdBy 생성자
     * @param updatedBy 수정자
     * @param payload 페이로드
     * @return 생성된 데이터셋
     */
    @PostMapping(value = "/api/v1/datasets/upload/files", consumes = "multipart/form-data")
    ResponseEntity<Dataset> uploadFile(
            @RequestPart("file") Object file,
            @RequestPart("name") String name,
            @RequestPart("type") String type,
            @RequestPart(value = "status", required = false) String status,
            @RequestPart(value = "description", required = false) String description,
            @RequestPart(value = "tags", required = false) String tags,
            @RequestPart("project_id") String projectId,
            @RequestPart(value = "created_by", required = false) String createdBy,
            @RequestPart(value = "updated_by", required = false) String updatedBy,
            @RequestPart(value = "payload", required = false) String payload
    );
    
    /**
     * 데이터셋 미리보기
     * 
     * @param datasetId 데이터셋 ID
     * @param chunksize 청크 크기
     * @return 미리보기 데이터
     */
    @GetMapping("/api/v1/datasets/{dataset_id}/previews")
    ResponseEntity<Object> getDatasetPreview(
            @PathVariable("dataset_id") String datasetId,
            @RequestParam("chunksize") Integer chunksize
    );
    
    /**
     * 데이터셋 태그 업데이트
     * 
     * @param datasetId 데이터셋 ID
     * @param tags 태그 목록
     * @return 업데이트된 데이터셋
     */
    @PutMapping("/api/v1/datasets/{dataset_id}/tags")
    ResponseEntity<Dataset> updateTags(
            @PathVariable("dataset_id") String datasetId,
            @RequestBody DatasetTags[] tags
    );
    
    /**
     * 데이터셋 태그 삭제
     * 
     * @param datasetId 데이터셋 ID
     * @param tags 삭제할 태그 목록
     * @return 업데이트된 데이터셋
     */
    @DeleteMapping("/api/v1/datasets/{dataset_id}/tags")
    ResponseEntity<Dataset> deleteTags(
            @PathVariable("dataset_id") String datasetId,
            @RequestBody DatasetTags[] tags
    );
}
