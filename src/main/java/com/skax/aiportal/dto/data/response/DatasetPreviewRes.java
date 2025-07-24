package com.skax.aiportal.dto.data.response;

import static com.skax.aiportal.constant.DatasetConstants.DATASET_PREVIEW_SUCCESS_MESSAGE;

import com.skax.aiportal.dto.data.DatasetPreviewInfo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 데이터셋 미리보기 응답 DTO
 * 
 * <p>데이터셋 미리보기 요청에 대한 응답 정보를 담는 DTO입니다.
 * 미리보기 데이터와 관련 메타데이터를 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-24
 * @version 1.0
 */
@Schema(description = "데이터셋 미리보기 응답")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DatasetPreviewRes {

    /**
     * 미리보기 데이터 정보
     */
    @Schema(description = "데이터셋의 미리보기 정보")
    private DatasetPreviewInfo previewData;

    /**
     * 응답 처리 시간 (밀리초)
     */
    @Schema(description = "API 응답 처리 시간 (밀리초)", example = "350")
    private Long processingTimeMs;

    /**
     * 응답 상태 메시지
     */
    @Schema(description = "응답 처리 상태 메시지", example = "데이터셋 미리보기가 완료되었습니다.")
    private String statusMessage;

    /**
     * 요청한 데이터셋 ID
     */
    @Schema(description = "미리보기를 요청한 데이터셋의 고유 식별자", example = "dataset-12345")
    private String datasetId;

    /**
     * 요청한 청크 크기
     */
    @Schema(description = "미리보기 요청 시 지정한 청크 크기", example = "100")
    private Integer chunkSize;

    /**
     * 실제 반환된 행 수
     */
    @Schema(description = "실제로 반환된 미리보기 데이터의 행 수", example = "50")
    private Long actualRows;

    /**
     * 정적 팩토리 메서드 - 성공 응답 생성
     * 
     * @param previewData 미리보기 데이터 정보
     * @param processingTimeMs 처리 시간
     * @param datasetId 데이터셋 ID
     * @param chunkSize 청크 크기
     * @param actualRows 실제 반환된 행 수
     * @return 성공 응답 객체
     */
    public static DatasetPreviewRes success(DatasetPreviewInfo previewData, Long processingTimeMs, 
                                            String datasetId, Integer chunkSize, Long actualRows) {
        return DatasetPreviewRes.builder()
                .previewData(previewData)
                .processingTimeMs(processingTimeMs)
                .statusMessage(DATASET_PREVIEW_SUCCESS_MESSAGE)
                .datasetId(datasetId)
                .chunkSize(chunkSize)
                .actualRows(actualRows)
                .build();
    }

    /**
     * 정적 팩토리 메서드 - 성공 응답 생성 (커스텀 메시지)
     * 
     * @param previewData 미리보기 데이터 정보
     * @param processingTimeMs 처리 시간
     * @param datasetId 데이터셋 ID
     * @param chunkSize 청크 크기
     * @param actualRows 실제 반환된 행 수
     * @param statusMessage 상태 메시지
     * @return 성공 응답 객체
     */
    public static DatasetPreviewRes success(DatasetPreviewInfo previewData, Long processingTimeMs, 
                                            String datasetId, Integer chunkSize, Long actualRows,
                                            String statusMessage) {
        return DatasetPreviewRes.builder()
                .previewData(previewData)
                .processingTimeMs(processingTimeMs)
                .statusMessage(statusMessage)
                .datasetId(datasetId)
                .chunkSize(chunkSize)
                .actualRows(actualRows)
                .build();
    }
}
