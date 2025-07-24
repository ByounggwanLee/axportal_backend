package com.skax.aiportal.service.data.impl;

import static com.skax.aiportal.constant.DatasetConstants.*;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skax.aiportal.client.sktai.data.SktAiDatasetClient;
import com.skax.aiportal.client.sktai.data.dto.request.DatasetCreateRequest;
import com.skax.aiportal.client.sktai.data.dto.request.DatasetUpdateRequest;
import com.skax.aiportal.client.sktai.data.dto.response.DataSetPreviewResponse;
import com.skax.aiportal.client.sktai.data.dto.response.DatasetListResponse;
import com.skax.aiportal.client.sktai.data.dto.response.DatasetResponse;
import com.skax.aiportal.dto.data.DatasetInfo;
import com.skax.aiportal.dto.data.DatasetPageInfo;
import com.skax.aiportal.dto.data.DatasetPreviewInfo;
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
import com.skax.aiportal.dto.data.response.DatasetPreviewRes;
import com.skax.aiportal.dto.data.response.DatasetTagDeleteRes;
import com.skax.aiportal.dto.data.response.DatasetTagUpdateRes;
import com.skax.aiportal.dto.data.response.DatasetUpdateRes;
import com.skax.aiportal.dto.data.response.DatasetUploadFileRes;
import com.skax.aiportal.service.data.DatasetService;
import com.skax.aiportal.service.data.converter.DatasetDtoConverter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * SKT 데이터셋 관리 서비스 구현체
 * 
 * <p>SKT AI 플랫폼의 데이터셋 관리 기능을 구현하는 서비스 클래스입니다.
 * SktAiDatasetClient를 통해 SKT AI API와 통신하며, Client DTO와 Application DTO 간 변환을 담당합니다.</p>
 * 
 * <p>주요 기능:</p>
 * <ul>
 *   <li>SKT AI API 호출 및 응답 처리</li>
 *   <li>Client DTO ↔ Application DTO 변환</li>
 *   <li>비즈니스 로직 처리</li>
 *   <li>성능 모니터링 (응답 시간 측정)</li>
 *   <li>예외 처리 및 로깅</li>
 * </ul>
 * 
 * @author ByounggwanLee
 * @since 2025-07-24
 * @version 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SktDatasetServiceImpl implements DatasetService {

    private final SktAiDatasetClient sktAiDatasetClient;

    /**
     * {@inheritDoc}
     * 
     * <p>페이징, 정렬, 필터링 조건으로 SKT AI API를 호출하여 데이터셋 목록을 조회합니다.</p>
     */
    @Override
    @Transactional(readOnly = true)
    public DatasetListRes getDatasets(DatasetListReq request) {
        log.info("데이터셋 목록 조회 시작: page={}, size={}, sort={}, filter={}, search={}",
                request.getPage(), request.getSize(), request.getSort(), 
                request.getFilter(), request.getSearch());
        
        long startTime = System.currentTimeMillis();
        
        try {
            // SKT AI API 호출
            DatasetListResponse clientResponse = sktAiDatasetClient.getDatasets(
                    request.getPage(),
                    request.getSize(),
                    request.getSort(),
                    request.getFilter(),
                    request.getSearch()
            );
            
            long processingTime = System.currentTimeMillis() - startTime;
            
            // Client DTO를 Application DTO로 변환
            Object[] convertedData = DatasetDtoConverter.toDatasetListInfo(clientResponse);
            
            // 안전한 타입 검증 및 변환
            List<DatasetInfo> datasets = null;
            DatasetPageInfo pageInfo = null;
            
            if (convertedData != null && convertedData.length >= 2) {
                if (convertedData[0] instanceof List<?>) {
                    @SuppressWarnings("unchecked")
                    List<DatasetInfo> convertedList = (List<DatasetInfo>) convertedData[0];
                    datasets = convertedList;
                }
                if (convertedData[1] instanceof DatasetPageInfo) {
                    pageInfo = (DatasetPageInfo) convertedData[1];
                }
            }
            
            // null 체크 및 기본값 설정
            if (datasets == null) {
                datasets = List.of(); // 빈 리스트로 초기화
                log.warn("데이터셋 목록 변환 실패: 빈 리스트로 초기화");
            }
            
            log.info("데이터셋 목록 조회 완료: datasetCount={}, totalCount={}, 처리시간={}ms", 
                    datasets.size(), pageInfo != null ? pageInfo.getTotal() : 0, processingTime);
            
            return DatasetListRes.success(datasets, pageInfo, processingTime);
            
        } catch (Exception e) {
            long processingTime = System.currentTimeMillis() - startTime;
            log.error("데이터셋 목록 조회 실패: 처리시간={}ms, error={}", processingTime, e.getMessage(), e);
            throw new RuntimeException(String.format(DATASET_LIST_ERROR_MESSAGE, e.getMessage()), e);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * <p>데이터셋 생성 요청을 Client 요청 형식으로 변환하여 SKT AI API를 호출합니다.</p>
     */
    @Override
    @Transactional
    public DatasetCreateRes createDataset(DatasetCreateReq request) {
        log.info("데이터셋 생성 시작: name={}, type={}, datasourceId={}", 
                request.getName(), request.getType(), request.getDatasourceId());
        
        long startTime = System.currentTimeMillis();
        
        try {
            // Application DTO를 Client DTO로 변환
            DatasetCreateRequest createRequest = DatasetCreateRequest.builder()
                    .name(request.getName())
                    .type(request.getType())
                    .status(request.getStatus())
                    .description(request.getDescription())
                    .tags(request.getTags())
                    .projectId(request.getProjectId())
                    .createdBy(request.getCreatedBy())
                    .updatedBy(request.getUpdatedBy())
                    .datasourceId(request.getDatasourceId())
                    .build();

            // SKT AI API 호출
            DatasetResponse clientResponse = sktAiDatasetClient.createDataset(createRequest);
            
            long processingTime = System.currentTimeMillis() - startTime;
            
            // Client DTO를 Application DTO로 변환
            DatasetInfo datasetInfo = DatasetDtoConverter.toDatasetInfo(clientResponse);
            
            log.info("데이터셋 생성 완료: datasetId={}, name={}, 처리시간={}ms", 
                    datasetInfo.getId(), datasetInfo.getName(), processingTime);
            
            return DatasetCreateRes.success(datasetInfo, processingTime);
            
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
    @Transactional(readOnly = true)
    public DatasetGetRes getDatasetById(DatasetGetReq request) {
        log.info("데이터셋 조회 시작: datasetId={}", request.getDatasetId());
        
        long startTime = System.currentTimeMillis();
        
        try {
            // SKT AI API 호출
            DatasetResponse clientResponse = sktAiDatasetClient.getDatasetById(request.getDatasetId());
            
            long processingTime = System.currentTimeMillis() - startTime;
            
            // Client DTO를 Application DTO로 변환
            DatasetInfo datasetInfo = DatasetDtoConverter.toDatasetInfo(clientResponse);
            
            log.info("데이터셋 조회 완료: datasetId={}, name={}, 처리시간={}ms", 
                    datasetInfo.getId(), datasetInfo.getName(), processingTime);
            
            return DatasetGetRes.success(datasetInfo, processingTime);
            
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
     * <p>데이터셋 수정 요청을 Client 요청 형식으로 변환하여 SKT AI API를 호출합니다.</p>
     */
    @Override
    @Transactional
    public DatasetUpdateRes updateDataset(DatasetUpdateReq request) {
        log.info("데이터셋 수정 시작: datasetId={}", request.getDatasetId());
        
        long startTime = System.currentTimeMillis();
        
        try {
            // Application DTO를 Client DTO로 변환
            DatasetUpdateRequest updateRequest = DatasetUpdateRequest.builder()
                    .description(request.getDescription())
                    .build();

            // SKT AI API 호출 - 업데이트는 반환값이 없을 수 있음
            sktAiDatasetClient.updateDataset(request.getDatasetId(), updateRequest);
            
            long processingTime = System.currentTimeMillis() - startTime;
            
            log.info("데이터셋 수정 완료: datasetId={}, 처리시간={}ms", 
                    request.getDatasetId(), processingTime);
            
            return DatasetUpdateRes.success(null, processingTime, request.getDatasetId());
            
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
            
            log.info("데이터셋 삭제 완료: datasetId={}, 처리시간={}ms", 
                    request.getDatasetId(), processingTime);
            
            return DatasetDeleteRes.success(null, processingTime, request.getDatasetId());
            
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
     * <p>SKT AI API를 호출하여 삭제된 모든 데이터셋을 완전 제거합니다.</p>
     */
    @Override
    @Transactional
    public DatasetHardDeleteRes hardDeleteAllDatasets() {
        log.info("데이터셋 완전 삭제 시작");
        
        long startTime = System.currentTimeMillis();
        
        try {
            // SKT AI API 호출
            sktAiDatasetClient.hardDeleteAllDatasets();
            
            long processingTime = System.currentTimeMillis() - startTime;
            
            log.info("데이터셋 완전 삭제 완료: 처리시간={}ms", processingTime);
            
            return DatasetHardDeleteRes.success(null, processingTime);
            
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
    public DatasetUploadFileRes uploadFileDataset(DatasetUploadFileReq request) {
        log.info("파일 업로드 데이터셋 생성 시작: name={}, type={}, projectId={}", 
                request.getName(), request.getType(), request.getProjectId());
        
        long startTime = System.currentTimeMillis();
        
        try {
            // SKT AI API 호출
            DatasetResponse clientResponse = sktAiDatasetClient.uploadFileDataset(
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
            
            // Client DTO를 Application DTO로 변환
            DatasetInfo datasetInfo = DatasetDtoConverter.toDatasetInfo(clientResponse);
            
            // 파일 정보 안전하게 가져오기
            String fileName = null;
            Long fileSize = null;
            if (request.getFile() instanceof org.springframework.web.multipart.MultipartFile) {
                org.springframework.web.multipart.MultipartFile multipartFile = 
                    (org.springframework.web.multipart.MultipartFile) request.getFile();
                fileName = multipartFile.getOriginalFilename();
                fileSize = multipartFile.getSize();
            }
            
            log.info("파일 업로드 데이터셋 생성 완료: datasetId={}, uploadId={}, 처리시간={}ms", 
                    datasetInfo.getId(), fileName, processingTime);
            
            return DatasetUploadFileRes.success(datasetInfo, processingTime, fileName, fileSize);
            
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
    @Transactional(readOnly = true)
    public DatasetPreviewRes getDatasetPreview(DatasetPreviewReq request) {
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
            
            // 응답을 DataSetPreviewResponse로 캐스팅 및 변환
            DatasetPreviewInfo previewInfo = null;
            if (response instanceof DataSetPreviewResponse) {
                DataSetPreviewResponse clientPreviewResponse = (DataSetPreviewResponse) response;
                previewInfo = DatasetDtoConverter.toDatasetPreviewInfo(clientPreviewResponse);
            }
            
            log.info("데이터셋 미리보기 조회 완료: datasetId={}, sampleRowCount={}, 처리시간={}ms", 
                    request.getDatasetId(), previewInfo != null ? previewInfo.getPreviewRows() : 0, processingTime);
            
            return DatasetPreviewRes.success(previewInfo, processingTime, 
                    request.getDatasetId(), request.getChunksize(), 0L);
            
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
    public DatasetTagUpdateRes updateDatasetTags(DatasetTagUpdateReq request) {
        log.info("데이터셋 태그 업데이트 시작: datasetId={}, tagCount={}", 
                request.getDatasetId(), request.getTags().size());
        
        long startTime = System.currentTimeMillis();
        
        try {
            // SKT AI API 호출
            DatasetResponse clientResponse = sktAiDatasetClient.updateDatasetTags(
                    request.getDatasetId(), 
                    request.getTags()
            );
            
            long processingTime = System.currentTimeMillis() - startTime;
            
            // Client DTO를 Application DTO로 변환
            DatasetInfo datasetInfo = DatasetDtoConverter.toDatasetInfo(clientResponse);
            
            log.info("데이터셋 태그 업데이트 완료: datasetId={}, 처리시간={}ms", 
                    request.getDatasetId(), processingTime);
            
            return DatasetTagUpdateRes.success(datasetInfo, processingTime, 
                    request.getTags().stream()
                            .map(tag -> tag.getName())
                            .collect(java.util.stream.Collectors.toList()));
            
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
    public DatasetTagDeleteRes deleteDatasetTags(DatasetTagDeleteReq request) {
        log.info("데이터셋 태그 삭제 시작: datasetId={}, tagCount={}", 
                request.getDatasetId(), request.getTags().size());
        
        long startTime = System.currentTimeMillis();
        
        try {
            // SKT AI API 호출
            DatasetResponse clientResponse = sktAiDatasetClient.deleteDatasetTags(
                    request.getDatasetId(), 
                    request.getTags()
            );
            
            long processingTime = System.currentTimeMillis() - startTime;
            
            // Client DTO를 Application DTO로 변환
            DatasetInfo datasetInfo = DatasetDtoConverter.toDatasetInfo(clientResponse);
            
            log.info("데이터셋 태그 삭제 완료: datasetId={}, 처리시간={}ms", 
                    request.getDatasetId(), processingTime);
            
            // TODO: 삭제된 태그와 남은 태그 목록을 적절히 처리
            return DatasetTagDeleteRes.success(datasetInfo, processingTime, null, null);
            
        } catch (Exception e) {
            long processingTime = System.currentTimeMillis() - startTime;
            log.error("데이터셋 태그 삭제 실패: datasetId={}, 처리시간={}ms, error={}", 
                    request.getDatasetId(), processingTime, e.getMessage(), e);
            throw new RuntimeException(String.format(DATASET_TAG_DELETE_ERROR_MESSAGE, e.getMessage()), e);
        }
    }
}