package com.skax.aiplatform.repository.sample;

import com.skax.aiplatform.entity.sample.SampleUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 샘플 사용자 리포지토리
 * 
 * <p>샘플 사용자 엔티티에 대한 데이터 액세스 계층입니다.
 * 기본적인 CRUD와 커스텀 쿼리 메서드들을 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
@Repository
public interface SampleUserRepository extends JpaRepository<SampleUser, Long> {

    /**
     * 사용자명으로 사용자 조회
     * 
     * @param username 사용자명
     * @return 사용자 엔티티
     */
    Optional<SampleUser> findByUsername(String username);

    /**
     * 이메일로 사용자 조회
     * 
     * @param email 이메일
     * @return 사용자 엔티티
     */
    Optional<SampleUser> findByEmail(String email);

    /**
     * 사용자명 존재 여부 확인
     * 
     * @param username 사용자명
     * @return 존재 여부
     */
    boolean existsByUsername(String username);

    /**
     * 이메일 존재 여부 확인
     * 
     * @param email 이메일
     * @return 존재 여부
     */
    boolean existsByEmail(String email);

    /**
     * 상태별 사용자 조회
     * 
     * @param status 사용자 상태
     * @param pageable 페이징 정보
     * @return 사용자 목록
     */
    Page<SampleUser> findByStatus(SampleUser.UserStatus status, Pageable pageable);

    /**
     * 사용자명 또는 이메일로 검색
     * 
     * @param keyword 검색 키워드
     * @param pageable 페이징 정보
     * @return 사용자 목록
     */
    @Query("SELECT u FROM SampleUser u WHERE u.username LIKE %:keyword% OR u.email LIKE %:keyword% OR u.fullName LIKE %:keyword%")
    Page<SampleUser> searchByKeyword(@Param("keyword") String keyword, Pageable pageable);

    /**
     * 나이 범위로 사용자 조회
     * 
     * @param minAge 최소 나이
     * @param maxAge 최대 나이
     * @return 사용자 목록
     */
    @Query("SELECT u FROM SampleUser u WHERE u.age >= :minAge AND u.age <= :maxAge AND u.status = 'ACTIVE'")
    List<SampleUser> findByAgeRange(@Param("minAge") Integer minAge, @Param("maxAge") Integer maxAge);

    /**
     * 활성 사용자 목록 조회
     * 
     * @param pageable 페이징 정보
     * @return 활성 사용자 목록
     */
    @Query("SELECT u FROM SampleUser u WHERE u.status = 'ACTIVE' ORDER BY u.createdAt DESC")
    Page<SampleUser> findActiveUsers(Pageable pageable);

    /**
     * 사용자 통계 조회
     * 
     * @return 상태별 사용자 수
     */
    @Query("SELECT u.status, COUNT(u) FROM SampleUser u GROUP BY u.status")
    List<Object[]> getUserStatistics();

    /**
     * 사용자명과 이메일로 사용자 조회 (로그인용)
     * 
     * @param usernameOrEmail 사용자명 또는 이메일
     * @return 사용자 엔티티
     */
    @Query("SELECT u FROM SampleUser u WHERE u.username = :usernameOrEmail OR u.email = :usernameOrEmail")
    Optional<SampleUser> findByUsernameOrEmail(@Param("usernameOrEmail") String usernameOrEmail);

    /**
     * 최근 가입한 사용자 조회
     * 
     * @param limit 조회할 개수
     * @return 최근 가입 사용자 목록
     */
    @Query(value = "SELECT * FROM sample_users ORDER BY created_at DESC LIMIT :limit", nativeQuery = true)
    List<SampleUser> findRecentUsers(@Param("limit") int limit);
}
