package com.skax.aiportal.constant;

/**
 * 데이터셋 관련 상수 클래스
 * 
 * <p>데이터셋 처리와 관련된 모든 상수값들을 관리하는 클래스입니다.
 * 에러 코드, 메시지, 기본값, API 경로 등을 정의합니다.</p>
 * 
 * <p>주요 카테고리:</p>
 * <ul>
 *   <li>API 경로 상수</li>
 *   <li>에러 코드 및 메시지</li>
 *   <li>성공 메시지</li>
 *   <li>기본값 및 제한값</li>
 *   <li>로그 메시지 템플릿</li>
 * </ul>
 * 
 * @author ByounggwanLee
 * @since 2025-07-24
 * @version 1.0
 */
public final class DatasetConstants {

    private DatasetConstants() {
        // 유틸리티 클래스는 인스턴스화 방지
    }

    // ===== API 경로 상수 =====
    public static final String API_BASE_PATH = "/api/v1/datasets";
    public static final String DATASET_ID_PATH = "/{datasetId}";
    public static final String PREVIEW_PATH = "/preview";
    public static final String TAGS_PATH = "/tags";
    public static final String HARD_DELETE_PATH = "/hard";
    public static final String UPLOAD_PATH = "/upload";

    // ===== 에러 코드 =====
    public static final String DATASET_LIST_ERROR_CODE = "DATASET_001";
    public static final String DATASET_CREATE_ERROR_CODE = "DATASET_002";
    public static final String DATASET_GET_ERROR_CODE = "DATASET_003";
    public static final String DATASET_UPDATE_ERROR_CODE = "DATASET_004";
    public static final String DATASET_DELETE_ERROR_CODE = "DATASET_005";
    public static final String DATASET_HARD_DELETE_ERROR_CODE = "DATASET_006";
    public static final String DATASET_UPLOAD_ERROR_CODE = "DATASET_007";
    public static final String DATASET_PREVIEW_ERROR_CODE = "DATASET_008";
    public static final String DATASET_TAG_UPDATE_ERROR_CODE = "DATASET_009";
    public static final String DATASET_TAG_DELETE_ERROR_CODE = "DATASET_010";

    // ===== 에러 메시지 =====
    public static final String DATASET_LIST_ERROR_MESSAGE = "데이터셋 목록 조회 중 오류가 발생했습니다: %s";
    public static final String DATASET_CREATE_ERROR_MESSAGE = "데이터셋 생성 중 오류가 발생했습니다: %s";
    public static final String DATASET_GET_ERROR_MESSAGE = "데이터셋 조회 중 오류가 발생했습니다: %s";
    public static final String DATASET_UPDATE_ERROR_MESSAGE = "데이터셋 수정 중 오류가 발생했습니다: %s";
    public static final String DATASET_DELETE_ERROR_MESSAGE = "데이터셋 삭제 중 오류가 발생했습니다: %s";
    public static final String DATASET_HARD_DELETE_ERROR_MESSAGE = "데이터셋 완전 삭제 중 오류가 발생했습니다: %s";
    public static final String DATASET_UPLOAD_ERROR_MESSAGE = "데이터셋 업로드 중 오류가 발생했습니다: %s";
    public static final String DATASET_PREVIEW_ERROR_MESSAGE = "데이터셋 미리보기 중 오류가 발생했습니다: %s";
    public static final String DATASET_TAG_UPDATE_ERROR_MESSAGE = "데이터셋 태그 추가 중 오류가 발생했습니다: %s";
    public static final String DATASET_TAG_DELETE_ERROR_MESSAGE = "데이터셋 태그 삭제 중 오류가 발생했습니다: %s";

    // ===== 성공 메시지 =====
    public static final String DATASET_LIST_SUCCESS_MESSAGE = "데이터셋 목록 조회가 완료되었습니다.";
    public static final String DATASET_CREATE_SUCCESS_MESSAGE = "데이터셋 생성이 완료되었습니다.";
    public static final String DATASET_GET_SUCCESS_MESSAGE = "데이터셋 조회가 완료되었습니다.";
    public static final String DATASET_UPDATE_SUCCESS_MESSAGE = "데이터셋 수정이 완료되었습니다.";
    public static final String DATASET_DELETE_SUCCESS_MESSAGE = "데이터셋 삭제가 완료되었습니다.";
    public static final String DATASET_HARD_DELETE_SUCCESS_MESSAGE = "데이터셋 완전 삭제가 완료되었습니다.";
    public static final String DATASET_UPLOAD_SUCCESS_MESSAGE = "데이터셋 업로드가 완료되었습니다.";
    public static final String DATASET_PREVIEW_SUCCESS_MESSAGE = "데이터셋 미리보기 조회가 완료되었습니다.";
    public static final String DATASET_TAG_UPDATE_SUCCESS_MESSAGE = "데이터셋 태그 추가가 완료되었습니다.";
    public static final String DATASET_TAG_DELETE_SUCCESS_MESSAGE = "데이터셋 태그 삭제가 완료되었습니다.";

