package com.skax.aiportal.client.sktai.model;

import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * SKT AI Model API - 모델 파일 업로드 Feign 클라이언트
 * 모델 파일 업로드
 */
@FeignClient(
    name = "skt-ai-model-file",
    url = "${sktai.api.base-url}",
    configuration = SktAiClientConfig.class
)
public interface SktAiModelFileClient {
    
    /**
     * 모델 파일 업로드
     * 모델 등록을 위한 모델 파일 업로드
     */
    @PostMapping(value = "/api/v1/models/files", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Object uploadModelFile(@RequestPart("file") MultipartFile file);
}
