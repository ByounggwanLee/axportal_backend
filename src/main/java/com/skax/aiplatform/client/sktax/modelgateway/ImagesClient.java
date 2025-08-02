package com.skax.aiplatform.client.sktax.modelgateway;

import com.skax.aiplatform.client.sktax.modelgateway.dto.request.ImagesRequest;
import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Model Gateway Images Client
 * 
 * <p>모델 게이트웨이의 이미지 생성 관련 API를 호출하는 Feign Client입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Tag(name = "Model Gateway Images API", description = "모델 게이트웨이 이미지 생성 API")
@FeignClient(
    name = "modelGatewayImagesClient",
    url = "${feign.client.model-gateway.url:https://aip-stg.sktai.io}",
    configuration = SktAxFeignConfig.class
)
public interface ImagesClient {

    /**
     * 이미지 생성 API
     * 
     * @param request 이미지 생성 요청
     * @return 이미지 생성 응답
     */
    @Operation(summary = "이미지 생성", description = "프롬프트를 기반으로 이미지를 생성합니다.")
    @PostMapping(
        value = "/api/v1/gateway/images/generations",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<Object> imageGeneration(@RequestBody ImagesRequest request);
}
