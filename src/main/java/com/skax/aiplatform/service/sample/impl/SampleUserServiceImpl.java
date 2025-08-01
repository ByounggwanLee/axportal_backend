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

    @Override
    public SampleUserRes getUserById(Long id) {
        log.debug("사용자 조회 요청: id={}", id);
        
        SampleUser user = findUserById(id);
        return sampleUserMapper.toDetailResponse(user);
    }

    @Override
    public SampleUserRes getUserByUsername(String username) {
        log.debug("사용자 조회 요청: username={}", username);
        
        SampleUser user = sampleUserRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다: " + username));
        
        return sampleUserMapper.toDetailResponse(user);
    }

    @Override
    public Page<SampleUserRes> getAllUsers(Pageable pageable) {
        log.debug("전체 사용자 목록 조회: page={}, size={}", pageable.getPageNumber(), pageable.getPageSize());
        
        Page<SampleUser> users = sampleUserRepository.findAll(pageable);
        return users.map(sampleUserMapper::toDetailResponse);
    }

    @Override
    public Page<SampleUserRes> getUsersByStatus(SampleUser.UserStatus status, Pageable pageable) {
        log.debug("상태별 사용자 목록 조회: status={}, page={}, size={}", 
                status, pageable.getPageNumber(), pageable.getPageSize());
        
        Page<SampleUser> users = sampleUserRepository.findByStatus(status, pageable);
        return users.map(sampleUserMapper::toDetailResponse);
    }

    @Override
    public Page<SampleUserRes> searchUsers(String keyword, Pageable pageable) {
        log.debug("사용자 검색: keyword={}, page={}, size={}", 
                keyword, pageable.getPageNumber(), pageable.getPageSize());
        
        Page<SampleUser> users = sampleUserRepository.searchByKeyword(keyword, pageable);
        return users.map(sampleUserMapper::toDetailResponse);
    }

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

    @Override
    @Transactional
    public void deleteUser(Long id) {
        log.info("사용자 삭제 요청: id={}", id);
        
        SampleUser user = findUserById(id);
        sampleUserRepository.delete(user);
        
        log.info("사용자 삭제 완료: id={}, username={}", id, user.getUsername());
    }

    @Override
    public boolean isUsernameExists(String username) {
        return sampleUserRepository.existsByUsername(username);
    }

    @Override
    public boolean isEmailExists(String email) {
        return sampleUserRepository.existsByEmail(email);
    }

    @Override
    public List<SampleUserRes> getUsersByAgeRange(Integer minAge, Integer maxAge) {
        log.debug("나이 범위별 사용자 조회: minAge={}, maxAge={}", minAge, maxAge);
        
        List<SampleUser> users = sampleUserRepository.findByAgeRange(minAge, maxAge);
        return users.stream()
                .map(sampleUserMapper::toDetailResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Page<SampleUserRes> getActiveUsers(Pageable pageable) {
        log.debug("활성 사용자 목록 조회: page={}, size={}", pageable.getPageNumber(), pageable.getPageSize());
        
        Page<SampleUser> users = sampleUserRepository.findActiveUsers(pageable);
        return users.map(sampleUserMapper::toDetailResponse);
    }

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
