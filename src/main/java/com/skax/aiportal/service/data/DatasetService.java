package com.skax.aiportal.service.data;

import java.util.List;

import com.skax.aiportal.dto.data.request.DatasetCreateRequest;
import com.skax.aiportal.dto.data.request.DatasetUpdateRequest;
import com.skax.aiportal.dto.data.request.DatasetUploadRequest;
import com.skax.aiportal.dto.data.request.DatasetTagUpdateRequest;
import com.skax.aiportal.dto.data.response.DatasetResponse;
import com.skax.aiportal.dto.data.response.DatasetListResponse;
import com.skax.aiportal.dto.data.response.DatasetPreviewResponse;

import org.springframework.web.multipart.MultipartFile;

/**
 * 데이터셋 서비스 인터페이스
 * 
 * <p>데이터셋 관련 비즈니스 로직을 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
public interface DatasetService {

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
    DatasetListResponse getDatasets(int page, int size, String sort, String filter, String search);

    /**
     * 데이터셋 상세 조회
     * 
     * @param datasetId 데이터셋 ID
     * @return 데이터셋 상세 정보
     */
    DatasetResponse getDatasetById(String datasetId);

    /**
     * 데이터셋 생성
     * 
     * @param request 데이터셋 생성 요청
     * @return 생성된 데이터셋 정보
     */
    DatasetResponse createDataset(DatasetCreateRequest request);

    /**
     * 데이터셋 수정
     * 
     * @param datasetId 데이터셋 ID
     * @param request 데이터셋 수정 요청
     * @return 수정된 데이터셋 정보
     */
    Object updateDataset(String datasetId, DatasetUpdateRequest request);

    /**
     * 데이터셋 삭제 (소프트 삭제)
     * 
     * @param datasetId 데이터셋 ID
     */
    void deleteDataset(String datasetId);

    /**
     * 모든 삭제된 데이터셋 하드 삭제
     * 
     * @return 삭제 결과
     */
    Object hardDeleteAllDatasets();

    /**
     * 파일 업로드를 통한 데이터셋 생성
     * 
     * @param file 업로드할 파일
     * @param request 업로드 요청 정보
     * @return 생성된 데이터셋 정보
     */
    DatasetResponse uploadFileDataset(MultipartFile file, DatasetUploadRequest request);

    /**
     * 데이터셋 미리보기
     * 
     * @param datasetId 데이터셋 ID
     * @param chunksize 청크 크기
     * @return 데이터셋 미리보기 데이터
     */
    DatasetPreviewResponse getDatasetPreview(String datasetId, int chunksize);

    /**
     * 데이터셋 태그 업데이트
     * 
     * @param datasetId 데이터셋 ID
     * @param request 태그 업데이트 요청
     * @return 업데이트된 데이터셋 정보
     */
    DatasetResponse updateDatasetTags(String datasetId, DatasetTagUpdateRequest request);

    /**
     * 데이터셋 태그 삭제
     * 
     * @param datasetId 데이터셋 ID
     * @param request 태그 삭제 요청
     * @return 업데이트된 데이터셋 정보
     */
    DatasetResponse deleteDatasetTags(String datasetId, DatasetTagUpdateRequest request);
}
