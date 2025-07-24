package com.skax.aiportal.dto.data.response;

import static com.skax.aiportal.constant.DatasetConstants.*;

import java.util.List;

import com.skax.aiportal.dto.data.DatasetInfo;
import com.skax.aiportal.dto.data.DatasetPageInfo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 데이터셋 목록 조회 응답 DTO
 * 
 * <p>데이터셋 목록 조회 요청에 대한 응답 정보를 담는 DTO입니다.
 * 페이징된 데이터셋 목록과 메타데이터 정보를 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(description = "데이터셋 목록 조회 응답")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DatasetListRes {

    /**
     * 데이터셋 목록
     */
    @Schema(description = "데이터셋 목록")
    private List<DatasetInfo> datasets;

    /**
     * 페이지네이션 정보
     */
    @Schema(description = "페이지네이션 정보")
    private DatasetPageInfo pageInfo;

    /**
     * 응답 처리 시간 (밀리초)
     */
    @Schema(description = "API 응답 처리 시간 (밀리초)", example = "120")
    private Long processingTimeMs;

    /**
     * 응답 상태 메시지
     */
    @Schema(description = "응답 처리 상태 메시지", example = "데이터셋 목록 조회가 완료되었습니다.")
    private String statusMessage;

    /**
     * 정적 팩토리 메서드 - 성공 응답 생성
     * 
     * @param datasets 데이터셋 목록
     * @param pageInfo 페이지네이션 정보
     * @param processingTimeMs 처리 시간
     * @return 성공 응답 객체
     */
    public static DatasetListRes success(List<DatasetInfo> datasets, DatasetPageInfo pageInfo, Long processingTimeMs) {
        return DatasetListRes.builder()
                .datasets(datasets)
                .pageInfo(pageInfo)
                .processingTimeMs(processingTimeMs)
                .statusMessage(DATASET_LIST_SUCCESS_MESSAGE)
                .build();
    }

    /**
     * 정적 팩토리 메서드 - 성공 응답 생성 (커스텀 메시지)
     * 
     * @param datasets 데이터셋 목록
     * @param pageInfo 페이지네이션 정보
     * @param processingTimeMs 처리 시간
     * @param statusMessage 상태 메시지
     * @return 성공 응답 객체
     */
    public static DatasetListRes success(List<DatasetInfo> datasets, DatasetPageInfo pageInfo, 
                                         Long processingTimeMs, String statusMessage) {
        return DatasetListRes.builder()
                .datasets(datasets)
                .pageInfo(pageInfo)
                .processingTimeMs(processingTimeMs)
                .statusMessage(statusMessage)
                .build();
    }
}
