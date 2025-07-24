package com.skax.aiportal.service.data.converter;

import java.util.List;
import java.util.stream.Collectors;

import com.skax.aiportal.client.sktai.data.dto.DatasetTag;
import com.skax.aiportal.client.sktai.data.dto.Pagination;
import com.skax.aiportal.client.sktai.data.dto.Payload;
import com.skax.aiportal.client.sktai.data.dto.response.DataSetPreviewResponse;
import com.skax.aiportal.client.sktai.data.dto.response.DatasetListResponse;
import com.skax.aiportal.client.sktai.data.dto.response.DatasetResponse;
import com.skax.aiportal.dto.data.DatasetInfo;
import com.skax.aiportal.dto.data.DatasetPageInfo;
import com.skax.aiportal.dto.data.DatasetPreviewInfo;

/**
 * Client DTO와 Application DTO 간 변환 유틸리티
 * 
 * <p>SKT AI Client DTO를 애플리케이션 계층의 DTO로 변환하는 기능을 제공합니다.
 * Client DTO와 Application DTO 간의 의존성을 분리하고 변환 로직을 중앙화합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-24
 * @version 1.0
 */
public final class DatasetDtoConverter {

    private DatasetDtoConverter() {
        // 유틸리티 클래스는 인스턴스화 방지
    }

    /**
     * DatasetResponse를 DatasetInfo로 변환
     * 
     * @param clientDto Client DTO
     * @return Application DTO
     */
    public static DatasetInfo toDatasetInfo(DatasetResponse clientDto) {
        if (clientDto == null) {
            return null;
        }

        return DatasetInfo.builder()
                .id(clientDto.getId())
                .name(clientDto.getName())
                .type(clientDto.getType())
                .description(clientDto.getDescription())
                .tags(clientDto.getTags() != null ? 
                      clientDto.getTags().stream()
                              .map(DatasetTag::getName)
                              .collect(Collectors.toList()) : null)
                .status(clientDto.getStatus())
                .projectId(clientDto.getProjectId())
                .isDeleted(clientDto.getIsDeleted())
                .createdAt(clientDto.getCreatedAt())
                .updatedAt(clientDto.getUpdatedAt())
                .createdBy(clientDto.getCreatedBy())
                .updatedBy(clientDto.getUpdatedBy())
                .datasourceId(clientDto.getDatasourceId())
                .datasourceFiles(clientDto.getDatasourceFiles())
                .filePath(clientDto.getFilePath())
                .build();
    }

    /**
     * DatasetResponse 목록을 DatasetInfo 목록으로 변환
     * 
     * @param clientDtos Client DTO 목록
     * @return Application DTO 목록
     */
    public static List<DatasetInfo> toDatasetInfoList(List<DatasetResponse> clientDtos) {
        if (clientDtos == null) {
            return null;
        }

        return clientDtos.stream()
                .map(DatasetDtoConverter::toDatasetInfo)
                .collect(Collectors.toList());
    }

    /**
     * Pagination을 DatasetPageInfo로 변환
     * 
     * @param pagination Client Pagination 정보
     * @return Application DatasetPageInfo
     */
    public static DatasetPageInfo toDatasetPageInfo(Pagination pagination) {
        if (pagination == null) {
            return null;
        }

        return DatasetPageInfo.builder()
                .page(pagination.getPage())
                .itemsPerPage(pagination.getItemsPerPage())
                .total(pagination.getTotal())
                .lastPage(pagination.getLastPage())
                .from(pagination.getFrom())
                .to(pagination.getTo())
                .hasNext(pagination.getPage() < pagination.getLastPage())
                .hasPrev(pagination.getPage() > 1)
                .build();
    }

    /**
     * Payload를 DatasetPageInfo로 변환
     * 
     * @param payload Client Payload 정보
     * @return Application DatasetPageInfo
     */
    public static DatasetPageInfo toDatasetPageInfo(Payload payload) {
        if (payload == null || payload.getPagination() == null) {
            return null;
        }

        return toDatasetPageInfo(payload.getPagination());
    }

    /**
     * DataSetPreviewResponse를 DatasetPreviewInfo로 변환
     * 
     * @param clientDto Client 미리보기 DTO
     * @return Application 미리보기 DTO
     */
    public static DatasetPreviewInfo toDatasetPreviewInfo(DataSetPreviewResponse clientDto) {
        if (clientDto == null) {
            return null;
        }

        return DatasetPreviewInfo.builder()
                .data(clientDto.getData())
                .totalRows(clientDto.getData() != null ? (long) clientDto.getData().size() : 0L)
                .previewRows(clientDto.getData() != null ? clientDto.getData().size() : 0)
                .columns(null) // 필요시 추가 구현
                .dataTypes(null) // 필요시 추가 구현
                .build();
    }

    /**
     * DatasetListResponse를 DatasetInfo 목록과 DatasetPageInfo로 분리 변환
     * 
     * @param clientDto Client 목록 응답 DTO
     * @return [DatasetInfo 목록, DatasetPageInfo] 배열
     */
    public static Object[] toDatasetListInfo(DatasetListResponse clientDto) {
        if (clientDto == null) {
            return new Object[]{null, null};
        }

        List<DatasetInfo> datasets = toDatasetInfoList(clientDto.getData());
        DatasetPageInfo pageInfo = toDatasetPageInfo(clientDto.getPayload());

        return new Object[]{datasets, pageInfo};
    }
}
