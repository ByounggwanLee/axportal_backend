package com.skax.aiplatform.client.sktax.model;

import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import com.skax.aiplatform.client.sktax.model.dto.request.BodyUploadModelFileRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * SKT AX Model API - File Upload Feign Client
 * 모델 파일 업로드 관련 API를 호출하는 Feign Client입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@FeignClient(
    name = "skt-ax-model-file-client", 
    url = "${skt-ax.model.base-url:https://aip-stg.sktai.io}",
    configuration = SktAxFeignConfig.class
)
public interface ModelFileClient {

    /**
     * 모델 파일 업로드
     */
    @PostMapping(value = "/api/v1/models/files", 
                 consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    void uploadModelFile(@ModelAttribute BodyUploadModelFileRequest request);
}
