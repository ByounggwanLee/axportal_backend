package com.skax.aiplatform.client.sktax.modelgateway;

import com.skax.aiplatform.client.sktax.modelgateway.dto.request.ChatCompletionsRequest;
import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Model Gateway Chat Client
 * 
 * <p>모델 게이트웨이의 채팅 관련 API를 호출하는 Feign Client입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Tag(name = "Model Gateway Chat API", description = "모델 게이트웨이 채팅 API")
@FeignClient(
    name = "modelGatewayChatClient",
    url = "${feign.client.model-gateway.url:https://aip-stg.sktai.io}",
    configuration = SktAxFeignConfig.class
)
public interface ChatClient {

    /**
     * 채팅 완성 API
     * 
     * @param request 채팅 완성 요청
     * @return 채팅 완성 응답
     */
    @Operation(summary = "채팅 완성", description = "채팅 메시지를 기반으로 AI 응답을 생성합니다.")
    @PostMapping(
        value = "/api/v1/gateway/chat/completions",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<Object> chatCompletions(@RequestBody ChatCompletionsRequest request);
}
