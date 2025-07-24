package com.skax.aiportal.service.data.impl;

import static com.skax.aiportal.constant.DatasetConstants.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skax.aiportal.client.sktai.data.SktAiDatasetClient;
import com.skax.aiportal.client.sktai.data.dto.request.DatasetCreateRequest;
import com.skax.aiportal.client.sktai.data.dto.request.DatasetUpdateRequest;
import com.skax.aiportal.client.sktai.data.dto.response.DatasetListResponse;
import com.skax.aiportal.client.sktai.data.dto.response.DatasetResponse;
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

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * SKT 데이터셋 관리 서비스 구현체
 * 
 * <p>SKT AI 플랫폼의 데이터셋 관리 기능을 구현하는 서비스 클래스입니다.
 * SktAiDatasetClient를 통해 SKT AI API와 통신하며, 데이터 변환 및 에러 처리를 담당합니다.</p>
 * 
 * <p>주요 기능:</p>
 * <ul>
 *   <li>SKT AI API 호출 및 응답 처리</li>
 *   <li>요청/응답 데이터 변환</li>
 *   <li>비즈니스 로직 처리</li>
 *   <li>성능 모니터링 (응답 시간 측정)</li>
 *   <li>예외 처리 및 로깅</li>
 * </ul>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SktDatasetServiceImpl implements DatasetService {

    private final SktAiDatasetClient sktAiDatasetClient;

    /**
     * {@inheritDoc}
     * 
     * <p>SKT AI API를 호출하여 데이터셋 목록을 조회하고, 응답 시간을 측정합니다.
     * 페이징, 정렬, 필터링, 검색 파라미터를 그대로 전달합니다.</p>
     */
    @Override
    public DatasetListRes getDatasets(DatasetListReq request) {
        log.info("데이터셋 목록 조회 시작: page={}, size={}, sortBy={}, projectId={}, searchKeyword={}", 
                request.getPage(), request.getSize(), request.getSort(), request.getFilter(), request.getSearch());
        
        long startTime = System.currentTimeMillis();
        
        try {
            // SKT AI API 호출
            DatasetListResponse response = sktAiDatasetClient.getDatasets(
                    request.getPage(),
                    request.getSize(),
                    request.getSort(),
                    request.getFilter(),
                    request.getSearch()
            );
            
            long processingTime = System.currentTimeMillis() - startTime;
            
            log.info("데이터셋 목록 조회 완료: totalCount={}, 처리시간={}ms", "N/A", processingTime);
            
            return DatasetListRes.success(response, processingTime);
            
        } catch (Exception e) {
            long processingTime = System.currentTimeMillis() - startTime;
            log.error("데이터셋 목록 조회 실패: 처리시간={}ms, error={}", processingTime, e.getMessage(), e);
            throw new RuntimeException(String.format(DATASET_LIST_ERROR_MESSAGE, e.getMessage()), e);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * <p>요청 데이터를 SKT AI API 형식으로 변환하여 데이터셋을 생성합니다.
     * 생성 결과를 래핑하여 반환합니다.</p>
     */
    @Override
    @Transactional
    public DatasetCreateRes createDataset(DatasetCreateReq request) {
        log.info("데이터셋 생성 시작: name={}, type={}, datasourceId={}", 
                request.getName(), request.getType(), request.getDatasourceId());
        
        long startTime = System.currentTimeMillis();
        
        try {
            // DTO 변환
            DatasetCreateRequest createRequest = DatasetCreateRequest.builder()
                    .name(request.getName())
                    .type(request.getType())
                    .description(request.getDescription())
                    .tags(request.getTags())
                    .status(request.getStatus())
                    .projectId(request.getProjectId())
                    .isDeleted(request.getIsDeleted())
                    .datasourceId(request.getDatasourceId())
                    .processor(request.getProcessor())
                    .createdBy(request.getCreatedBy())
                    .updatedBy(request.getUpdatedBy())
                    .policy(request.getPolicy())
                    .build();

            // SKT AI API 호출
            DatasetResponse response = sktAiDatasetClient.createDataset(createRequest);
            
            long processingTime = System.currentTimeMillis() - startTime;
            
            log.info("데이터셋 생성 완료: datasetId={}, name={}, 처리시간={}ms", response.getId(), request.getName(), processingTime);
            
            return DatasetCreateRes.success(response, processingTime);
            
        } catch (Exception e) {
            long processingTime = System.currentTimeMillis() - startTime;
            log.error("데이터셋 생성 실패: name={}, 처리시간={}ms, error={}", 
                    request.getName(), processingTime, e.getMessage(), e);
            throw new RuntimeException(String.format(DATASET_CREATE_ERROR_MESSAGE, e.getMessage()), e);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * <p>데이터셋 ID로 SKT AI API를 호출하여 상세 정보를 조회합니다.</p>
     */
    @Override
    public DatasetGetRes getDatasetById(DatasetGetReq request) {
        log.info("데이터셋 조회 시작: datasetId={}", request.getDatasetId());
        
        long startTime = System.currentTimeMillis();
        
        try {
            // SKT AI API 호출
            DatasetResponse response = sktAiDatasetClient.getDatasetById(request.getDatasetId());
            
            long processingTime = System.currentTimeMillis() - startTime;
            
            log.info("데이터셋 조회 완료: datasetId={}, name={}, 처리시간={}ms", request.getDatasetId(), response.getName(), processingTime);
            
            return DatasetGetRes.success(response, processingTime);
            
        } catch (Exception e) {
            long processingTime = System.currentTimeMillis() - startTime;
            log.error("데이터셋 조회 실패: datasetId={}, 처리시간={}ms, error={}", 
                    request.getDatasetId(), processingTime, e.getMessage(), e);
            throw new RuntimeException(String.format(DATASET_GET_ERROR_MESSAGE, e.getMessage()), e);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * <p>요청 데이터를 SKT AI API 형식으로 변환하여 데이터셋 정보를 수정합니다.</p>
     */
    @Override
    @Transactional
    public DatasetUpdateRes updateDataset(DatasetUpdateReq request) {
        log.info("데이터셋 수정 시작: datasetId={}", request.getDatasetId());
        
        long startTime = System.currentTimeMillis();
        
        try {
            // DTO 변환
            DatasetUpdateRequest updateRequest = DatasetUpdateRequest.builder()
                    .description(request.getDescription())
                    .projectId(request.getProjectId())
                    .build();
            
            // SKT AI API 호출
            Object response = sktAiDatasetClient.updateDataset(request.getDatasetId(), updateRequest);
            
            long processingTime = System.currentTimeMillis() - startTime;
            
            log.info("데이터셋 수정 완료: datasetId={}, 처리시간={}ms", request.getDatasetId(), processingTime);
            
            return DatasetUpdateRes.success(response, processingTime, request.getDatasetId());
            
        } catch (Exception e) {
            long processingTime = System.currentTimeMillis() - startTime;
            log.error("데이터셋 수정 실패: datasetId={}, 처리시간={}ms, error={}", 
                    request.getDatasetId(), processingTime, e.getMessage(), e);
            throw new RuntimeException(String.format(DATASET_UPDATE_ERROR_MESSAGE, e.getMessage()), e);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * <p>데이터셋 ID로 SKT AI API를 호출하여 소프트 삭제를 수행합니다.</p>
     */
    @Override
    @Transactional
    public DatasetDeleteRes deleteDataset(DatasetDeleteReq request) {
        log.info("데이터셋 삭제 시작: datasetId={}", request.getDatasetId());
        
        long startTime = System.currentTimeMillis();
        
        try {
            // SKT AI API 호출
            sktAiDatasetClient.deleteDataset(request.getDatasetId());
            
            long processingTime = System.currentTimeMillis() - startTime;
            
            log.info("데이터셋 삭제 완료: datasetId={}, 처리시간={}ms", request.getDatasetId(), processingTime);
            
            return DatasetDeleteRes.success(request.getDatasetId(), processingTime);
            
        } catch (Exception e) {
            long processingTime = System.currentTimeMillis() - startTime;
            log.error("데이터셋 삭제 실패: datasetId={}, 처리시간={}ms, error={}", 
                    request.getDatasetId(), processingTime, e.getMessage(), e);
            throw new RuntimeException(String.format(DATASET_DELETE_ERROR_MESSAGE, e.getMessage()), e);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * <p>SKT AI API를 호출하여 삭제된 모든 데이터셋을 하드 삭제합니다.</p>
     */
    @Override
    @Transactional
    public DatasetHardDeleteRes hardDeleteAllDatasets() {
        log.info("데이터셋 완전 삭제 시작");
        
        long startTime = System.currentTimeMillis();
        
        try {
            // SKT AI API 호출
            Object response = sktAiDatasetClient.hardDeleteAllDatasets();
            
            long processingTime = System.currentTimeMillis() - startTime;
            
            log.info("데이터셋 완전 삭제 완료: 처리시간={}ms", processingTime);
            
            return DatasetHardDeleteRes.success(response, processingTime);
            
        } catch (Exception e) {
            long processingTime = System.currentTimeMillis() - startTime;
            log.error("데이터셋 완전 삭제 실패: 처리시간={}ms, error={}", processingTime, e.getMessage(), e);
            throw new RuntimeException(String.format(DATASET_HARD_DELETE_ERROR_MESSAGE, e.getMessage()), e);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * <p>파일과 메타데이터를 SKT AI API로 전송하여 데이터셋을 생성합니다.</p>
     */
    @Override
    @Transactional
    public DatasetCreateRes uploadFileDataset(DatasetUploadFileReq request) {
        log.info("파일 업로드 데이터셋 생성 시작: name={}, type={}, projectId={}", 
                request.getName(), request.getType(), request.getProjectId());
        
        long startTime = System.currentTimeMillis();
        
        try {
            // SKT AI API 호출
            DatasetResponse response = sktAiDatasetClient.uploadFileDataset(
                    request.getFile(),
                    request.getName(),
                    request.getType(),
                    request.getStatus(),
                    request.getDescription(),
                    request.getTags(),
                    request.getProjectId(),
                    request.getCreatedBy(),
                    request.getUpdatedBy(),
                    request.getPayload()
            );
            
            long processingTime = System.currentTimeMillis() - startTime;
            
            log.info("파일 업로드 데이터셋 생성 완료: datasetId={}, 처리시간={}ms", 
                    response.getId(), processingTime);
            
            return DatasetCreateRes.success(response, processingTime, DATASET_UPLOAD_SUCCESS_MESSAGE);
            
        } catch (Exception e) {
            long processingTime = System.currentTimeMillis() - startTime;
            log.error("파일 업로드 데이터셋 생성 실패: name={}, 처리시간={}ms, error={}", 
                    request.getName(), processingTime, e.getMessage(), e);
            throw new RuntimeException(String.format(DATASET_UPLOAD_ERROR_MESSAGE, e.getMessage()), e);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * <p>데이터셋 ID와 청크 크기로 SKT AI API를 호출하여 미리보기 데이터를 조회합니다.</p>
     */
    @Override
    public Object getDatasetPreview(DatasetPreviewReq request) {
        log.info("데이터셋 미리보기 조회 시작: datasetId={}, chunksize={}", 
                request.getDatasetId(), request.getChunksize());
        
        long startTime = System.currentTimeMillis();
        
        try {
            // SKT AI API 호출
            Object response = sktAiDatasetClient.getDatasetPreview(
                    request.getDatasetId(), 
                    request.getChunksize()
            );
            
            long processingTime = System.currentTimeMillis() - startTime;
            
            log.info("데이터셋 미리보기 조회 완료: datasetId={}, 처리시간={}ms", 
                    request.getDatasetId(), processingTime);
            
            return response;
            
        } catch (Exception e) {
            long processingTime = System.currentTimeMillis() - startTime;
            log.error("데이터셋 미리보기 조회 실패: datasetId={}, 처리시간={}ms, error={}", 
                    request.getDatasetId(), processingTime, e.getMessage(), e);
            throw new RuntimeException(String.format(DATASET_PREVIEW_ERROR_MESSAGE, e.getMessage()), e);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * <p>데이터셋 ID와 태그 목록으로 SKT AI API를 호출하여 태그를 업데이트합니다.</p>
     */
    @Override
    @Transactional
    public DatasetGetRes updateDatasetTags(DatasetTagUpdateReq request) {
        log.info("데이터셋 태그 업데이트 시작: datasetId={}, tagCount={}", 
                request.getDatasetId(), request.getTags().size());
        
        long startTime = System.currentTimeMillis();
        
        try {
            // SKT AI API 호출
            DatasetResponse response = sktAiDatasetClient.updateDatasetTags(
                    request.getDatasetId(), 
                    request.getTags()
            );
            
            long processingTime = System.currentTimeMillis() - startTime;
            
            log.info("데이터셋 태그 업데이트 완료: datasetId={}, 처리시간={}ms", 
                    request.getDatasetId(), processingTime);
            
            return DatasetGetRes.success(response, processingTime, DATASET_TAG_UPDATE_SUCCESS_MESSAGE);
            
        } catch (Exception e) {
            long processingTime = System.currentTimeMillis() - startTime;
            log.error("데이터셋 태그 업데이트 실패: datasetId={}, 처리시간={}ms, error={}", 
                    request.getDatasetId(), processingTime, e.getMessage(), e);
            throw new RuntimeException(String.format(DATASET_TAG_UPDATE_ERROR_MESSAGE, e.getMessage()), e);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * <p>데이터셋 ID와 삭제할 태그 목록으로 SKT AI API를 호출하여 태그를 삭제합니다.</p>
     */
    @Override
    @Transactional
    public DatasetGetRes deleteDatasetTags(DatasetTagDeleteReq request) {
        log.info("데이터셋 태그 삭제 시작: datasetId={}, tagCount={}", 
                request.getDatasetId(), request.getTags().size());
        
        long startTime = System.currentTimeMillis();
        
        try {
            // SKT AI API 호출
            DatasetResponse response = sktAiDatasetClient.deleteDatasetTags(
                    request.getDatasetId(), 
                    request.getTags()
            );
            
            long processingTime = System.currentTimeMillis() - startTime;
            
            log.info("데이터셋 태그 삭제 완료: datasetId={}, 처리시간={}ms", 
                    request.getDatasetId(), processingTime);
            
            return DatasetGetRes.success(response, processingTime, DATASET_TAG_DELETE_SUCCESS_MESSAGE);
            
        } catch (Exception e) {
            long processingTime = System.currentTimeMillis() - startTime;
            log.error("데이터셋 태그 삭제 실패: datasetId={}, 처리시간={}ms, error={}", 
                    request.getDatasetId(), processingTime, e.getMessage(), e);
            throw new RuntimeException(String.format(DATASET_TAG_DELETE_ERROR_MESSAGE, e.getMessage()), e);
        }
    }
}