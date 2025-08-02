package com.skax.aiplatform.client.sktax.modelgateway;

import com.skax.aiplatform.client.sktax.modelgateway.dto.request.RerankRequest;
import com.skax.aiplatform.client.sktax.modelgateway.dto.request.ScoreRequest;
import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Model Gateway Rerank Client
 * 
 * <p>모델 게이트웨이의 재순위화 및 점수 계산 관련 API를 호출하는 Feign Client입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Tag(name = "Model Gateway Rerank API", description = "모델 게이트웨이 재순위화 및 점수 계산 API")
@FeignClient(
    name = "modelGatewayRerankClient",
    url = "${feign.client.model-gateway.url:https://aip-stg.sktai.io}",
    configuration = SktAxFeignConfig.class
)
public interface RerankClient {

    /**
     * 점수 계산 API
     * 
     * @param request 점수 계산 요청
     * @return 점수 계산 응답
     */
    @Operation(summary = "점수 계산", description = "두 텍스트 간의 유사도 점수를 계산합니다.")
    @PostMapping(
        value = "/api/v1/gateway/score",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<Object> score(@RequestBody ScoreRequest request);

    /**
     * 재순위화 API
     * 
     * @param apiVersion API 버전
     * @param request 재순위화 요청
     * @return 재순위화 응답
     */
    @Operation(summary = "재순위화", description = "쿼리와 문서들의 관련성을 기반으로 재순위화합니다.")
    @PostMapping(
        value = "/api/v1/gateway/{api_version}/rerank",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<Object> rerank(
        @Parameter(description = "API 버전", example = "v1") @PathVariable("api_version") String apiVersion,
        @RequestBody RerankRequest request
    );
}
