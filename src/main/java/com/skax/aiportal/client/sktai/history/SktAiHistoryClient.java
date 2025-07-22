package com.skax.aiportal.client.sktai.history;

import com.skax.aiportal.client.sktai.history.dto.request.HistorySearchRequest;
import com.skax.aiportal.client.sktai.history.dto.response.HistoryResponse;
import com.skax.aiportal.client.sktai.history.dto.response.HistoryListResponse;
import com.skax.aiportal.client.sktai.config.SktAiClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SKT AI History API - 히스토리 관리 Feign 클라이언트
 * 시스템 전반의 활동 히스토리 조회 및 감사 로그 관리 기능
 */
@FeignClient(
    name = "skt-ai-history",
    url = "${sktai.api.base-url}",
    configuration = SktAiClientConfig.class
)
public interface SktAiHistoryClient {

    /**
     * 히스토리 검색
     */
    @PostMapping("/api/v1/history/search")
    HistoryListResponse searchHistory(@RequestBody HistorySearchRequest request);

    /**
     * 히스토리 목록 조회
     */
    @GetMapping("/api/v1/history")
    HistoryListResponse getHistory(
        @RequestParam(required = false) String entityType,
        @RequestParam(required = false) String entityId,
        @RequestParam(required = false) String actionType,
        @RequestParam(required = false) String userId,
        @RequestParam(required = false) String startDate,
        @RequestParam(required = false) String endDate,
        @RequestParam(required = false) Integer page,
        @RequestParam(required = false) Integer size,
        @RequestParam(required = false) String sort
    );

    /**
     * 히스토리 상세 조회
     */
    @GetMapping("/api/v1/history/{historyId}")
    HistoryResponse getHistoryDetail(@PathVariable("historyId") String historyId);

    /**
     * 특정 엔티티의 히스토리 조회
     */
    @GetMapping("/api/v1/history/entity/{entityType}/{entityId}")
    HistoryListResponse getEntityHistory(
        @PathVariable("entityType") String entityType,
        @PathVariable("entityId") String entityId,
        @RequestParam(required = false) String actionType,
        @RequestParam(required = false) String startDate,
        @RequestParam(required = false) String endDate,
        @RequestParam(required = false) Integer page,
        @RequestParam(required = false) Integer size
    );

    /**
     * 사용자별 히스토리 조회
     */
    @GetMapping("/api/v1/history/user/{userId}")
    HistoryListResponse getUserHistory(
        @PathVariable("userId") String userId,
        @RequestParam(required = false) String entityType,
        @RequestParam(required = false) String actionType,
        @RequestParam(required = false) String startDate,
        @RequestParam(required = false) String endDate,
        @RequestParam(required = false) Integer page,
        @RequestParam(required = false) Integer size
    );

    /**
     * 히스토리 통계 조회
     */
    @GetMapping("/api/v1/history/stats")
    Object getHistoryStats(
        @RequestParam(required = false) String entityType,
        @RequestParam(required = false) String actionType,
        @RequestParam(required = false) String startDate,
        @RequestParam(required = false) String endDate,
        @RequestParam(required = false) String granularity
    );

    /**
     * 액션 타입별 히스토리 조회
     */
    @GetMapping("/api/v1/history/actions/{actionType}")
    HistoryListResponse getActionTypeHistory(
        @PathVariable("actionType") String actionType,
        @RequestParam(required = false) String entityType,
        @RequestParam(required = false) String userId,
        @RequestParam(required = false) String startDate,
        @RequestParam(required = false) String endDate,
        @RequestParam(required = false) Integer page,
        @RequestParam(required = false) Integer size
    );

    /**
     * 히스토리 export
     */
    @PostMapping("/api/v1/history/export")
    Object exportHistory(@RequestBody HistorySearchRequest request);

    /**
     * 감사 로그 조회
     */
    @GetMapping("/api/v1/history/audit")
    HistoryListResponse getAuditLog(
        @RequestParam(required = false) String userId,
        @RequestParam(required = false) String startDate,
        @RequestParam(required = false) String endDate,
        @RequestParam(required = false) String severity,
        @RequestParam(required = false) Integer page,
        @RequestParam(required = false) Integer size
    );

    /**
     * 시스템 활동 요약 조회
     */
    @GetMapping("/api/v1/history/activity-summary")
    Object getActivitySummary(
        @RequestParam(required = false) String startDate,
        @RequestParam(required = false) String endDate,
        @RequestParam(required = false) String granularity
    );
}
