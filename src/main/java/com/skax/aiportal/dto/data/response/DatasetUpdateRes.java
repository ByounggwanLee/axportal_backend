package com.skax.aiportal.dto.data.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 데이터셋 수정 응답 DTO
 * 
 * <p>데이터셋 수정 요청에 대한 응답 정보를 담는 DTO입니다.
 * 수정 처리 결과와 관련 정보를 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(description = "데이터셋 수정 응답")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DatasetUpdateRes {

    /**
     * 수정된 데이터셋 정보
     */
    @Schema(description = "수정된 데이터셋 정보 (SKT AI API 응답)")
    private Object data;

    /**
     * 응답 처리 시간 (밀리초)
     */
    @Schema(description = "API 응답 처리 시간 (밀리초)", example = "200")
    private Long processingTimeMs;

    /**
     * 응답 상태 메시지
     */
    @Schema(description = "응답 처리 상태 메시지", example = "데이터셋 정보가 성공적으로 수정되었습니다.")
    private String statusMessage;

    /**
     * 수정된 데이터셋 ID
     */
    @Schema(description = "수정된 데이터셋의 고유 식별자", example = "dataset-12345")
    private String datasetId;

    /**
     * 정적 팩토리 메서드 - 성공 응답 생성
     * 
     * @param data 수정된 데이터셋 정보
     * @param processingTimeMs 처리 시간
     * @param datasetId 데이터셋 ID
     * @return 성공 응답 객체
     */
    public static DatasetUpdateRes success(Object data, Long processingTimeMs, String datasetId) {
        return DatasetUpdateRes.builder()
                .data(data)
                .processingTimeMs(processingTimeMs)
                .statusMessage("데이터셋 정보가 성공적으로 수정되었습니다.")
                .datasetId(datasetId)
                .build();
    }

    /**
     * 정적 팩토리 메서드 - 성공 응답 생성 (커스텀 메시지)
     * 
     * @param data 수정된 데이터셋 정보
     * @param processingTimeMs 처리 시간
     * @param datasetId 데이터셋 ID
     * @param statusMessage 상태 메시지
     * @return 성공 응답 객체
     */
    public static DatasetUpdateRes success(Object data, Long processingTimeMs, String datasetId, String statusMessage) {
        return DatasetUpdateRes.builder()
                .data(data)
                .processingTimeMs(processingTimeMs)
                .statusMessage(statusMessage)
                .datasetId(datasetId)
                .build();
    }
}