    // ===== 로그 메시지 템플릿 =====
    // 시작 메시지
    public static final String LOG_DATASET_LIST_START = "데이터셋 목록 조회 시작: page={}, size={}, sortBy={}, projectId={}, searchKeyword={}";
    public static final String LOG_DATASET_CREATE_START = "데이터셋 생성 시작: name={}, type={}, datasourceId={}";
    public static final String LOG_DATASET_GET_START = "데이터셋 조회 시작: datasetId={}";
    public static final String LOG_DATASET_UPDATE_START = "데이터셋 수정 시작: datasetId={}";
    public static final String LOG_DATASET_DELETE_START = "데이터셋 삭제 시작: datasetId={}";
    public static final String LOG_DATASET_HARD_DELETE_START = "데이터셋 완전 삭제 시작";
    public static final String LOG_DATASET_UPLOAD_START = "데이터셋 업로드 시작: name={}, fileName={}";
    public static final String LOG_DATASET_PREVIEW_START = "데이터셋 미리보기 시작: datasetId={}, rowLimit={}";
    public static final String LOG_DATASET_TAG_UPDATE_START = "데이터셋 태그 추가 시작: datasetId={}, tagCount={}";
    public static final String LOG_DATASET_TAG_DELETE_START = "데이터셋 태그 삭제 시작: datasetId={}, tagCount={}";

    // 성공 메시지
    public static final String LOG_DATASET_LIST_SUCCESS = "데이터셋 목록 조회 완료: totalCount={}, 처리시간={}ms";
    public static final String LOG_DATASET_CREATE_SUCCESS = "데이터셋 생성 완료: datasetId={}, name={}, 처리시간={}ms";
    public static final String LOG_DATASET_GET_SUCCESS = "데이터셋 조회 완료: datasetId={}, name={}, 처리시간={}ms";
    public static final String LOG_DATASET_UPDATE_SUCCESS = "데이터셋 수정 완료: datasetId={}, 처리시간={}ms";
    public static final String LOG_DATASET_DELETE_SUCCESS = "데이터셋 삭제 완료: datasetId={}, 처리시간={}ms";
    public static final String LOG_DATASET_HARD_DELETE_SUCCESS = "데이터셋 완전 삭제 완료: 처리시간={}ms";
    public static final String LOG_DATASET_UPLOAD_SUCCESS = "데이터셋 업로드 완료: datasetId={}, uploadId={}, 처리시간={}ms";
    public static final String LOG_DATASET_PREVIEW_SUCCESS = "데이터셋 미리보기 완료: datasetId={}, sampleRowCount={}, 처리시간={}ms";
    public static final String LOG_DATASET_TAG_UPDATE_SUCCESS = "데이터셋 태그 추가 완료: datasetId={}, 처리시간={}ms";
    public static final String LOG_DATASET_TAG_DELETE_SUCCESS = "데이터셋 태그 삭제 완료: datasetId={}, 처리시간={}ms";

    // 실패 메시지
    public static final String LOG_DATASET_LIST_FAILURE = "데이터셋 목록 조회 실패: 처리시간={}ms, error={}";
    public static final String LOG_DATASET_CREATE_FAILURE = "데이터셋 생성 실패: name={}, 처리시간={}ms, error={}";
    public static final String LOG_DATASET_GET_FAILURE = "데이터셋 조회 실패: datasetId={}, 처리시간={}ms, error={}";
    public static final String LOG_DATASET_UPDATE_FAILURE = "데이터셋 수정 실패: datasetId={}, 처리시간={}ms, error={}";
    public static final String LOG_DATASET_DELETE_FAILURE = "데이터셋 삭제 실패: datasetId={}, 처리시간={}ms, error={}";
    public static final String LOG_DATASET_HARD_DELETE_FAILURE = "데이터셋 완전 삭제 실패: 처리시간={}ms, error={}";
    public static final String LOG_DATASET_UPLOAD_FAILURE = "데이터셋 업로드 실패: name={}, 처리시간={}ms, error={}";
    public static final String LOG_DATASET_PREVIEW_FAILURE = "데이터셋 미리보기 실패: datasetId={}, 처리시간={}ms, error={}";
    public static final String LOG_DATASET_TAG_UPDATE_FAILURE = "데이터셋 태그 추가 실패: datasetId={}, 처리시간={}ms, error={}";
    public static final String LOG_DATASET_TAG_DELETE_FAILURE = "데이터셋 태그 삭제 실패: datasetId={}, 처리시간={}ms, error={}";

    // ===== 기본값 및 제한값 =====
    public static final int DEFAULT_PAGE_SIZE = 20;
    public static final int MAX_PAGE_SIZE = 100;
    public static final int MIN_PAGE_SIZE = 1;
    public static final int DEFAULT_PAGE_NUMBER = 0;
    public static final int DEFAULT_PREVIEW_ROWS = 100;
    public static final int MAX_PREVIEW_ROWS = 1000;
    public static final String DEFAULT_SORT_BY = "createdAt";

