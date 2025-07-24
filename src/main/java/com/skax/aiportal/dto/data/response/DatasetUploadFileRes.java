package com.skax.aiportal.dto.data.response;

import static com.skax.aiportal.constant.DatasetConstants.DATASET_UPLOAD_SUCCESS_MESSAGE;

import com.skax.aiportal.dto.data.DatasetInfo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 파일 업로드를 통한 데이터셋 생성 응답 DTO
 * 
 * <p>파일 업로드를 통한 데이터셋 생성 요청에 대한 응답 정보를 담는 DTO입니다.
 * 생성된 데이터셋의 정보와 업로드 관련 정보를 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-24
 * @version 1.0
 */
@Schema(description = "파일 업로드를 통한 데이터셋 생성 응답")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DatasetUploadFileRes {

    /**
     * 생성된 데이터셋 정보
     */
    @Schema(description = "생성된 데이터셋의 정보")
    private DatasetInfo dataset;

    /**
     * 응답 처리 시간 (밀리초)
     */
    @Schema(description = "API 응답 처리 시간 (밀리초)", example = "1250")
    private Long processingTimeMs;

    /**
     * 응답 상태 메시지
     */
    @Schema(description = "응답 처리 상태 메시지", example = "파일 업로드를 통한 데이터셋 생성이 완료되었습니다.")
    private String statusMessage;

    /**
     * 업로드된 파일명
     */
    @Schema(description = "업로드된 파일의 원본 파일명", example = "dataset.csv")
    private String uploadedFileName;

    /**
     * 업로드된 파일 크기 (바이트)
     */
    @Schema(description = "업로드된 파일의 크기 (바이트)", example = "1048576")
    private Long uploadedFileSize;

    /**
     * 정적 팩토리 메서드 - 성공 응답 생성
     * 
     * @param dataset 생성된 데이터셋 정보
     * @param processingTimeMs 처리 시간
     * @param uploadedFileName 업로드된 파일명
     * @param uploadedFileSize 업로드된 파일 크기
     * @return 성공 응답 객체
     */
    public static DatasetUploadFileRes success(DatasetInfo dataset, Long processingTimeMs, 
                                               String uploadedFileName, Long uploadedFileSize) {
        return DatasetUploadFileRes.builder()
                .dataset(dataset)
                .processingTimeMs(processingTimeMs)
                .statusMessage(DATASET_UPLOAD_SUCCESS_MESSAGE)
                .uploadedFileName(uploadedFileName)
                .uploadedFileSize(uploadedFileSize)
                .build();
    }

    /**
     * 정적 팩토리 메서드 - 성공 응답 생성 (커스텀 메시지)
     * 
     * @param dataset 생성된 데이터셋 정보
     * @param processingTimeMs 처리 시간
     * @param uploadedFileName 업로드된 파일명
     * @param uploadedFileSize 업로드된 파일 크기
     * @param statusMessage 상태 메시지
     * @return 성공 응답 객체
     */
    public static DatasetUploadFileRes success(DatasetInfo dataset, Long processingTimeMs, 
                                               String uploadedFileName, Long uploadedFileSize, 
                                               String statusMessage) {
        return DatasetUploadFileRes.builder()
                .dataset(dataset)
                .processingTimeMs(processingTimeMs)
                .statusMessage(statusMessage)
                .uploadedFileName(uploadedFileName)
                .uploadedFileSize(uploadedFileSize)
                .build();
    }
}
