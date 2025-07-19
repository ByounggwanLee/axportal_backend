package com.skax.aiportal.service.sample.impl;

import com.skax.aiportal.dto.PageResponse;
import com.skax.aiportal.dto.sample.request.SampleCreateRequest;
import com.skax.aiportal.dto.sample.request.SampleUpdateRequest;
import com.skax.aiportal.dto.sample.response.SampleResponse;
import com.skax.aiportal.entity.sample.Sample;
import com.skax.aiportal.exception.BusinessException;
import com.skax.aiportal.exception.ErrorCode;
import com.skax.aiportal.repository.sample.SampleRepository;
import com.skax.aiportal.service.sample.SampleService;
import com.skax.aiportal.util.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 샘플 서비스 구현체
 * 
 * <p>샘플 도메인의 비즈니스 로직을 구현합니다.
 * 샘플의 생성, 조회, 수정, 삭제 등의 기능을 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SampleServiceImpl implements SampleService {

    private final SampleRepository sampleRepository;

    @Override
    @Transactional
    public SampleResponse createSample(SampleCreateRequest request) {
        log.info("새로운 샘플 생성 요청: {}", request.getTitle());
        
        try {
            Sample sample = request.toEntity();
            Sample savedSample = sampleRepository.save(sample);
            
            log.info("샘플 생성 완료: ID={}, 제목={}", savedSample.getId(), savedSample.getTitle());
            return SampleResponse.from(savedSample);
        } catch (Exception e) {
            log.error("샘플 생성 중 오류 발생: {}", e.getMessage(), e);
            throw new BusinessException(ErrorCode.INTERNAL_SERVER_ERROR, "샘플 생성에 실패했습니다.");
        }
    }

    @Override
    public SampleResponse getSampleById(Long id) {
        log.debug("샘플 조회 요청: ID={}", id);
        
        Sample sample = findSampleById(id);
        return SampleResponse.from(sample);
    }

    @Override
    public PageResponse<SampleResponse> getAllSamples(Pageable pageable) {
        log.debug("전체 샘플 목록 조회 요청: page={}, size={}", pageable.getPageNumber(), pageable.getPageSize());
        
        Page<Sample> samplePage = sampleRepository.findAll(pageable);
        Page<SampleResponse> responsePage = samplePage.map(SampleResponse::summaryFrom);
        
        return PageResponse.of(responsePage);
    }

    @Override
    public PageResponse<SampleResponse> getActiveSamples(Pageable pageable) {
        log.debug("활성화된 샘플 목록 조회 요청: page={}, size={}", pageable.getPageNumber(), pageable.getPageSize());
        
        Page<Sample> samplePage = sampleRepository.findByActive(true, pageable);
        Page<SampleResponse> responsePage = samplePage.map(SampleResponse::summaryFrom);
        
        return PageResponse.of(responsePage);
    }

    @Override
    public PageResponse<SampleResponse> searchSamplesByTitle(String title, Pageable pageable) {
        log.debug("제목으로 샘플 검색 요청: title={}", title);
        
        Page<Sample> samplePage = sampleRepository.findByTitleContainingIgnoreCase(title, pageable);
        Page<SampleResponse> responsePage = samplePage.map(SampleResponse::summaryFrom);
        
        return PageResponse.of(responsePage);
    }

    @Override
    public PageResponse<SampleResponse> searchSamplesByKeyword(String keyword, Pageable pageable) {
        log.debug("키워드로 샘플 검색 요청: keyword={}", keyword);
        
        Page<Sample> samplePage = sampleRepository.findByTitleOrContentContaining(keyword, pageable);
        Page<SampleResponse> responsePage = samplePage.map(SampleResponse::summaryFrom);
        
        return PageResponse.of(responsePage);
    }

    @Override
    public PageResponse<SampleResponse> getSamplesByStatus(Sample.SampleStatus status, Pageable pageable) {
        log.debug("상태별 샘플 목록 조회 요청: status={}", status);
        
        Page<Sample> samplePage = sampleRepository.findByStatus(status, pageable);
        Page<SampleResponse> responsePage = samplePage.map(SampleResponse::summaryFrom);
        
        return PageResponse.of(responsePage);
    }

    @Override
    public List<SampleResponse> getPopularSamples(int limit) {
        log.debug("인기 샘플 조회 요청: limit={}", limit);
        
        Pageable pageable = PageRequest.of(0, limit, Sort.by(Sort.Direction.DESC, "viewCount"));
        List<Sample> samples = sampleRepository.findTopByViewCount(pageable);
        
        return samples.stream()
                .map(SampleResponse::summaryFrom)
                .toList();
    }

    @Override
    @Transactional
    public SampleResponse updateSample(Long id, SampleUpdateRequest request) {
        log.info("샘플 수정 요청: ID={}", id);
        
        try {
            Sample sample = findSampleById(id);
            request.applyToEntity(sample);
            
            Sample updatedSample = sampleRepository.save(sample);
            
            log.info("샘플 수정 완료: ID={}, 제목={}", updatedSample.getId(), updatedSample.getTitle());
            return SampleResponse.from(updatedSample);
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            log.error("샘플 수정 중 오류 발생: ID={}, 오류={}", id, e.getMessage(), e);
            throw new BusinessException(ErrorCode.INTERNAL_SERVER_ERROR, "샘플 수정에 실패했습니다.");
        }
    }

    @Override
    @Transactional
    public void deleteSample(Long id) {
        log.info("샘플 삭제 요청: ID={}", id);
        
        try {
            Sample sample = findSampleById(id);
            sampleRepository.delete(sample);
            
            log.info("샘플 삭제 완료: ID={}", id);
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            log.error("샘플 삭제 중 오류 발생: ID={}, 오류={}", id, e.getMessage(), e);
            throw new BusinessException(ErrorCode.INTERNAL_SERVER_ERROR, "샘플 삭제에 실패했습니다.");
        }
    }

    @Override
    @Transactional
    public SampleResponse incrementViewCount(Long id) {
        log.debug("샘플 조회수 증가 요청: ID={}", id);
        
        try {
            Sample sample = findSampleById(id);
            sample.incrementViewCount();
            
            Sample updatedSample = sampleRepository.save(sample);
            
            log.debug("샘플 조회수 증가 완료: ID={}, 조회수={}", id, updatedSample.getViewCount());
            return SampleResponse.from(updatedSample);
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            log.error("샘플 조회수 증가 중 오류 발생: ID={}, 오류={}", id, e.getMessage(), e);
            throw new BusinessException(ErrorCode.INTERNAL_SERVER_ERROR, "조회수 증가에 실패했습니다.");
        }
    }

    @Override
    public long getActiveSampleCount() {
        return sampleRepository.countByActive(true);
    }

    @Override
    public long getSampleCountByStatus(Sample.SampleStatus status) {
        return sampleRepository.countByStatus(status);
    }

    /**
     * ID로 샘플을 조회하고, 존재하지 않으면 예외를 발생시킵니다.
     * 
     * @param id 샘플 ID
     * @return Sample 엔티티
     * @throws BusinessException 샘플을 찾을 수 없는 경우
     */
    private Sample findSampleById(Long id) {
        return sampleRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("샘플을 찾을 수 없습니다: ID={}", id);
                    return new BusinessException(ErrorCode.ENTITY_NOT_FOUND, "ID " + id + "에 해당하는 샘플을 찾을 수 없습니다.");
                });
    }
}
