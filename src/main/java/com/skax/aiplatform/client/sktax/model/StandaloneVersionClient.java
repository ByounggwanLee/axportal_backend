package com.skax.aiplatform.client.sktax.model;

import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import com.skax.aiplatform.client.sktax.model.dto.response.ModelVersionReadResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * SKT AX Model API - Standalone Version Feign Client
 * 독립적인 버전 조회 관련 API를 호출하는 Feign Client입니다.
 *
 * @author ByounggwanLee
 * @since 2025-01-01
 * @version 1.0
 */
@FeignClient(
    name = "skt-ax-standalone-version-client", 
    url = "${skt-ax.model.base-url:https://aip-stg.sktai.io}",
    configuration = SktAxFeignConfig.class
)
public interface StandaloneVersionClient {

    /**
     * 버전 단독 조회 (모델 ID 없이)
     */
    @GetMapping("/api/v1/models/versions/{version_id}")
    ModelVersionReadResponse readVersion(@PathVariable("version_id") UUID versionId);
}
