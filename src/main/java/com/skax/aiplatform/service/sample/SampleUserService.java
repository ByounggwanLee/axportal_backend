package com.skax.aiplatform.service.sample;

import com.skax.aiplatform.dto.sample.request.SampleUserCreateReq;
import com.skax.aiplatform.dto.sample.request.SampleUserUpdateReq;
import com.skax.aiplatform.dto.sample.response.SampleUserRes;
import com.skax.aiplatform.entity.sample.SampleUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * 샘플 사용자 서비스 인터페이스
 * 
 * <p>샘플 사용자와 관련된 비즈니스 로직을 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
public interface SampleUserService {

    /**
     * 새로운 사용자 생성
     * 
     * @param request 사용자 생성 요청
     * @return 생성된 사용자 정보
     */
    SampleUserRes createUser(SampleUserCreateReq request);

    /**
     * 사용자 정보 조회
     * 
     * @param id 사용자 ID
     * @return 사용자 정보
     */
    SampleUserRes getUserById(Long id);

    /**
     * 사용자명으로 사용자 조회
     * 
     * @param username 사용자명
     * @return 사용자 정보
     */
    SampleUserRes getUserByUsername(String username);

    /**
     * 모든 사용자 목록 조회 (페이징)
     * 
     * @param pageable 페이징 정보
     * @return 사용자 목록
     */
    Page<SampleUserRes> getAllUsers(Pageable pageable);

    /**
     * 상태별 사용자 목록 조회
     * 
     * @param status 사용자 상태
     * @param pageable 페이징 정보
     * @return 사용자 목록
     */
    Page<SampleUserRes> getUsersByStatus(SampleUser.UserStatus status, Pageable pageable);

    /**
     * 키워드로 사용자 검색
     * 
     * @param keyword 검색 키워드
     * @param pageable 페이징 정보
     * @return 검색된 사용자 목록
     */
    Page<SampleUserRes> searchUsers(String keyword, Pageable pageable);

    /**
     * 사용자 정보 수정
     * 
     * @param id 사용자 ID
     * @param request 수정 요청
     * @return 수정된 사용자 정보
     */
    SampleUserRes updateUser(Long id, SampleUserUpdateReq request);

    /**
     * 사용자 상태 변경
     * 
     * @param id 사용자 ID
     * @param status 새로운 상태
     * @return 수정된 사용자 정보
     */
    SampleUserRes changeUserStatus(Long id, SampleUser.UserStatus status);

    /**
     * 사용자 삭제
     * 
     * @param id 사용자 ID
     */
    void deleteUser(Long id);

    /**
     * 사용자명 중복 확인
     * 
     * @param username 사용자명
     * @return 중복 여부
     */
    boolean isUsernameExists(String username);

    /**
     * 이메일 중복 확인
     * 
     * @param email 이메일
     * @return 중복 여부
     */
    boolean isEmailExists(String email);

    /**
     * 나이 범위로 사용자 조회
     * 
     * @param minAge 최소 나이
     * @param maxAge 최대 나이
     * @return 사용자 목록
     */
    List<SampleUserRes> getUsersByAgeRange(Integer minAge, Integer maxAge);

    /**
     * 활성 사용자 목록 조회
     * 
     * @param pageable 페이징 정보
     * @return 활성 사용자 목록
     */
    Page<SampleUserRes> getActiveUsers(Pageable pageable);

    /**
     * 사용자 통계 조회
     * 
     * @return 상태별 사용자 수
     */
    Map<String, Long> getUserStatistics();

    /**
     * 최근 가입한 사용자 조회
     * 
     * @param limit 조회할 개수
     * @return 최근 가입 사용자 목록
     */
    List<SampleUserRes> getRecentUsers(int limit);
}
