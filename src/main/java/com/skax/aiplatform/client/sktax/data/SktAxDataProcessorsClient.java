package com.skax.aiplatform.client.sktax.data;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import com.skax.aiplatform.client.sktax.data.dto.DataProcessor;
import com.skax.aiplatform.client.sktax.data.dto.request.DataProcessorCreate;
import com.skax.aiplatform.client.sktax.data.dto.request.DataProcessorExecute;
import com.skax.aiplatform.client.sktax.data.dto.response.DataProcessorList;

/**
 * SKT AX Data API 프로세서 클라이언트
 * 
 * <p>데이터 프로세서 관련 API를 호출하기 위한 Feign Client입니다.
 * 프로세서의 생성, 조회, 수정, 삭제, 실행 기능을 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-01-21
 * @version 1.0
 */
@FeignClient(
    name = "skt-ax-data-processors",
    url = "${sktax.data.base-url:https://aip-stg.sktai.io}",
    configuration = SktAxFeignConfig.class
)
public interface SktAxDataProcessorsClient {
    
    /**
     * 데이터 프로세서 목록 조회
     * 
     * @param dataType 데이터 타입 필터
     * @return 프로세서 목록
     */
    @GetMapping("/api/v1/processors")
    ResponseEntity<DataProcessorList> getProcessors(
            @RequestParam(value = "data_type", required = false) String dataType
    );
    
    /**
     * 데이터 프로세서 생성
     * 
     * @param request 프로세서 생성 요청
     * @return 생성된 프로세서
     */
    @PostMapping("/api/v1/processors")
    ResponseEntity<DataProcessor> createProcessor(@RequestBody DataProcessorCreate request);
    
    /**
     * 데이터 프로세서 상세 조회
     * 
     * @param processorId 프로세서 ID
     * @return 프로세서 상세 정보
     */
    @GetMapping("/api/v1/processors/{processor_id}")
    ResponseEntity<DataProcessor> getProcessorById(@PathVariable("processor_id") String processorId);
    
    /**
     * 데이터 프로세서 수정
     * 
     * @param processorId 프로세서 ID
     * @param request 수정 요청
     * @return 수정된 프로세서
     */
    @PutMapping("/api/v1/processors/{processor_id}")
    ResponseEntity<DataProcessor> updateProcessor(
            @PathVariable("processor_id") String processorId,
            @RequestBody DataProcessorCreate request
    );
    
    /**
     * 데이터 프로세서 삭제
     * 
     * @param processorId 프로세서 ID
     * @return 삭제 결과
     */
    @DeleteMapping("/api/v1/processors/{processor_id}")
    ResponseEntity<Void> deleteProcessor(@PathVariable("processor_id") String processorId);
    
    /**
     * 데이터 프로세서 실행
     * 
     * @param request 실행 요청
     * @return 실행 결과
     */
    @PostMapping("/api/v1/processors/execute")
    ResponseEntity<Object> executeProcessor(@RequestBody DataProcessorExecute request);
}