    // ===== HTTP 상태 코드 설명 =====
    public static final String HTTP_200_DESCRIPTION = "요청 성공";
    public static final String HTTP_201_DESCRIPTION = "데이터 생성 성공";
    public static final String HTTP_400_DESCRIPTION = "잘못된 요청 - 필수 파라미터 누락 또는 유효하지 않은 형식";
    public static final String HTTP_404_DESCRIPTION = "리소스를 찾을 수 없음";
    public static final String HTTP_500_DESCRIPTION = "서버 내부 오류";

    // ===== API 문서화 관련 상수 =====
    public static final String API_TAG_NAME = "Dataset API";
    public static final String API_TAG_DESCRIPTION = "SKT AI 플랫폼 데이터셋 관리 API";

    // ===== 검증 메시지 =====
    public static final String VALIDATION_DATASET_ID_REQUIRED = "데이터셋 ID는 필수입니다";
    public static final String VALIDATION_DATASET_NAME_REQUIRED = "데이터셋 이름은 필수입니다";
    public static final String VALIDATION_DATASET_TYPE_REQUIRED = "데이터셋 타입은 필수입니다";
    public static final String VALIDATION_DATASOURCE_ID_REQUIRED = "데이터소스 ID는 필수입니다";
    public static final String VALIDATION_PROJECT_ID_REQUIRED = "프로젝트 ID는 필수입니다";
    public static final String VALIDATION_FILE_REQUIRED = "업로드할 파일은 필수입니다";
    public static final String VALIDATION_PAGE_SIZE_RANGE = "페이지 크기는 1부터 100까지 입력 가능합니다";
    public static final String VALIDATION_ROW_LIMIT_RANGE = "행 제한은 1부터 1000까지 입력 가능합니다";

    // ===== 파라미터 설명 =====
    public static final String PARAM_DATASET_ID_DESCRIPTION = "데이터셋 고유 식별자";
    public static final String PARAM_PAGE_DESCRIPTION = "페이지 번호 (0부터 시작)";
    public static final String PARAM_SIZE_DESCRIPTION = "페이지당 아이템 수";
    public static final String PARAM_SORT_BY_DESCRIPTION = "정렬 기준 필드";
    public static final String PARAM_PROJECT_ID_DESCRIPTION = "프로젝트 ID로 필터링";
    public static final String PARAM_SEARCH_KEYWORD_DESCRIPTION = "검색 키워드";

    // ===== API 작업 설명 =====
    public static final String OPERATION_DATASET_LIST = "데이터셋 목록 조회";
    public static final String OPERATION_DATASET_CREATE = "데이터셋 생성";
    public static final String OPERATION_DATASET_GET = "데이터셋 상세 조회";
    public static final String OPERATION_DATASET_UPDATE = "데이터셋 수정";
    public static final String OPERATION_DATASET_DELETE = "데이터셋 삭제";
    public static final String OPERATION_DATASET_HARD_DELETE = "데이터셋 완전 삭제";
    public static final String OPERATION_DATASET_UPLOAD = "데이터셋 파일 업로드";
    public static final String OPERATION_DATASET_PREVIEW = "데이터셋 미리보기";
    public static final String OPERATION_DATASET_TAG_UPDATE = "데이터셋 태그 추가";
    public static final String OPERATION_DATASET_TAG_DELETE = "데이터셋 태그 삭제";

    // ===== API 작업 상세 설명 =====
    public static final String OPERATION_DATASET_LIST_DESC = "페이징, 정렬, 검색 조건을 적용하여 데이터셋 목록을 조회합니다.";
    public static final String OPERATION_DATASET_CREATE_DESC = "새로운 데이터셋을 생성합니다.";
    public static final String OPERATION_DATASET_GET_DESC = "특정 데이터셋의 상세 정보를 조회합니다.";
    public static final String OPERATION_DATASET_UPDATE_DESC = "기존 데이터셋의 정보를 수정합니다.";
    public static final String OPERATION_DATASET_DELETE_DESC = "데이터셋을 소프트 삭제합니다.";
    public static final String OPERATION_DATASET_HARD_DELETE_DESC = "삭제된 데이터셋을 완전히 제거합니다.";
    public static final String OPERATION_DATASET_UPLOAD_DESC = "데이터셋에 파일을 업로드합니다.";
    public static final String OPERATION_DATASET_PREVIEW_DESC = "데이터셋의 일부 데이터를 미리보기로 조회합니다.";
    public static final String OPERATION_DATASET_TAG_UPDATE_DESC = "데이터셋에 태그를 추가합니다.";
    public static final String OPERATION_DATASET_TAG_DELETE_DESC = "데이터셋에서 태그를 삭제합니다.";
}
