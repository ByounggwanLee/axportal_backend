package com.skax.aiplatform.client.sktax.data.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.springframework.web.multipart.MultipartFile;
import java.util.List;

/**
 * 데이터소스 파일들 업로드 요청 DTO
 * 
 * <p>데이터소스에 여러 파일을 업로드하기 위한 요청 데이터 모델입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BodyUploadFilesApiV1DatasourcesUploadFilesPost {

    /**
     * 업로드할 파일 목록 (필수)
     */
    @JsonProperty("files")
    private List<MultipartFile> files;
}
