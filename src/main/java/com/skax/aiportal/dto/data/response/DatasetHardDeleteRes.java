package com.skax.aiportal.dto.data.response;

import static com.skax.aiportal.constant.DatasetConstants.*;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 데이터셋 하드 삭제 응답 DTO
 * 
 * <p>삭제된 모든 데이터셋의 하드 삭제 요청에 대한 응답 정보를 담는 DTO입니다.
 * 하드 삭제 처리 결과와 관련 정보를 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(description = "데이터셋 하드 삭제 응답")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DatasetHardDeleteRes {

    /**
     * 하드 삭제 결과 데이터
     */
    @Schema(description = "하드 삭제 처리 결과 정보")
    private Object data;

    /**
     * 응답 처리 시간 (밀리초)
     */
    @Schema(description = "API 응답 처리 시간 (밀리초)", example = "500")
    private Long processingTimeMs;

    /**
     * 응답 상태 메시지
     */
    @Schema(description = "응답 처리 상태 메시지", example = "삭제된 모든 데이터셋이 완전히 제거되었습니다.")
    private String statusMessage;

    /**
     * 삭제된 데이터셋 수
     */
    @Schema(description = "하드 삭제된 데이터셋의 개수", example = "5")
    private Integer deletedCount;

    /**
     * 정적 팩토리 메서드 - 성공 응답 생성
     * 
     * @param data 하드 삭제 결과 데이터
     * @param processingTimeMs 처리 시간
     * @return 성공 응답 객체
     */
    public static DatasetHardDeleteRes success(Object data, Long processingTimeMs) {
        return DatasetHardDeleteRes.builder()
                .data(data)
                .processingTimeMs(processingTimeMs)
                .statusMessage(DATASET_HARD_DELETE_SUCCESS_MESSAGE)
                .build();
    }

    /**
     * 정적 팩토리 메서드 - 성공 응답 생성 (삭제 개수 포함)
     * 
     * @param data 하드 삭제 결과 데이터
     * @param processingTimeMs 처리 시간
     * @param deletedCount 삭제된 데이터셋 수
     * @return 성공 응답 객체
     */
    public static DatasetHardDeleteRes success(Object data, Long processingTimeMs, Integer deletedCount) {
        return DatasetHardDeleteRes.builder()
                .data(data)
                .processingTimeMs(processingTimeMs)
                .statusMessage(DATASET_HARD_DELETE_SUCCESS_MESSAGE)
                .deletedCount(deletedCount)
                .build();
    }

    /**
     * 정적 팩토리 메서드 - 성공 응답 생성 (커스텀 메시지)
     * 
     * @param data 하드 삭제 결과 데이터
     * @param processingTimeMs 처리 시간
     * @param deletedCount 삭제된 데이터셋 수
     * @param statusMessage 상태 메시지
     * @return 성공 응답 객체
     */
    public static DatasetHardDeleteRes success(Object data, Long processingTimeMs, Integer deletedCount, String statusMessage) {
        return DatasetHardDeleteRes.builder()
                .data(data)
                .processingTimeMs(processingTimeMs)
                .statusMessage(statusMessage)
                .deletedCount(deletedCount)
                .build();
    }
}
