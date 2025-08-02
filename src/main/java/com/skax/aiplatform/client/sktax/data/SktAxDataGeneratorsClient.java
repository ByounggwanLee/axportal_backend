package com.skax.aiplatform.client.sktax.data;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import com.skax.aiplatform.client.sktax.data.dto.Generator;
import com.skax.aiplatform.client.sktax.data.dto.request.GeneratorCreate;
import com.skax.aiplatform.client.sktax.data.dto.request.GeneratorUpdate;
import com.skax.aiplatform.client.sktax.data.dto.response.GeneratorDetail;
import com.skax.aiplatform.client.sktax.data.dto.response.GeneratorResponse;

/**
 * SKT AX Data API 생성기 클라이언트
 * 
 * <p>데이터 생성기 관련 API를 호출하기 위한 Feign Client입니다.
 * 생성기의 생성, 조회, 수정, 삭제 기능을 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-01-21
 * @version 1.0
 */
@FeignClient(
    name = "skt-ax-data-generators",
    url = "${sktax.data.base-url:https://aip-stg.sktai.io}",
    configuration = SktAxFeignConfig.class
)
public interface SktAxDataGeneratorsClient {
    
    /**
     * 생성기 목록 조회
     * 
     * @return 생성기 목록
     */
    @GetMapping("/api/v1/generators")
    ResponseEntity<GeneratorResponse> getGenerators();
    
    /**
     * 생성기 생성
     * 
     * @param request 생성기 생성 요청
     * @return 생성된 생성기
     */
    @PostMapping("/api/v1/generators")
    ResponseEntity<GeneratorDetail> createGenerator(@RequestBody GeneratorCreate request);
    
    /**
     * 생성기 상세 조회
     * 
     * @param generatorId 생성기 ID
     * @return 생성기 상세 정보
     */
    @GetMapping("/api/v1/generators/{generator_id}")
    ResponseEntity<Generator> getGeneratorById(@PathVariable("generator_id") String generatorId);
    
    /**
     * 생성기 수정
     * 
     * @param generatorId 생성기 ID
     * @param request 수정 요청
     * @return 수정된 생성기
     */
    @PutMapping("/api/v1/generators/{generator_id}")
    ResponseEntity<Object> updateGenerator(
            @PathVariable("generator_id") String generatorId,
            @RequestBody GeneratorUpdate request
    );
    
    /**
     * 생성기 삭제
     * 
     * @param generatorId 생성기 ID
     * @return 삭제 결과
     */
    @DeleteMapping("/api/v1/generators/{generator_id}")
    ResponseEntity<Void> deleteGenerator(@PathVariable("generator_id") String generatorId);
}
