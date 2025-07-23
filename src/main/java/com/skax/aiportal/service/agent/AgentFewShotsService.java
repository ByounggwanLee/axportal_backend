package com.skax.aiportal.service.agent;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.skax.aiportal.dto.agent.request.AgentFewShotsCommentCreateRequest;
import com.skax.aiportal.dto.agent.request.AgentFewShotsCreateRequest;
import com.skax.aiportal.dto.agent.request.AgentFewShotsUpdateRequest;
import com.skax.aiportal.dto.agent.response.AgentFewShotsListResponse;
import com.skax.aiportal.dto.agent.response.AgentFewShotsResponse;

/**
 * Agent FewShots 서비스 인터페이스
 * 
 * <p>Few-shot 예시 데이터 관련 비즈니스 로직을 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
public interface AgentFewShotsService {

    /**
     * FewShots 목록 조회
     * 
     * @param projectId 프로젝트 ID
     * @param page 페이지 번호
     * @param size 페이지 크기
     * @param sort 정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return FewShots 목록 응답
     */
    AgentFewShotsListResponse getFewShots(String projectId, Integer page, Integer size, String sort, String filter, String search);

    /**
     * FewShots 상세 조회
     * 
     * @param fewShotUuid FewShots UUID
     * @return FewShots 상세 정보
     */
    AgentFewShotsResponse getFewShotById(String fewShotUuid);

    /**
     * FewShots 생성
     * 
     * @param request FewShots 생성 요청
     * @return 생성된 FewShots 정보
     */
    AgentFewShotsResponse createFewShots(AgentFewShotsCreateRequest request);

    /**
     * FewShots 수정
     * 
     * @param fewShotUuid FewShots UUID
     * @param request FewShots 수정 요청
     * @return 수정된 FewShots 정보
     */
    AgentFewShotsResponse updateFewShots(String fewShotUuid, AgentFewShotsUpdateRequest request);

    /**
     * FewShots 삭제
     * 
     * @param fewShotUuid FewShots UUID
     */
    void deleteFewShots(String fewShotUuid);

    /**
     * FewShots 템플릿 내보내기
     * 
     * @param fewShotUuid FewShots UUID
     * @return 템플릿 파일 바이트 배열
     */
    byte[] exportTemplate(String fewShotUuid);

    /**
     * FewShots 가져오기 (파일 업로드)
     * 
     * @param versionId 버전 ID
     * @param file 업로드 파일
     * @param overwrite 덮어쓰기 여부
     * @return 가져오기 결과
     */
    Map<String, Object> importFewShots(String versionId, MultipartFile file, Boolean overwrite);

    /**
     * FewShots 최신 버전 조회
     * 
     * @param fewShotUuid FewShots UUID
     * @param page 페이지 번호
     * @param size 페이지 크기
     * @param sort 정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return 최신 버전 정보
     */
    Map<String, Object> getLatestVersion(String fewShotUuid, Integer page, Integer size, String sort, String filter, String search);

    /**
     * FewShots 아이템 목록 조회
     * 
     * @param versionId 버전 ID
     * @param page 페이지 번호
     * @param size 페이지 크기
     * @param sort 정렬 기준
     * @param filter 필터 조건
     * @param search 검색어
     * @return 아이템 목록
     */
    List<Map<String, Object>> getFewShotItems(String versionId, Integer page, Integer size, String sort, String filter, String search);

    /**
     * FewShots 의존성 조회
     * 
     * @param versionId 버전 ID
     * @return 의존성 목록
     */
    List<Map<String, Object>> getDependencies(String versionId);

    /**
     * FewShots 태그 조회
     * 
     * @param versionId 버전 ID
     * @return 태그 목록
     */
    List<String> getTags(String versionId);

    /**
     * 모든 태그 목록 조회
     * 
     * @return 모든 태그 목록
     */
    List<String> getAllTags();

    /**
     * FewShots 댓글 목록 조회
     * 
     * @param versionId 버전 ID
     * @param page 페이지 번호
     * @param size 페이지 크기
     * @param sort 정렬 기준
     * @return 댓글 목록
     */
    List<Map<String, Object>> getComments(String versionId, Integer page, Integer size, String sort);

    /**
     * FewShots 댓글 생성
     * 
     * @param versionId 버전 ID
     * @param request 댓글 생성 요청
     * @return 생성된 댓글 정보
     */
    Map<String, Object> createComment(String versionId, AgentFewShotsCommentCreateRequest request);

    /**
     * FewShots 버전 목록 조회
     * 
     * @param fewShotUuid FewShots UUID
     * @return 버전 목록
     */
    List<Map<String, Object>> getVersions(String fewShotUuid);

    /**
     * FewShots 댓글 수정
     * 
     * @param commentUuid 댓글 UUID
     * @param request 댓글 수정 요청
     * @return 수정된 댓글 정보
     */
    Map<String, Object> updateComment(String commentUuid, AgentFewShotsCommentCreateRequest request);

    /**
     * FewShots 댓글 삭제
     * 
     * @param commentUuid 댓글 UUID
     */
    void deleteComment(String commentUuid);

    /**
     * FewShots API 정보 조회
     * 
     * @param fewShotUuid FewShots UUID
     * @return API 정보
     */
    Map<String, Object> getApiInfo(String fewShotUuid);

    /**
     * FewShots 테스트 실행
     * 
     * @param fewShotUuid FewShots UUID
     * @return 테스트 결과
     */
    Map<String, Object> testFewShots(String fewShotUuid);

    /**
     * 삭제된 모든 FewShots 완전 삭제
     */
    void hardDeleteFewShots();
}
