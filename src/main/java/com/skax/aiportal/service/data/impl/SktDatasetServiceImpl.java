package com.skax.aiportal.service.data.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.skax.aiportal.client.sktai.data.SktAiDatasetClient;
import com.skax.aiportal.client.sktai.data.dto.DatasetTag;
import com.skax.aiportal.dto.data.request.DatasetCreateRequest;
import com.skax.aiportal.dto.data.request.DatasetUpdateRequest;
import com.skax.aiportal.dto.data.request.DatasetUploadRequest;
import com.skax.aiportal.dto.data.request.DatasetTagUpdateRequest;
import com.skax.aiportal.dto.data.response.DatasetResponse;
import com.skax.aiportal.dto.data.response.DatasetListResponse;
import com.skax.aiportal.dto.data.response.DatasetPreviewResponse;
import com.skax.aiportal.service.data.DatasetService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * SKT 데이터셋 서비스 구현 클래스
 * 
 * <p>SKT AI 플랫폼의 데이터셋 관련 비즈니스 로직을 구현합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SktDatasetServiceImpl implements DatasetService {

    private final SktAiDatasetClient datasetClient;

    @Override
    public DatasetListResponse getDatasets(int page, int size, String sort, String filter, String search) {
        log.info("데이터셋 목록 조회 - page: {}, size: {}, sort: {}, filter: {}, search: {}", 
                page, size, sort, filter, search);
        
        try {
            com.skax.aiportal.client.sktai.data.dto.response.DatasetListResponse clientResponse = 
                    datasetClient.getDatasets(page, size, sort, filter, search);
            
            DatasetListResponse response = convertToDatasetListResponse(clientResponse);
            
            log.info("데이터셋 목록 조회 성공 - 조회된 데이터셋 수: {}", 
                    response.getData() != null ? response.getData().size() : 0);
            return response;
            
        } catch (Exception e) {
            log.error("데이터셋 목록 조회 실패: 오류={}", e.getMessage(), e);
            throw new RuntimeException("데이터셋 목록 조회에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public DatasetResponse getDatasetById(String datasetId) {
        log.info("데이터셋 상세 조회 - datasetId: {}", datasetId);
        
        try {
            com.skax.aiportal.client.sktai.data.dto.response.DatasetResponse clientResponse = 
                    datasetClient.getDatasetById(datasetId);
            
            DatasetResponse response = convertToDatasetResponse(clientResponse);
            
            log.info("데이터셋 상세 조회 성공 - datasetId: {}, name: {}", datasetId, response.getName());
            return response;
            
        } catch (Exception e) {
            log.error("데이터셋 상세 조회 실패: datasetId={}, 오류={}", datasetId, e.getMessage(), e);
            throw new RuntimeException("데이터셋 상세 조회에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public DatasetResponse createDataset(DatasetCreateRequest request) {
        log.info("데이터셋 생성 - name: {}, type: {}, projectId: {}", 
                request.getName(), request.getType(), request.getProjectId());
        
        try {
            com.skax.aiportal.client.sktai.data.dto.request.DatasetCreateRequest clientRequest = 
                    convertToClientCreateRequest(request);
            
            com.skax.aiportal.client.sktai.data.dto.response.DatasetResponse clientResponse = 
                    datasetClient.createDataset(clientRequest);
            
            DatasetResponse response = convertToDatasetResponse(clientResponse);
            
            log.info("데이터셋 생성 성공 - id: {}, name: {}", response.getId(), response.getName());
            return response;
            
        } catch (Exception e) {
            log.error("데이터셋 생성 실패: name={}, 오류={}", request.getName(), e.getMessage(), e);
            throw new RuntimeException("데이터셋 생성에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public Object updateDataset(String datasetId, DatasetUpdateRequest request) {
        log.info("데이터셋 수정 - datasetId: {}", datasetId);
        
        try {
            com.skax.aiportal.client.sktai.data.dto.request.DatasetUpdateRequest clientRequest = 
                    convertToClientUpdateRequest(request);
            
            Object response = datasetClient.updateDataset(datasetId, clientRequest);
            
            log.info("데이터셋 수정 성공 - datasetId: {}", datasetId);
            return response;
            
        } catch (Exception e) {
            log.error("데이터셋 수정 실패: datasetId={}, 오류={}", datasetId, e.getMessage(), e);
            throw new RuntimeException("데이터셋 수정에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteDataset(String datasetId) {
        log.info("데이터셋 삭제 - datasetId: {}", datasetId);
        
        try {
            datasetClient.deleteDataset(datasetId);
            
            log.info("데이터셋 삭제 성공 - datasetId: {}", datasetId);
            
        } catch (Exception e) {
            log.error("데이터셋 삭제 실패: datasetId={}, 오류={}", datasetId, e.getMessage(), e);
            throw new RuntimeException("데이터셋 삭제에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public Object hardDeleteAllDatasets() {
        log.info("모든 삭제된 데이터셋 하드 삭제");
        
        try {
            Object response = datasetClient.hardDeleteAllDatasets();
            
            log.info("모든 삭제된 데이터셋 하드 삭제 완료");
            return response;
            
        } catch (Exception e) {
            log.error("모든 삭제된 데이터셋 하드 삭제 실패: 오류={}", e.getMessage(), e);
            throw new RuntimeException("모든 삭제된 데이터셋 하드 삭제에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public DatasetResponse uploadFileDataset(MultipartFile file, DatasetUploadRequest request) {
        log.info("파일 업로드 데이터셋 생성 - name: {}, type: {}, fileName: {}", 
                request.getName(), request.getType(), file.getOriginalFilename());
        
        try {
            com.skax.aiportal.client.sktai.data.dto.response.DatasetResponse clientResponse = 
                    datasetClient.uploadFileDataset(
                            file,
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
            
            DatasetResponse response = convertToDatasetResponse(clientResponse);
            
            log.info("파일 업로드 데이터셋 생성 성공 - id: {}, name: {}", response.getId(), response.getName());
            return response;
            
        } catch (Exception e) {
            log.error("파일 업로드 데이터셋 생성 실패: name={}, 오류={}", request.getName(), e.getMessage(), e);
            throw new RuntimeException("파일 업로드 데이터셋 생성에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public DatasetPreviewResponse getDatasetPreview(String datasetId, int chunksize) {
        log.info("데이터셋 미리보기 조회 - datasetId: {}, chunksize: {}", datasetId, chunksize);
        
        try {
            Object clientResponse = datasetClient.getDatasetPreview(datasetId, chunksize);
            
            // 클라이언트 응답을 서비스 응답으로 변환
            DatasetPreviewResponse response = convertToDatasetPreviewResponse(clientResponse, datasetId, chunksize);
            
            log.info("데이터셋 미리보기 조회 성공 - datasetId: {}", datasetId);
            return response;
            
        } catch (Exception e) {
            log.error("데이터셋 미리보기 조회 실패: datasetId={}, 오류={}", datasetId, e.getMessage(), e);
            throw new RuntimeException("데이터셋 미리보기 조회에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public DatasetResponse updateDatasetTags(String datasetId, DatasetTagUpdateRequest request) {
        log.info("데이터셋 태그 업데이트 - datasetId: {}, tags: {}", datasetId, request.getTags().size());
        
        try {
            List<DatasetTag> clientTags = convertToClientTags(request.getTags());
            
            com.skax.aiportal.client.sktai.data.dto.response.DatasetResponse clientResponse = 
                    datasetClient.updateDatasetTags(datasetId, clientTags);
            
            DatasetResponse response = convertToDatasetResponse(clientResponse);
            
            log.info("데이터셋 태그 업데이트 성공 - datasetId: {}", datasetId);
            return response;
            
        } catch (Exception e) {
            log.error("데이터셋 태그 업데이트 실패: datasetId={}, 오류={}", datasetId, e.getMessage(), e);
            throw new RuntimeException("데이터셋 태그 업데이트에 실패했습니다: " + e.getMessage(), e);
        }
    }

    @Override
    public DatasetResponse deleteDatasetTags(String datasetId, DatasetTagUpdateRequest request) {
        log.info("데이터셋 태그 삭제 - datasetId: {}, tags: {}", datasetId, request.getTags().size());
        
        try {
            List<DatasetTag> clientTags = convertToClientTags(request.getTags());
            
            com.skax.aiportal.client.sktai.data.dto.response.DatasetResponse clientResponse = 
                    datasetClient.deleteDatasetTags(datasetId, clientTags);
            
            DatasetResponse response = convertToDatasetResponse(clientResponse);
            
            log.info("데이터셋 태그 삭제 성공 - datasetId: {}", datasetId);
            return response;
            
        } catch (Exception e) {
            log.error("데이터셋 태그 삭제 실패: datasetId={}, 오류={}", datasetId, e.getMessage(), e);
            throw new RuntimeException("데이터셋 태그 삭제에 실패했습니다: " + e.getMessage(), e);
        }
    }

    // ==================== 변환 메서드 ====================

    /**
     * 클라이언트 요청으로 변환
     */
    private com.skax.aiportal.client.sktai.data.dto.request.DatasetCreateRequest convertToClientCreateRequest(
            DatasetCreateRequest request) {
        return com.skax.aiportal.client.sktai.data.dto.request.DatasetCreateRequest.builder()
                .name(request.getName())
                .type(request.getType())
                .description(request.getDescription())
                .tags(convertStringTagsToClientTags(request.getTags()))
                .status(request.getStatus())
                .projectId(request.getProjectId())
                .createdBy(request.getCreatedBy())
                .updatedBy(request.getUpdatedBy())
                .policy(request.getPayload())
                .datasourceId("default") // 기본값 설정
                .build();
    }

    /**
     * 클라이언트 업데이트 요청으로 변환
     */
    private com.skax.aiportal.client.sktai.data.dto.request.DatasetUpdateRequest convertToClientUpdateRequest(
            DatasetUpdateRequest request) {
        return com.skax.aiportal.client.sktai.data.dto.request.DatasetUpdateRequest.builder()
               // .name(request.getName())
               // .type(request.getType())
                .description(request.getDescription())
               // .tags(convertStringTagsToClientTags(request.getTags()))
               // .status(request.getStatus())
                .projectId(request.getProjectId())
               // .updatedBy(request.getUpdatedBy())
               // .policy(request.getPayload())
                .build();
    }

    /**
     * 클라이언트 응답을 서비스 응답으로 변환
     */
    private DatasetResponse convertToDatasetResponse(
            com.skax.aiportal.client.sktai.data.dto.response.DatasetResponse clientResponse) {
        return DatasetResponse.builder()
                .id(clientResponse.getId())
                .name(clientResponse.getName())
                .type(clientResponse.getType())
                .description(clientResponse.getDescription())
                .tags(convertFromClientTags(clientResponse.getTags()))
                .status(clientResponse.getStatus())
                .projectId(clientResponse.getProjectId())
                .filePath(clientResponse.getFilePath())
                .createdAt(clientResponse.getCreatedAt())
                .updatedAt(clientResponse.getUpdatedAt())
                .createdBy(clientResponse.getCreatedBy())
                .updatedBy(clientResponse.getUpdatedBy())
                .build();
    }

    /**
     * 클라이언트 목록 응답을 서비스 응답으로 변환
     */
    private DatasetListResponse convertToDatasetListResponse(
            com.skax.aiportal.client.sktai.data.dto.response.DatasetListResponse clientResponse) {
        return DatasetListResponse.builder()
                .data(clientResponse.getData().stream()
                        .map(this::convertToDatasetResponse)
                        .collect(Collectors.toList()))
                .build();
    }

    /**
     * 클라이언트 미리보기 응답을 서비스 응답으로 변환
     */
    private DatasetPreviewResponse convertToDatasetPreviewResponse(Object clientResponse, String datasetId, int chunksize) {
        // 실제 구현에서는 clientResponse의 구조에 따라 적절히 변환
        return DatasetPreviewResponse.builder()
                .datasetId(datasetId)
                .chunkSize(chunksize)
                // 추가적인 변환 로직 구현 필요
                .build();
    }

    /**
     * 문자열 태그 목록을 클라이언트 태그로 변환
     */
    private List<com.skax.aiportal.client.sktai.data.dto.DatasetTag> convertStringTagsToClientTags(List<String> tags) {
        if (tags == null) return null;
        
        return tags.stream()
                .map(tag -> com.skax.aiportal.client.sktai.data.dto.DatasetTag.builder()
                        .name(tag)
                        .build())
                .collect(Collectors.toList());
    }

    /**
     * 서비스 태그를 클라이언트 태그로 변환
     */
    private List<com.skax.aiportal.client.sktai.data.dto.DatasetTag> convertToClientTags(
            List<DatasetTagUpdateRequest.DatasetTag> tags) {
        return tags.stream()
                .map(tag -> com.skax.aiportal.client.sktai.data.dto.DatasetTag.builder()
                        .name(tag.getName())
                        .build())
                .collect(Collectors.toList());
    }

    /**
     * 클라이언트 태그를 서비스 태그로 변환
     */
    private List<DatasetResponse.DatasetTag> convertFromClientTags(
            List<com.skax.aiportal.client.sktai.data.dto.DatasetTag> clientTags) {
        if (clientTags == null) return null;
        
        return clientTags.stream()
                .map(tag -> DatasetResponse.DatasetTag.builder()
                        .name(tag.getName())
                        .build())
                .collect(Collectors.toList());
    }

}
