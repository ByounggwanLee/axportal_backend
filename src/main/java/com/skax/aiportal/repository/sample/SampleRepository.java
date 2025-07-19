package com.skax.aiportal.repository.sample;

import com.skax.aiportal.entity.sample.Sample;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 샘플 리포지토리
 * 
 * <p>샘플 엔티티에 대한 데이터 접근을 담당합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {

    /**
     * 활성화된 샘플을 조회합니다.
     * 
     * @param active 활성화 상태
     * @param pageable 페이징 정보
     * @return 활성화된 샘플 페이지
     */
    Page<Sample> findByActive(Boolean active, Pageable pageable);

    /**
     * 제목으로 샘플을 검색합니다.
     * 
     * @param title 제목
     * @param pageable 페이징 정보
     * @return 검색된 샘플 페이지
     */
    Page<Sample> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    /**
     * 상태별로 샘플을 조회합니다.
     * 
     * @param status 샘플 상태
     * @param pageable 페이징 정보
     * @return 상태별 샘플 페이지
     */
    Page<Sample> findByStatus(Sample.SampleStatus status, Pageable pageable);

    /**
     * 활성화 상태와 상태로 샘플을 조회합니다.
     * 
     * @param active 활성화 상태
     * @param status 샘플 상태
     * @param pageable 페이징 정보
     * @return 조건에 맞는 샘플 페이지
     */
    Page<Sample> findByActiveAndStatus(Boolean active, Sample.SampleStatus status, Pageable pageable);

    /**
     * 제목과 내용으로 샘플을 검색합니다.
     * 
     * @param keyword 검색 키워드
     * @param pageable 페이징 정보
     * @return 검색된 샘플 페이지
     */
    @Query("SELECT s FROM Sample s WHERE s.title LIKE %:keyword% OR s.content LIKE %:keyword%")
    Page<Sample> findByTitleOrContentContaining(@Param("keyword") String keyword, Pageable pageable);

    /**
     * 조회수가 높은 샘플을 조회합니다.
     * 
     * @param limit 조회할 개수
     * @return 인기 샘플 목록
     */
    @Query("SELECT s FROM Sample s WHERE s.active = true ORDER BY s.viewCount DESC")
    List<Sample> findTopByViewCount(Pageable pageable);

    /**
     * 활성화된 샘플의 총 개수를 조회합니다.
     * 
     * @return 활성화된 샘플 개수
     */
    long countByActive(Boolean active);

    /**
     * 특정 상태의 샘플 개수를 조회합니다.
     * 
     * @param status 샘플 상태
     * @return 상태별 샘플 개수
     */
    long countByStatus(Sample.SampleStatus status);

    /**
     * 샘플 조회수를 증가시킵니다.
     * 
     * @param id 샘플 ID
     */
    @Modifying
    @Query("UPDATE Sample s SET s.viewCount = s.viewCount + 1 WHERE s.id = :id")
    void incrementViewCount(@Param("id") Long id);

    /**
     * ID와 활성화 상태로 샘플을 조회합니다.
     * 
     * @param id 샘플 ID
     * @param active 활성화 상태
     * @return 샘플 Optional
     */
    Optional<Sample> findByIdAndActive(Long id, Boolean active);
}
