package com.skax.aiportal.dto.data.response;

import static com.skax.aiportal.constant.DatasetConstants.*;

import com.skax.aiportal.client.sktai.data.dto.response.DatasetListResponse;

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
     * SKT AI API 응답 데이터
     */
    @Schema(description = "SKT AI API로부터 받은 데이터셋 목록 응답")
    private DatasetListResponse data;

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
     * @param data SKT AI API 응답 데이터
     * @param processingTimeMs 처리 시간
     * @return 성공 응답 객체
     */
    public static DatasetListRes success(DatasetListResponse data, Long processingTimeMs) {
        return DatasetListRes.builder()
                .data(data)
                .processingTimeMs(processingTimeMs)
                .statusMessage(DATASET_LIST_SUCCESS_MESSAGE)
                .build();
    }

    /**
     * 정적 팩토리 메서드 - 성공 응답 생성 (커스텀 메시지)
     * 
     * @param data SKT AI API 응답 데이터
     * @param processingTimeMs 처리 시간
     * @param statusMessage 상태 메시지
     * @return 성공 응답 객체
     */
    public static DatasetListRes success(DatasetListResponse data, Long processingTimeMs, String statusMessage) {
        return DatasetListRes.builder()
                .data(data)
                .processingTimeMs(processingTimeMs)
                .statusMessage(statusMessage)
                .build();
    }
}
