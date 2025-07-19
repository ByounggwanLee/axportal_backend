package com.skax.aiportal.controller.sample;

import com.skax.aiportal.dto.ApiResponse;
import com.skax.aiportal.dto.PageResponse;
import com.skax.aiportal.dto.sample.request.SampleCreateRequest;
import com.skax.aiportal.dto.sample.request.SampleUpdateRequest;
import com.skax.aiportal.dto.sample.response.SampleResponse;
import com.skax.aiportal.entity.sample.Sample;
import com.skax.aiportal.service.sample.SampleService;
import com.skax.aiportal.util.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 샘플 컨트롤러
 * 
 * <p>샘플 도메인의 REST API를 제공합니다.
 * 샘플의 CRUD 및 검색 기능을 담당합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping(Constants.Api.BASE_PATH + "/samples")
@RequiredArgsConstructor
@Tag(name = "Sample", description = "샘플 관리 API")
public class SampleController {

    private final SampleService sampleService;

    /**
     * 새로운 샘플을 생성합니다.
     * 
     * @param request 샘플 생성 요청
     * @return 생성된 샘플 응답
     */
    @PostMapping
    @Operation(summary = "샘플 생성", description = "새로운 샘플을 생성합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "샘플 생성 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청 데이터"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    public ResponseEntity<ApiResponse<SampleResponse>> createSample(
            @Valid @RequestBody SampleCreateRequest request) {
        log.info("샘플 생성 API 호출 시작 - 제목: {}", request.getTitle());
        log.debug("샘플 생성 요청 데이터 상세:");
        log.debug("  - 제목: {}", request.getTitle());
        log.debug("  - 내용: {}", request.getContent());
        log.debug("  - 활성화 상태: {}", request.getActive());
        log.debug("  - 상태: {}", request.getStatus());
        
        try {
            SampleResponse response = sampleService.createSample(request);
            log.info("샘플 생성 성공 - ID: {}, 제목: {}", response.getId(), response.getTitle());
            log.debug("생성된 샘플 응답 데이터: {}", response);
            
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(ApiResponse.success(response, Constants.Message.CREATED));
        } catch (Exception e) {
            log.error("샘플 생성 중 오류 발생 - 제목: {}, 오류: {}", request.getTitle(), e.getMessage(), e);
            throw e;
        }
    }

