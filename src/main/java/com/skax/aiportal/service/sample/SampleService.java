package com.skax.aiportal.service.sample;

import com.skax.aiportal.dto.PageResponse;
import com.skax.aiportal.dto.sample.request.SampleCreateRequest;
import com.skax.aiportal.dto.sample.request.SampleUpdateRequest;
import com.skax.aiportal.dto.sample.response.SampleResponse;
import com.skax.aiportal.entity.sample.Sample;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 샘플 서비스 인터페이스
 * 
 * <p>샘플 도메인의 비즈니스 로직을 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
public interface SampleService {

    /**
     * 새로운 샘플을 생성합니다.
     * 
     * @param request 샘플 생성 요청
     * @return 생성된 샘플 응답
     */
    SampleResponse createSample(SampleCreateRequest request);

    /**
     * 샘플 ID로 샘플을 조회합니다.
     * 
     * @param id 샘플 ID
     * @return 샘플 응답
     */
    SampleResponse getSampleById(Long id);

    /**
     * 모든 샘플을 페이징하여 조회합니다.
     * 
     * @param pageable 페이징 정보
     * @return 샘플 페이지 응답
     */
    PageResponse<SampleResponse> getAllSamples(Pageable pageable);

    /**
     * 활성화된 샘플만 페이징하여 조회합니다.
     * 
     * @param pageable 페이징 정보
     * @return 활성화된 샘플 페이지 응답
     */
    PageResponse<SampleResponse> getActiveSamples(Pageable pageable);

    /**
     * 제목으로 샘플을 검색합니다.
     * 
     * @param title 검색할 제목
     * @param pageable 페이징 정보
     * @return 검색된 샘플 페이지 응답
     */
    PageResponse<SampleResponse> searchSamplesByTitle(String title, Pageable pageable);

    /**
     * 키워드로 샘플을 검색합니다.
     * 
     * @param keyword 검색 키워드
     * @param pageable 페이징 정보
     * @return 검색된 샘플 페이지 응답
     */
    PageResponse<SampleResponse> searchSamplesByKeyword(String keyword, Pageable pageable);

    /**
     * 상태별로 샘플을 조회합니다.
     * 
     * @param status 샘플 상태
     * @param pageable 페이징 정보
     * @return 상태별 샘플 페이지 응답
     */
    PageResponse<SampleResponse> getSamplesByStatus(Sample.SampleStatus status, Pageable pageable);

    /**
     * 인기 샘플을 조회합니다.
     * 
     * @param limit 조회할 개수
     * @return 인기 샘플 목록
     */
    List<SampleResponse> getPopularSamples(int limit);

    /**
     * 샘플을 수정합니다.
     * 
     * @param id 샘플 ID
     * @param request 샘플 수정 요청
     * @return 수정된 샘플 응답
     */
    SampleResponse updateSample(Long id, SampleUpdateRequest request);

    /**
     * 샘플을 삭제합니다.
     * 
     * @param id 샘플 ID
     */
    void deleteSample(Long id);

    /**
     * 샘플의 조회수를 증가시킵니다.
     * 
     * @param id 샘플 ID
     * @return 조회수가 증가된 샘플 응답
     */
    SampleResponse incrementViewCount(Long id);

    /**
     * 활성화된 샘플의 총 개수를 조회합니다.
     * 
     * @return 활성화된 샘플 개수
     */
    long getActiveSampleCount();

    /**
     * 상태별 샘플 개수를 조회합니다.
     * 
     * @param status 샘플 상태
     * @return 상태별 샘플 개수
     */
    long getSampleCountByStatus(Sample.SampleStatus status);
}
