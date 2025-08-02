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
import com.skax.aiplatform.client.sktax.data.dto.Generation;
import com.skax.aiplatform.client.sktax.data.dto.request.GenerationCreate;

/**
 * SKT AX Data API 생성 작업 클라이언트
 * 
 * <p>데이터 생성 작업 관련 API를 호출하기 위한 Feign Client입니다.
 * 생성 작업의 생성, 조회, 수정, 삭제 기능을 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-01-21
 * @version 1.0
 */
@FeignClient(
    name = "skt-ax-data-generations",
    url = "${sktax.data.base-url:https://aip-stg.sktai.io}",
    configuration = SktAxFeignConfig.class
)
public interface SktAxDataGenerationsClient {
    
    /**
     * 생성 작업 목록 조회
     * 
     * @return 생성 작업 목록
     */
    @GetMapping("/api/v1/generations")
    ResponseEntity<Object> getGenerations();
    
    /**
     * 생성 작업 생성
     * 
     * @param request 생성 작업 생성 요청
     * @return 생성된 생성 작업
     */
    @PostMapping("/api/v1/generations")
    ResponseEntity<Object> createGeneration(@RequestBody GenerationCreate request);
    
    /**
     * 생성 작업 상세 조회
     * 
     * @param generationId 생성 작업 ID
     * @return 생성 작업 상세 정보
     */
    @GetMapping("/api/v1/generations/{generation_id}")
    ResponseEntity<Generation> getGenerationById(@PathVariable("generation_id") String generationId);
    
    /**
     * 생성 작업 수정
     * 
     * @param generationId 생성 작업 ID
     * @param request 수정 요청
     * @return 수정된 생성 작업
     */
    @PutMapping("/api/v1/generations/{generation_id}")
    ResponseEntity<Object> updateGeneration(
            @PathVariable("generation_id") String generationId,
            @RequestBody Object request
    );
    
    /**
     * 생성 작업 삭제
     * 
     * @param generationId 생성 작업 ID
     * @return 삭제 결과
     */
    @DeleteMapping("/api/v1/generations/{generation_id}")
    ResponseEntity<Void> deleteGeneration(@PathVariable("generation_id") String generationId);
}