    /**
     * 샘플 ID로 샘플을 조회합니다.
     * 
     * @param id 샘플 ID
     * @param incrementView 조회수 증가 여부
     * @return 샘플 응답
     */
    @GetMapping("/{id}")
    @Operation(summary = "샘플 상세 조회", description = "샘플 ID로 상세 정보를 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "샘플 조회 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "샘플을 찾을 수 없음")
    })
    public ResponseEntity<ApiResponse<SampleResponse>> getSample(
            @Parameter(description = "샘플 ID", required = true) @PathVariable Long id,
            @Parameter(description = "조회수 증가 여부") @RequestParam(defaultValue = "true") boolean incrementView) {
        log.info("샘플 조회 API 호출 시작 - ID: {}, 조회수 증가: {}", id, incrementView);
        
        try {
            SampleResponse response = incrementView 
                    ? sampleService.incrementViewCount(id)
                    : sampleService.getSampleById(id);
            
            log.info("샘플 조회 성공 - ID: {}, 제목: {}, 조회수: {}", 
                    response.getId(), response.getTitle(), response.getViewCount());
            log.debug("조회된 샘플 응답 데이터: {}", response);
            
            return ResponseEntity.ok(ApiResponse.success(response, Constants.Message.SUCCESS));
        } catch (Exception e) {
            log.error("샘플 조회 중 오류 발생 - ID: {}, 오류: {}", id, e.getMessage(), e);
            throw e;
        }
    }

    /**
     * 모든 샘플을 페이징하여 조회합니다.
     * 
     * @param page 페이지 번호
     * @param size 페이지 크기
     * @param sort 정렬 기준
     * @param direction 정렬 방향
     * @param activeOnly 활성화된 샘플만 조회 여부
     * @return 샘플 페이지 응답
     */
    @GetMapping
    @Operation(summary = "샘플 목록 조회", description = "샘플 목록을 페이징하여 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "샘플 목록 조회 성공")
    })
    public ResponseEntity<ApiResponse<PageResponse<SampleResponse>>> getSamples(
            @Parameter(description = "페이지 번호") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "페이지 크기") @RequestParam(defaultValue = "20") int size,
            @Parameter(description = "정렬 기준") @RequestParam(defaultValue = "createdAt") String sort,
            @Parameter(description = "정렬 방향") @RequestParam(defaultValue = "desc") String direction,
            @Parameter(description = "활성화된 샘플만 조회") @RequestParam(defaultValue = "false") boolean activeOnly) {
        
        log.info("샘플 목록 조회 API 호출 시작 - 페이지: {}, 크기: {}, 활성화만: {}", page, size, activeOnly);
        log.debug("요청 파라미터 상세:");
        log.debug("  - 페이지: {}", page);
        log.debug("  - 크기: {} (최대: {})", size, Constants.Pagination.MAX_SIZE);
        log.debug("  - 정렬 기준: {}", sort);
        log.debug("  - 정렬 방향: {}", direction);
        log.debug("  - 활성화된 샘플만: {}", activeOnly);
        
        // 페이지 크기 제한
        size = Math.min(size, Constants.Pagination.MAX_SIZE);
        if (size != Integer.parseInt("20") && size == Constants.Pagination.MAX_SIZE) {
            log.debug("페이지 크기가 최대값으로 제한됨: {}", size);
        }
        
        Sort.Direction sortDirection = "asc".equalsIgnoreCase(direction) 
                ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sort));
        log.debug("생성된 Pageable: {}", pageable);
        
        try {
            PageResponse<SampleResponse> response = activeOnly 
                    ? sampleService.getActiveSamples(pageable)
                    : sampleService.getAllSamples(pageable);
            
            log.info("샘플 목록 조회 성공 - 총 요소: {}, 현재 페이지 요소: {}, 총 페이지: {}", 
                    response.getTotalElements(), response.getContent().size(), response.getTotalPages());
            log.debug("조회된 샘플 목록 응답 데이터: {}", response);
            
            return ResponseEntity.ok(ApiResponse.success(response, "샘플 목록 조회 완료"));
        } catch (Exception e) {
            log.error("샘플 목록 조회 중 오류 발생 - 페이지: {}, 크기: {}, 오류: {}", page, size, e.getMessage(), e);
            throw e;
        }
    }

    /**
     * 제목으로 샘플을 검색합니다.
     * 
     * @param title 검색할 제목
     * @param page 페이지 번호
     * @param size 페이지 크기
     * @return 검색된 샘플 페이지 응답
     */
    @GetMapping("/search/title")
    @Operation(summary = "제목으로 샘플 검색", description = "제목으로 샘플을 검색합니다.")
    public ResponseEntity<ApiResponse<PageResponse<SampleResponse>>> searchByTitle(
            @Parameter(description = "검색할 제목", required = true) @RequestParam String title,
            @Parameter(description = "페이지 번호") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "페이지 크기") @RequestParam(defaultValue = "20") int size) {
        
        log.debug("제목으로 샘플 검색 API 호출: title={}", title);
        
        size = Math.min(size, Constants.Pagination.MAX_SIZE);
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdAt"));
        
        PageResponse<SampleResponse> response = sampleService.searchSamplesByTitle(title, pageable);
        return ResponseEntity.ok(ApiResponse.success(response, "제목 검색 완료"));
    }

    /**
     * 키워드로 샘플을 검색합니다.
     * 
     * @param keyword 검색 키워드
     * @param page 페이지 번호
     * @param size 페이지 크기
     * @return 검색된 샘플 페이지 응답
     */
    @GetMapping("/search")
    @Operation(summary = "키워드로 샘플 검색", description = "제목과 내용에서 키워드로 샘플을 검색합니다.")
    public ResponseEntity<ApiResponse<PageResponse<SampleResponse>>> searchByKeyword(
            @Parameter(description = "검색 키워드", required = true) @RequestParam String keyword,
            @Parameter(description = "페이지 번호") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "페이지 크기") @RequestParam(defaultValue = "20") int size) {
        
        log.debug("키워드로 샘플 검색 API 호출: keyword={}", keyword);
        
        size = Math.min(size, Constants.Pagination.MAX_SIZE);
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdAt"));
        
        PageResponse<SampleResponse> response = sampleService.searchSamplesByKeyword(keyword, pageable);
        return ResponseEntity.ok(ApiResponse.success(response, "키워드 검색 완료"));
    }

    /**
     * 상태별로 샘플을 조회합니다.
     * 
     * @param status 샘플 상태
     * @param page 페이지 번호
     * @param size 페이지 크기
     * @return 상태별 샘플 페이지 응답
     */
    @GetMapping("/status/{status}")
    @Operation(summary = "상태별 샘플 조회", description = "특정 상태의 샘플을 조회합니다.")
    public ResponseEntity<ApiResponse<PageResponse<SampleResponse>>> getSamplesByStatus(
            @Parameter(description = "샘플 상태", required = true) @PathVariable Sample.SampleStatus status,
            @Parameter(description = "페이지 번호") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "페이지 크기") @RequestParam(defaultValue = "20") int size) {
        
        log.debug("상태별 샘플 조회 API 호출: status={}", status);
        
        size = Math.min(size, Constants.Pagination.MAX_SIZE);
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdAt"));
        
        PageResponse<SampleResponse> response = sampleService.getSamplesByStatus(status, pageable);
        return ResponseEntity.ok(ApiResponse.success(response, "상태별 샘플 조회 완료"));
    }

    /**
     * 인기 샘플을 조회합니다.
     * 
     * @param limit 조회할 개수
     * @return 인기 샘플 목록
     */
    @GetMapping("/popular")
    @Operation(summary = "인기 샘플 조회", description = "조회수가 높은 인기 샘플을 조회합니다.")
    public ResponseEntity<ApiResponse<List<SampleResponse>>> getPopularSamples(
            @Parameter(description = "조회할 개수") @RequestParam(defaultValue = "10") int limit) {
        
        log.debug("인기 샘플 조회 API 호출: limit={}", limit);
        
        // 최대 50개로 제한
        limit = Math.min(limit, 50);
        
        List<SampleResponse> response = sampleService.getPopularSamples(limit);
        return ResponseEntity.ok(ApiResponse.success(response, "인기 샘플 조회 완료"));
    }

    /**
     * 샘플을 수정합니다.
     * 
     * @param id 샘플 ID
     * @param request 샘플 수정 요청
     * @return 수정된 샘플 응답
     */
    @PutMapping("/{id}")
    @Operation(summary = "샘플 수정", description = "기존 샘플을 수정합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "샘플 수정 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청 데이터"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "샘플을 찾을 수 없음")
    })
    public ResponseEntity<ApiResponse<SampleResponse>> updateSample(
            @Parameter(description = "샘플 ID", required = true) @PathVariable Long id,
            @Valid @RequestBody SampleUpdateRequest request) {
        
        log.info("샘플 수정 API 호출: ID={}", id);
        
        SampleResponse response = sampleService.updateSample(id, request);
        return ResponseEntity.ok(ApiResponse.success(response, Constants.Message.UPDATED));
    }

    /**
     * 샘플을 삭제합니다.
     * 
     * @param id 샘플 ID
     * @return 삭제 완료 응답
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "샘플 삭제", description = "샘플을 삭제합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "샘플 삭제 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "샘플을 찾을 수 없음")
    })
    public ResponseEntity<ApiResponse<Void>> deleteSample(
            @Parameter(description = "샘플 ID", required = true) @PathVariable Long id) {
        
        log.info("샘플 삭제 API 호출: ID={}", id);
        
        sampleService.deleteSample(id);
        return ResponseEntity.ok(ApiResponse.success(Constants.Message.DELETED));
    }

    /**
     * 샘플 통계를 조회합니다.
     * 
     * @return 샘플 통계 응답
     */
    @GetMapping("/stats")
    @Operation(summary = "샘플 통계 조회", description = "샘플의 각종 통계를 조회합니다.")
    public ResponseEntity<ApiResponse<Object>> getSampleStats() {
        log.debug("샘플 통계 조회 API 호출");
        
        var stats = new Object() {
            public final long activeCount = sampleService.getActiveSampleCount();
            public final long draftCount = sampleService.getSampleCountByStatus(Sample.SampleStatus.DRAFT);
            public final long publishedCount = sampleService.getSampleCountByStatus(Sample.SampleStatus.PUBLISHED);
            public final long archivedCount = sampleService.getSampleCountByStatus(Sample.SampleStatus.ARCHIVED);
            public final long totalCount = activeCount;
        };
        
        return ResponseEntity.ok(ApiResponse.success(stats, "샘플 통계 조회 완료"));
    }
}
