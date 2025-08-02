package com.skax.aiplatform.client.sktax.modelgateway;

import com.skax.aiplatform.client.sktax.modelgateway.dto.request.EmbeddingsRequest;
import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Model Gateway Embeddings Client
 * 
 * <p>모델 게이트웨이의 임베딩 관련 API를 호출하는 Feign Client입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Tag(name = "Model Gateway Embeddings API", description = "모델 게이트웨이 임베딩 API")
@FeignClient(
    name = "modelGatewayEmbeddingsClient",
    url = "${feign.client.model-gateway.url:https://aip-stg.sktai.io}",
    configuration = SktAxFeignConfig.class
)
public interface EmbeddingsClient {

    /**
     * 임베딩 생성 API
     * 
     * @param request 임베딩 생성 요청
     * @return 임베딩 생성 응답
     */
    @Operation(summary = "임베딩 생성", description = "텍스트 입력을 기반으로 임베딩 벡터를 생성합니다.")
    @PostMapping(
        value = "/api/v1/gateway/embeddings",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<Object> embeddings(@RequestBody EmbeddingsRequest request);
}
