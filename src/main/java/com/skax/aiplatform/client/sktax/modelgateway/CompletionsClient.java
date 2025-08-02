package com.skax.aiplatform.client.sktax.modelgateway;

import com.skax.aiplatform.client.sktax.modelgateway.dto.request.CompletionsRequest;
import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Model Gateway Completions Client
 * 
 * <p>모델 게이트웨이의 텍스트 완성 관련 API를 호출하는 Feign Client입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Tag(name = "Model Gateway Completions API", description = "모델 게이트웨이 텍스트 완성 API")
@FeignClient(
    name = "modelGatewayCompletionsClient",
    url = "${feign.client.model-gateway.url:https://aip-stg.sktai.io}",
    configuration = SktAxFeignConfig.class
)
public interface CompletionsClient {

    /**
     * 텍스트 완성 API
     * 
     * @param request 텍스트 완성 요청
     * @return 텍스트 완성 응답
     */
    @Operation(summary = "텍스트 완성", description = "프롬프트를 기반으로 텍스트를 완성합니다.")
    @PostMapping(
        value = "/api/v1/gateway/completions",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<Object> completions(@RequestBody CompletionsRequest request);
}
