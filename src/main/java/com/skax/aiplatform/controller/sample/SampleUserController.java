package com.skax.aiplatform.controller.sample;

import com.skax.aiplatform.common.response.AxResponse;
import com.skax.aiplatform.dto.sample.request.SampleUserCreateReq;
import com.skax.aiplatform.dto.sample.request.SampleUserUpdateReq;
import com.skax.aiplatform.dto.sample.response.SampleUserRes;
import com.skax.aiplatform.entity.sample.SampleUser;
import com.skax.aiplatform.service.sample.SampleUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 샘플 사용자 컨트롤러
 * 
 * <p>샘플 사용자 관리 API 엔드포인트를 제공합니다.
 * 기본적인 CRUD 작업과 검색, 통계 기능을 포함합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/sample/users")
@RequiredArgsConstructor
@Tag(name = "Sample User", description = "샘플 사용자 관리 API")
public class SampleUserController {

    private final SampleUserService sampleUserService;

    /**
     * 새로운 사용자 생성
     * 
     * @param request 사용자 생성 요청
     * @return 생성된 사용자 정보
     */
    @PostMapping
    @Operation(summary = "사용자 생성", description = "새로운 사용자를 생성합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "사용자 생성 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 데이터"),
            @ApiResponse(responseCode = "409", description = "사용자명 또는 이메일 중복")
    })
    public ResponseEntity<AxResponse<SampleUserRes>> createUser(
            @Valid @RequestBody SampleUserCreateReq request) {
        
        log.info("사용자 생성 API 호출: username={}", request.getUsername());
        
        SampleUserRes user = sampleUserService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(AxResponse.success(user, "사용자가 성공적으로 생성되었습니다."));
    }

    /**
     * 사용자 상세 조회
     * 
     * @param id 사용자 ID
     * @return 사용자 정보
     */
    @GetMapping("/{id}")
    @Operation(summary = "사용자 조회", description = "ID로 사용자 정보를 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "사용자 조회 성공"),
            @ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없음")
    })
    public ResponseEntity<AxResponse<SampleUserRes>> getUserById(
            @Parameter(description = "사용자 ID", example = "1")
            @PathVariable Long id) {
        
        log.info("사용자 조회 API 호출: id={}", id);
        
        SampleUserRes user = sampleUserService.getUserById(id);
        return ResponseEntity.ok(AxResponse.success(user, "사용자 조회 성공"));
    }

    /**
     * 사용자명으로 사용자 조회
     * 
     * @param username 사용자명
     * @return 사용자 정보
     */
    @GetMapping("/username/{username}")
    @Operation(summary = "사용자명으로 조회", description = "사용자명으로 사용자 정보를 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "사용자 조회 성공"),
            @ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없음")
    })
    public ResponseEntity<AxResponse<SampleUserRes>> getUserByUsername(
            @Parameter(description = "사용자명", example = "john_doe")
            @PathVariable String username) {
        
        log.info("사용자명 조회 API 호출: username={}", username);
        
        SampleUserRes user = sampleUserService.getUserByUsername(username);
        return ResponseEntity.ok(AxResponse.success(user, "사용자 조회 성공"));
    }

    /**
     * 전체 사용자 목록 조회 (페이징)
     * 
     * @param pageable 페이징 정보
     * @return 사용자 목록
     */
    @GetMapping
    @Operation(summary = "사용자 목록 조회", description = "전체 사용자 목록을 페이징으로 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "사용자 목록 조회 성공")
    })
    public ResponseEntity<AxResponse<Page<SampleUserRes>>> getAllUsers(
            @PageableDefault(size = 20, sort = "createdAt", direction = Sort.Direction.DESC) 
            Pageable pageable) {
        
        log.info("사용자 목록 조회 API 호출: page={}, size={}", 
                pageable.getPageNumber(), pageable.getPageSize());
        
        Page<SampleUserRes> users = sampleUserService.getAllUsers(pageable);
        return ResponseEntity.ok(AxResponse.success(users, "사용자 목록 조회 성공"));
    }

    /**
     * 상태별 사용자 목록 조회
     * 
     * @param status 사용자 상태
     * @param pageable 페이징 정보
     * @return 사용자 목록
     */
    @GetMapping("/status/{status}")
    @Operation(summary = "상태별 사용자 조회", description = "특정 상태의 사용자 목록을 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "사용자 목록 조회 성공")
    })
    public ResponseEntity<AxResponse<Page<SampleUserRes>>> getUsersByStatus(
            @Parameter(description = "사용자 상태", example = "ACTIVE")
            @PathVariable SampleUser.UserStatus status,
            @PageableDefault(size = 20, sort = "createdAt", direction = Sort.Direction.DESC) 
            Pageable pageable) {
        
        log.info("상태별 사용자 조회 API 호출: status={}", status);
        
        Page<SampleUserRes> users = sampleUserService.getUsersByStatus(status, pageable);
        return ResponseEntity.ok(AxResponse.success(users, "상태별 사용자 목록 조회 성공"));
    }

    /**
     * 사용자 검색
     * 
     * @param keyword 검색 키워드
     * @param pageable 페이징 정보
     * @return 검색된 사용자 목록
     */
    @GetMapping("/search")
    @Operation(summary = "사용자 검색", description = "키워드로 사용자를 검색합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "사용자 검색 성공")
    })
    public ResponseEntity<AxResponse<Page<SampleUserRes>>> searchUsers(
            @Parameter(description = "검색 키워드", example = "john")
            @RequestParam String keyword,
            @PageableDefault(size = 20, sort = "createdAt", direction = Sort.Direction.DESC) 
            Pageable pageable) {
        
        log.info("사용자 검색 API 호출: keyword={}", keyword);
        
        Page<SampleUserRes> users = sampleUserService.searchUsers(keyword, pageable);
        return ResponseEntity.ok(AxResponse.success(users, "사용자 검색 성공"));
    }

    /**
     * 사용자 정보 수정
     * 
     * @param id 사용자 ID
     * @param request 수정 요청
     * @return 수정된 사용자 정보
     */
    @PutMapping("/{id}")
    @Operation(summary = "사용자 정보 수정", description = "사용자 정보를 수정합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "사용자 정보 수정 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 데이터"),
            @ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없음")
    })
    public ResponseEntity<AxResponse<SampleUserRes>> updateUser(
            @Parameter(description = "사용자 ID", example = "1")
            @PathVariable Long id,
            @Valid @RequestBody SampleUserUpdateReq request) {
        
        log.info("사용자 정보 수정 API 호출: id={}", id);
        
        SampleUserRes user = sampleUserService.updateUser(id, request);
        return ResponseEntity.ok(AxResponse.success(user, "사용자 정보가 성공적으로 수정되었습니다."));
    }

    /**
     * 사용자 상태 변경
     * 
     * @param id 사용자 ID
     * @param status 새로운 상태
     * @return 수정된 사용자 정보
     */
    @PatchMapping("/{id}/status")
    @Operation(summary = "사용자 상태 변경", description = "사용자 상태를 변경합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "사용자 상태 변경 성공"),
            @ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없음")
    })
    public ResponseEntity<AxResponse<SampleUserRes>> changeUserStatus(
            @Parameter(description = "사용자 ID", example = "1")
            @PathVariable Long id,
            @Parameter(description = "새로운 상태", example = "INACTIVE")
            @RequestParam SampleUser.UserStatus status) {
        
        log.info("사용자 상태 변경 API 호출: id={}, status={}", id, status);
        
        SampleUserRes user = sampleUserService.changeUserStatus(id, status);
        return ResponseEntity.ok(AxResponse.success(user, "사용자 상태가 성공적으로 변경되었습니다."));
    }

    /**
     * 사용자 삭제
     * 
     * @param id 사용자 ID
     * @return 삭제 성공 메시지
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "사용자 삭제", description = "사용자를 삭제합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "사용자 삭제 성공"),
            @ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없음")
    })
    public ResponseEntity<AxResponse<Void>> deleteUser(
            @Parameter(description = "사용자 ID", example = "1")
            @PathVariable Long id) {
        
        log.info("사용자 삭제 API 호출: id={}", id);
        
        sampleUserService.deleteUser(id);
        return ResponseEntity.ok(AxResponse.success("사용자가 성공적으로 삭제되었습니다."));
    }

    /**
     * 사용자명 중복 확인
     * 
     * @param username 사용자명
     * @return 중복 여부
     */
    @GetMapping("/check/username")
    @Operation(summary = "사용자명 중복 확인", description = "사용자명 중복 여부를 확인합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "중복 확인 성공")
    })
    public ResponseEntity<AxResponse<Map<String, Boolean>>> checkUsername(
            @Parameter(description = "사용자명", example = "john_doe")
            @RequestParam String username) {
        
        log.info("사용자명 중복 확인 API 호출: username={}", username);
        
        boolean exists = sampleUserService.isUsernameExists(username);
        Map<String, Boolean> result = Map.of("exists", exists);
        return ResponseEntity.ok(AxResponse.success(result, "사용자명 중복 확인 완료"));
    }

    /**
     * 이메일 중복 확인
     * 
     * @param email 이메일
     * @return 중복 여부
     */
    @GetMapping("/check/email")
    @Operation(summary = "이메일 중복 확인", description = "이메일 중복 여부를 확인합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "중복 확인 성공")
    })
    public ResponseEntity<AxResponse<Map<String, Boolean>>> checkEmail(
            @Parameter(description = "이메일", example = "john.doe@example.com")
            @RequestParam String email) {
        
        log.info("이메일 중복 확인 API 호출: email={}", email);
        
        boolean exists = sampleUserService.isEmailExists(email);
        Map<String, Boolean> result = Map.of("exists", exists);
        return ResponseEntity.ok(AxResponse.success(result, "이메일 중복 확인 완료"));
    }

    /**
     * 나이 범위로 사용자 조회
     * 
     * @param minAge 최소 나이
     * @param maxAge 최대 나이
     * @return 사용자 목록
     */
    @GetMapping("/age-range")
    @Operation(summary = "나이 범위로 사용자 조회", description = "특정 나이 범위의 사용자를 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "나이 범위 조회 성공")
    })
    public ResponseEntity<AxResponse<List<SampleUserRes>>> getUsersByAgeRange(
            @Parameter(description = "최소 나이", example = "20")
            @RequestParam Integer minAge,
            @Parameter(description = "최대 나이", example = "30")
            @RequestParam Integer maxAge) {
        
        log.info("나이 범위 조회 API 호출: minAge={}, maxAge={}", minAge, maxAge);
        
        List<SampleUserRes> users = sampleUserService.getUsersByAgeRange(minAge, maxAge);
        return ResponseEntity.ok(AxResponse.success(users, "나이 범위 조회 성공"));
    }

    /**
     * 활성 사용자 목록 조회
     * 
     * @param pageable 페이징 정보
     * @return 활성 사용자 목록
     */
    @GetMapping("/active")
    @Operation(summary = "활성 사용자 조회", description = "활성 상태의 사용자 목록을 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "활성 사용자 조회 성공")
    })
    public ResponseEntity<AxResponse<Page<SampleUserRes>>> getActiveUsers(
            @PageableDefault(size = 20, sort = "createdAt", direction = Sort.Direction.DESC) 
            Pageable pageable) {
        
        log.info("활성 사용자 조회 API 호출");
        
        Page<SampleUserRes> users = sampleUserService.getActiveUsers(pageable);
        return ResponseEntity.ok(AxResponse.success(users, "활성 사용자 조회 성공"));
    }

    /**
     * 사용자 통계 조회
     * 
     * @return 상태별 사용자 수
     */
    @GetMapping("/statistics")
    @Operation(summary = "사용자 통계", description = "상태별 사용자 통계를 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "통계 조회 성공")
    })
    public ResponseEntity<AxResponse<Map<String, Long>>> getUserStatistics() {
        log.info("사용자 통계 조회 API 호출");
        
        Map<String, Long> statistics = sampleUserService.getUserStatistics();
        return ResponseEntity.ok(AxResponse.success(statistics, "사용자 통계 조회 성공"));
    }

    /**
     * 최근 가입한 사용자 조회
     * 
     * @param limit 조회할 개수
     * @return 최근 가입 사용자 목록
     */
    @GetMapping("/recent")
    @Operation(summary = "최근 가입 사용자", description = "최근 가입한 사용자 목록을 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "최근 가입 사용자 조회 성공")
    })
    public ResponseEntity<AxResponse<List<SampleUserRes>>> getRecentUsers(
            @Parameter(description = "조회할 개수", example = "10")
            @RequestParam(defaultValue = "10") int limit) {
        
        log.info("최근 가입 사용자 조회 API 호출: limit={}", limit);
        
        List<SampleUserRes> users = sampleUserService.getRecentUsers(limit);
        return ResponseEntity.ok(AxResponse.success(users, "최근 가입 사용자 조회 성공"));
    }
}
