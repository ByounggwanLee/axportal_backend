package com.skax.aiplatform.service.sample.impl;

import com.skax.aiplatform.dto.sample.request.SampleUserCreateReq;
import com.skax.aiplatform.dto.sample.request.SampleUserUpdateReq;
import com.skax.aiplatform.dto.sample.response.SampleUserRes;
import com.skax.aiplatform.entity.sample.SampleUser;
import com.skax.aiplatform.mapper.sample.SampleUserMapper;
import com.skax.aiplatform.repository.sample.SampleUserRepository;
import com.skax.aiplatform.service.sample.SampleUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 샘플 사용자 서비스 구현체
 * 
 * <p>샘플 사용자와 관련된 비즈니스 로직을 구현합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SampleUserServiceImpl implements SampleUserService {

    private final SampleUserRepository sampleUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final SampleUserMapper sampleUserMapper;

    /**
     * 새로운 사용자 생성
     * 
     * <p>사용자명과 이메일 중복 검증을 수행한 후, 패스워드를 암호화하여 새로운 사용자를 생성합니다.
     * MapStruct를 통해 DTO에서 엔티티로 변환하고, JPA Auditing으로 생성일시와 생성자가 자동 설정됩니다.</p>
     * 
     * @param request 사용자 생성 요청 DTO (사용자명, 이메일, 패스워드 등 포함)
     * @return 생성된 사용자 정보 (statusDescription 포함)
     * @throws IllegalArgumentException 사용자명 또는 이메일이 이미 존재하는 경우
     * @since 2025-08-01
     */
    @Override
    @Transactional
    public SampleUserRes createUser(SampleUserCreateReq request) {
        log.info("사용자 생성 요청: username={}, email={}", request.getUsername(), request.getEmail());

        // 중복 검사
        if (sampleUserRepository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException("이미 존재하는 사용자명입니다: " + request.getUsername());
        }

        if (sampleUserRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다: " + request.getEmail());
        }

        // 패스워드 암호화
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        // MapStruct를 통한 엔티티 생성 및 저장
        SampleUser user = sampleUserMapper.toEntity(request, encodedPassword);
        SampleUser savedUser = sampleUserRepository.save(user);

        log.info("사용자 생성 완료: id={}, username={}", savedUser.getId(), savedUser.getUsername());
        
        return sampleUserMapper.toDetailResponse(savedUser);
    }

    /**
     * 사용자 ID로 단일 사용자 조회
     * 
     * <p>주어진 ID에 해당하는 사용자를 조회합니다. 
     * MapStruct를 통해 엔티티에서 DTO로 변환하며, statusDescription이 자동으로 설정됩니다.</p>
     * 
     * @param id 조회할 사용자 ID
     * @return 사용자 정보 DTO (statusDescription 포함)
     * @throws IllegalArgumentException 해당 ID의 사용자가 존재하지 않는 경우
     * @since 2025-08-01
     */
    @Override
    public SampleUserRes getUserById(Long id) {
        log.debug("사용자 조회 요청: id={}", id);
        
        SampleUser user = findUserById(id);
        return sampleUserMapper.toDetailResponse(user);
    }

    /**
     * 사용자명으로 단일 사용자 조회
     * 
     * <p>주어진 사용자명에 해당하는 사용자를 조회합니다.
     * 사용자명은 유니크 제약이 있어 단일 결과를 반환합니다.</p>
     * 
     * @param username 조회할 사용자명
     * @return 사용자 정보 DTO (statusDescription 포함)
     * @throws IllegalArgumentException 해당 사용자명의 사용자가 존재하지 않는 경우
     * @since 2025-08-01
     */
    @Override
    public SampleUserRes getUserByUsername(String username) {
        log.debug("사용자 조회 요청: username={}", username);
        
        SampleUser user = sampleUserRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다: " + username));
        
        return sampleUserMapper.toDetailResponse(user);
    }

    /**
     * 전체 사용자 목록 조회 (페이징)
     * 
     * <p>모든 사용자를 페이징 처리하여 조회합니다.
     * Spring Data JPA의 Pageable을 통해 효율적인 페이징을 지원합니다.</p>
     * 
     * @param pageable 페이징 정보 (페이지 번호, 크기, 정렬 조건)
     * @return 페이징된 사용자 목록
     * @since 2025-08-01
     */
    @Override
    public Page<SampleUserRes> getAllUsers(Pageable pageable) {
        log.debug("전체 사용자 목록 조회: page={}, size={}", pageable.getPageNumber(), pageable.getPageSize());
        
        Page<SampleUser> users = sampleUserRepository.findAll(pageable);
        return users.map(sampleUserMapper::toDetailResponse);
    }

    /**
     * 상태별 사용자 목록 조회 (페이징)
     * 
     * <p>특정 상태(ACTIVE, INACTIVE, SUSPENDED)의 사용자들을 페이징 처리하여 조회합니다.
     * 인덱스가 설정된 status 컬럼을 통해 효율적인 조회를 수행합니다.</p>
     * 
     * @param status 조회할 사용자 상태
     * @param pageable 페이징 정보 (페이지 번호, 크기, 정렬 조건)
     * @return 해당 상태의 페이징된 사용자 목록
     * @since 2025-08-01
     */
    @Override
    public Page<SampleUserRes> getUsersByStatus(SampleUser.UserStatus status, Pageable pageable) {
        log.debug("상태별 사용자 목록 조회: status={}, page={}, size={}", 
                status, pageable.getPageNumber(), pageable.getPageSize());
        
        Page<SampleUser> users = sampleUserRepository.findByStatus(status, pageable);
        return users.map(sampleUserMapper::toDetailResponse);
    }

    /**
     * 키워드 기반 사용자 검색 (페이징)
     * 
     * <p>사용자명, 전체 이름, 이메일 필드에서 키워드를 검색합니다.
     * LIKE 연산자와 LOWER 함수를 사용하여 대소문자 구분 없는 부분 일치 검색을 수행합니다.</p>
     * 
     * @param keyword 검색 키워드 (사용자명, 전체 이름, 이메일에서 검색)
     * @param pageable 페이징 정보 (페이지 번호, 크기, 정렬 조건)
     * @return 키워드와 일치하는 페이징된 사용자 목록
     * @since 2025-08-01
     */
    @Override
    public Page<SampleUserRes> searchUsers(String keyword, Pageable pageable) {
        log.debug("사용자 검색: keyword={}, page={}, size={}", 
                keyword, pageable.getPageNumber(), pageable.getPageSize());
        
        Page<SampleUser> users = sampleUserRepository.searchByKeyword(keyword, pageable);
        return users.map(sampleUserMapper::toDetailResponse);
    }

    /**
     * 사용자 정보 수정
     * 
     * <p>기존 사용자의 정보를 부분적으로 수정합니다.
     * 이메일 변경 시 중복 검증을 수행하며, MapStruct를 통해 null이 아닌 필드만 업데이트됩니다.
     * ID, 사용자명, 패스워드는 이 메서드로 변경할 수 없습니다.</p>
     * 
     * @param id 수정할 사용자 ID
     * @param request 수정할 필드들이 포함된 요청 DTO
     * @return 수정된 사용자 정보 DTO
     * @throws IllegalArgumentException 사용자가 존재하지 않거나, 수정할 필드가 없거나, 이메일이 중복되는 경우
     * @since 2025-08-01
     */
    @Override
    @Transactional
    public SampleUserRes updateUser(Long id, SampleUserUpdateReq request) {
        log.info("사용자 정보 수정 요청: id={}", id);

        if (!request.hasValidFields()) {
            throw new IllegalArgumentException("수정할 필드가 없습니다");
        }

        SampleUser user = findUserById(id);

        // 이메일 중복 검사 (변경하는 경우)
        if (request.getEmail() != null && !request.getEmail().equals(user.getEmail())) {
            if (sampleUserRepository.existsByEmail(request.getEmail())) {
                throw new IllegalArgumentException("이미 존재하는 이메일입니다: " + request.getEmail());
            }
        }

        // MapStruct를 통한 엔티티 업데이트
        sampleUserMapper.updateEntity(request, user);

        SampleUser updatedUser = sampleUserRepository.save(user);
        
        log.info("사용자 정보 수정 완료: id={}, username={}", updatedUser.getId(), updatedUser.getUsername());
        
        return sampleUserMapper.toDetailResponse(updatedUser);
    }

    /**
     * 사용자 상태 변경
     * 
     * <p>사용자의 상태를 ACTIVE, INACTIVE, SUSPENDED 중 하나로 변경합니다.
     * 엔티티의 비즈니스 메서드를 통해 상태 변경 규칙을 적용합니다.</p>
     * 
     * @param id 상태를 변경할 사용자 ID
     * @param status 변경할 새로운 상태
     * @return 상태가 변경된 사용자 정보 DTO
     * @throws IllegalArgumentException 사용자가 존재하지 않는 경우
     * @since 2025-08-01
     */
    @Override
    @Transactional
    public SampleUserRes changeUserStatus(Long id, SampleUser.UserStatus status) {
        log.info("사용자 상태 변경 요청: id={}, status={}", id, status);
        
        SampleUser user = findUserById(id);
        user.changeStatus(status);
        
        SampleUser updatedUser = sampleUserRepository.save(user);
        
        log.info("사용자 상태 변경 완료: id={}, status={}", updatedUser.getId(), updatedUser.getStatus());
        
        return sampleUserMapper.toDetailResponse(updatedUser);
    }

    /**
     * 사용자 삭제
     * 
     * <p>지정된 ID의 사용자를 완전히 삭제합니다.
     * 물리적 삭제를 수행하므로 복구가 불가능합니다. 논리적 삭제가 필요한 경우 상태 변경을 사용하세요.</p>
     * 
     * @param id 삭제할 사용자 ID
     * @throws IllegalArgumentException 사용자가 존재하지 않는 경우
     * @since 2025-08-01
     */
    @Override
    @Transactional
    public void deleteUser(Long id) {
        log.info("사용자 삭제 요청: id={}", id);
        
        SampleUser user = findUserById(id);
        sampleUserRepository.delete(user);
        
        log.info("사용자 삭제 완료: id={}, username={}", id, user.getUsername());
    }

    /**
     * 사용자명 존재 여부 확인
     * 
     * <p>주어진 사용자명이 이미 사용 중인지 확인합니다.
     * 사용자 등록 시 중복 검증에 사용됩니다.</p>
     * 
     * @param username 확인할 사용자명
     * @return 사용자명이 존재하면 true, 그렇지 않으면 false
     * @since 2025-08-01
     */
    @Override
    public boolean isUsernameExists(String username) {
        return sampleUserRepository.existsByUsername(username);
    }

    /**
     * 이메일 존재 여부 확인
     * 
     * <p>주어진 이메일이 이미 사용 중인지 확인합니다.
     * 사용자 등록 및 이메일 변경 시 중복 검증에 사용됩니다.</p>
     * 
     * @param email 확인할 이메일 주소
     * @return 이메일이 존재하면 true, 그렇지 않으면 false
     * @since 2025-08-01
     */
    @Override
    public boolean isEmailExists(String email) {
        return sampleUserRepository.existsByEmail(email);
    }

    /**
     * 나이 범위별 사용자 목록 조회
     * 
     * <p>최소 나이와 최대 나이 범위에 해당하는 사용자들을 조회합니다.
     * 경계값을 포함하며(inclusive), null 값 처리도 지원합니다.</p>
     * 
     * @param minAge 최소 나이 (null 허용 - 하한선 없음)
     * @param maxAge 최대 나이 (null 허용 - 상한선 없음)
     * @return 나이 범위에 해당하는 사용자 목록
     * @since 2025-08-01
     */
    @Override
    public List<SampleUserRes> getUsersByAgeRange(Integer minAge, Integer maxAge) {
        log.debug("나이 범위별 사용자 조회: minAge={}, maxAge={}", minAge, maxAge);
        
        List<SampleUser> users = sampleUserRepository.findByAgeRange(minAge, maxAge);
        return users.stream()
                .map(sampleUserMapper::toDetailResponse)
                .collect(Collectors.toList());
    }

    /**
     * 활성 사용자 목록 조회 (페이징)
     * 
     * <p>상태가 ACTIVE인 사용자들만 페이징 처리하여 조회합니다.
     * 활성 사용자 관리 및 통계에 사용됩니다.</p>
     * 
     * @param pageable 페이징 정보 (페이지 번호, 크기, 정렬 조건)
     * @return 활성 사용자 페이징 목록
     * @since 2025-08-01
     */
    @Override
    public Page<SampleUserRes> getActiveUsers(Pageable pageable) {
        log.debug("활성 사용자 목록 조회: page={}, size={}", pageable.getPageNumber(), pageable.getPageSize());
        
        Page<SampleUser> users = sampleUserRepository.findActiveUsers(pageable);
        return users.map(sampleUserMapper::toDetailResponse);
    }

    /**
     * 사용자 상태별 통계 조회
     * 
     * <p>각 사용자 상태별 사용자 수를 집계하여 반환합니다.
     * GROUP BY 쿼리를 사용하여 효율적인 통계 데이터를 제공합니다.</p>
     * 
     * @return 상태별 사용자 수 맵 (키: 상태 설명, 값: 사용자 수)
     * @since 2025-08-01
     */
    @Override
    public Map<String, Long> getUserStatistics() {
        log.debug("사용자 통계 조회");
        
        List<Object[]> statistics = sampleUserRepository.getUserStatistics();
        return statistics.stream()
                .collect(Collectors.toMap(
                        stat -> ((SampleUser.UserStatus) stat[0]).getDescription(),
                        stat -> (Long) stat[1]
                ));
    }

    /**
     * 최근 가입 사용자 목록 조회
     * 
     * <p>생성일시 기준으로 최근에 가입한 사용자들을 제한된 수만큼 조회합니다.
     * 대시보드나 관리자 화면의 최신 가입자 표시에 사용됩니다.</p>
     * 
     * @param limit 조회할 최대 사용자 수
     * @return 최근 가입 사용자 목록 (생성일시 내림차순)
     * @since 2025-08-01
     */
    @Override
    public List<SampleUserRes> getRecentUsers(int limit) {
        log.debug("최근 가입 사용자 조회: limit={}", limit);
        
        List<SampleUser> users = sampleUserRepository.findRecentUsers(limit);
        return users.stream()
                .map(sampleUserMapper::toDetailResponse)
                .collect(Collectors.toList());
    }

    /**
     * 사용자 ID로 사용자 조회 (내부 메서드)
     * 
     * @param id 사용자 ID
     * @return 사용자 엔티티
     */
    private SampleUser findUserById(Long id) {
        return sampleUserRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다: " + id));
    }
}
