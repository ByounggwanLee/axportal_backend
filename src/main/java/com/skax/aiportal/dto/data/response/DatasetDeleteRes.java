package com.skax.aiportal.dto.data.response;

import static com.skax.aiportal.constant.DatasetConstants.*;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 데이터셋 삭제 응답 DTO
 * 
 * <p>데이터셋 삭제 요청에 대한 응답 정보를 담는 DTO입니다.
 * 삭제 처리 결과와 관련 정보를 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(description = "데이터셋 삭제 응답")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DatasetDeleteRes {

    /**
     * 삭제된 데이터셋 ID
     */
    @Schema(description = "삭제된 데이터셋의 고유 식별자", example = "dataset-12345")
    private String datasetId;

    /**
     * 응답 처리 시간 (밀리초)
     */
    @Schema(description = "API 응답 처리 시간 (밀리초)", example = "150")
    private Long processingTimeMs;

    /**
     * 응답 상태 메시지
     */
    @Schema(description = "응답 처리 상태 메시지", example = "데이터셋이 성공적으로 삭제되었습니다.")
    private String statusMessage;

    /**
     * 삭제 처리 상태
     */
    @Schema(description = "삭제 처리 상태", example = "SOFT_DELETED")
    private String deleteStatus;

    /**
     * 정적 팩토리 메서드 - 성공 응답 생성
     * 
     * @param datasetId 삭제된 데이터셋 ID
     * @param processingTimeMs 처리 시간
     * @return 성공 응답 객체
     */
    public static DatasetDeleteRes success(String datasetId, Long processingTimeMs) {
        return DatasetDeleteRes.builder()
                .datasetId(datasetId)
                .processingTimeMs(processingTimeMs)
                .statusMessage(DATASET_DELETE_SUCCESS_MESSAGE)
                .deleteStatus("SOFT_DELETED")
                .build();
    }

    /**
     * 정적 팩토리 메서드 - 성공 응답 생성 (커스텀 메시지)
     * 
     * @param datasetId 삭제된 데이터셋 ID
     * @param processingTimeMs 처리 시간
     * @param statusMessage 상태 메시지
     * @return 성공 응답 객체
     */
    public static DatasetDeleteRes success(String datasetId, Long processingTimeMs, String statusMessage) {
        return DatasetDeleteRes.builder()
                .datasetId(datasetId)
                .processingTimeMs(processingTimeMs)
                .statusMessage(statusMessage)
                .deleteStatus("SOFT_DELETED")
                .build();
    }
}
