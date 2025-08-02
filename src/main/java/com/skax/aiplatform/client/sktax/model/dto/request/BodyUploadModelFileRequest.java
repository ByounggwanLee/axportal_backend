package com.skax.aiplatform.client.sktax.model.dto.request;

import org.springframework.web.multipart.MultipartFile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 모델 파일 업로드 요청 DTO
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BodyUploadModelFileRequest {

    /**
     * 업로드할 파일
     */
    private MultipartFile file;
}
