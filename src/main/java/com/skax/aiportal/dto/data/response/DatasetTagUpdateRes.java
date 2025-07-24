package com.skax.aiportal.dto.data.response;

import static com.skax.aiportal.constant.DatasetConstants.DATASET_TAG_UPDATE_SUCCESS_MESSAGE;

import java.util.List;

import com.skax.aiportal.dto.data.DatasetInfo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 데이터셋 태그 업데이트 응답 DTO
 * 
 * <p>데이터셋 태그 업데이트 요청에 대한 응답 정보를 담는 DTO입니다.
 * 업데이트된 데이터셋의 정보와 태그 변경 내용을 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-24
 * @version 1.0
 */
@Schema(description = "데이터셋 태그 업데이트 응답")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DatasetTagUpdateRes {

    /**
     * 업데이트된 데이터셋 정보
     */
    @Schema(description = "태그가 업데이트된 데이터셋의 정보")
    private DatasetInfo dataset;

    /**
     * 응답 처리 시간 (밀리초)
     */
    @Schema(description = "API 응답 처리 시간 (밀리초)", example = "275")
    private Long processingTimeMs;

    /**
     * 응답 상태 메시지
     */
    @Schema(description = "응답 처리 상태 메시지", example = "데이터셋 태그 업데이트가 완료되었습니다.")
    private String statusMessage;

    /**
     * 업데이트된 태그 목록
     */
    @Schema(description = "업데이트된 태그 이름 목록")
    private List<String> updatedTags;

    /**
     * 정적 팩토리 메서드 - 성공 응답 생성
     * 
     * @param dataset 업데이트된 데이터셋 정보
     * @param processingTimeMs 처리 시간
     * @param updatedTags 업데이트된 태그 목록
     * @return 성공 응답 객체
     */
    public static DatasetTagUpdateRes success(DatasetInfo dataset, Long processingTimeMs, List<String> updatedTags) {
        return DatasetTagUpdateRes.builder()
                .dataset(dataset)
                .processingTimeMs(processingTimeMs)
                .statusMessage(DATASET_TAG_UPDATE_SUCCESS_MESSAGE)
                .updatedTags(updatedTags)
                .build();
    }

    /**
     * 정적 팩토리 메서드 - 성공 응답 생성 (커스텀 메시지)
     * 
     * @param dataset 업데이트된 데이터셋 정보
     * @param processingTimeMs 처리 시간
     * @param updatedTags 업데이트된 태그 목록
     * @param statusMessage 상태 메시지
     * @return 성공 응답 객체
     */
    public static DatasetTagUpdateRes success(DatasetInfo dataset, Long processingTimeMs, 
                                              List<String> updatedTags, String statusMessage) {
        return DatasetTagUpdateRes.builder()
                .dataset(dataset)
                .processingTimeMs(processingTimeMs)
                .statusMessage(statusMessage)
                .updatedTags(updatedTags)
                .build();
    }
}
