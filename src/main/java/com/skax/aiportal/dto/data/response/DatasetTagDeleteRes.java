package com.skax.aiportal.dto.data.response;

import static com.skax.aiportal.constant.DatasetConstants.*;

import java.util.List;

import com.skax.aiportal.dto.data.DatasetInfo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 데이터셋 태그 삭제 응답 DTO
 * 
 * <p>데이터셋 태그 삭제 요청에 대한 응답 정보를 담는 DTO입니다.
 * 삭제된 태그 정보와 처리 결과를 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(description = "데이터셋 태그 삭제 응답")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DatasetTagDeleteRes {

    /**
     * 업데이트된 데이터셋 정보
     */
    @Schema(description = "태그가 삭제된 데이터셋의 정보")
    private DatasetInfo dataset;

    /**
     * 응답 처리 시간 (밀리초)
     */
    @Schema(description = "API 응답 처리 시간 (밀리초)", example = "180")
    private Long processingTimeMs;

    /**
     * 응답 상태 메시지
     */
    @Schema(description = "응답 처리 상태 메시지", example = "데이터셋 태그가 성공적으로 삭제되었습니다.")
    private String statusMessage;

    /**
     * 데이터셋 ID
     */
    @Schema(description = "태그가 삭제된 데이터셋의 고유 식별자", example = "dataset-12345")
    private String datasetId;

    /**
     * 삭제된 태그 목록
     */
    @Schema(description = "삭제된 태그 목록", example = "[\"임시\", \"테스트\"]")
    private List<String> deletedTags;

    /**
     * 삭제된 태그 수
     */
    @Schema(description = "삭제된 태그의 수", example = "2")
    private Integer deletedTagCount;

    /**
     * 남은 태그 목록
     */
    @Schema(description = "삭제 후 남은 태그 목록", example = "[\"ML\", \"데이터분석\"]")
    private List<String> remainingTags;

    /**
     * 정적 팩토리 메서드 - 성공 응답 생성
     * 
     * @param dataset 업데이트된 데이터셋 정보
     * @param processingTimeMs 처리 시간
     * @param deletedTags 삭제된 태그 목록
     * @param remainingTags 남은 태그 목록
     * @return 성공 응답 객체
     */
    public static DatasetTagDeleteRes success(DatasetInfo dataset, Long processingTimeMs, 
                                              List<String> deletedTags, List<String> remainingTags) {
        return DatasetTagDeleteRes.builder()
                .dataset(dataset)
                .processingTimeMs(processingTimeMs)
                .statusMessage(DATASET_TAG_DELETE_SUCCESS_MESSAGE)
                .datasetId(dataset != null ? dataset.getId() : null)
                .deletedTags(deletedTags)
                .deletedTagCount(deletedTags != null ? deletedTags.size() : 0)
                .remainingTags(remainingTags)
                .build();
    }

    /**
     * 정적 팩토리 메서드 - 성공 응답 생성 (커스텀 메시지)
     * 
     * @param dataset 업데이트된 데이터셋 정보
     * @param processingTimeMs 처리 시간
     * @param statusMessage 상태 메시지
     * @param deletedTags 삭제된 태그 목록
     * @param remainingTags 남은 태그 목록
     * @return 성공 응답 객체
     */
    public static DatasetTagDeleteRes success(DatasetInfo dataset, Long processingTimeMs, 
                                              String statusMessage, List<String> deletedTags, List<String> remainingTags) {
        return DatasetTagDeleteRes.builder()
                .dataset(dataset)
                .processingTimeMs(processingTimeMs)
                .statusMessage(statusMessage)
                .datasetId(dataset != null ? dataset.getId() : null)
                .deletedTags(deletedTags)
                .deletedTagCount(deletedTags != null ? deletedTags.size() : 0)
                .remainingTags(remainingTags)
                .build();
    }
}
