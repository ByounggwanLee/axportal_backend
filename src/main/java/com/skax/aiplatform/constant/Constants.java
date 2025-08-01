package com.skax.aiplatform.constant;

/**
 * 애플리케이션 전역 상수 정의 클래스
 * 
 * <p>프로젝트에서 사용되는 모든 상수들을 중앙 집중 관리합니다.
 * Magic Number 사용을 방지하고 코드의 가독성을 향상시킵니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
public final class Constants {

    private Constants() {
        // 유틸리티 클래스는 인스턴스화 방지
    }

    /**
     * API 관련 상수
     */
    public static final class Api {
        public static final String BASE_PATH = "/api/v1";
        public static final String HEALTH_CHECK = "/health";
        public static final String SWAGGER_PATH = "/swagger-ui.html";
        public static final String API_DOCS_PATH = "/api-docs";
        
        private Api() {}
    }

    /**
     * 보안 관련 상수
     */
    public static final class Security {
        public static final String AUTHORIZATION_HEADER = "Authorization";
        public static final String BEARER_PREFIX = "Bearer ";
        public static final String JWT_CLAIM_USER_ID = "userId";
        public static final String JWT_CLAIM_USER_EMAIL = "userEmail";
        public static final String JWT_CLAIM_AUTHORITIES = "authorities";
        
        private Security() {}
    }

    /**
     * 페이징 관련 상수
     */
    public static final class Pagination {
        public static final int DEFAULT_PAGE_SIZE = 20;
        public static final int MAX_PAGE_SIZE = 100;
        public static final String DEFAULT_SORT_DIRECTION = "desc";
        public static final String DEFAULT_SORT_PROPERTY = "createdAt";
        
        private Pagination() {}
    }

    /**
     * 응답 메시지 상수
     */
    public static final class Message {
        public static final String SUCCESS = "성공";
        public static final String CREATED = "생성 완료";
        public static final String UPDATED = "수정 완료";
        public static final String DELETED = "삭제 완료";
        public static final String NOT_FOUND = "데이터를 찾을 수 없습니다";
        public static final String UNAUTHORIZED = "인증이 필요합니다";
        public static final String FORBIDDEN = "접근 권한이 없습니다";
        public static final String BAD_REQUEST = "잘못된 요청입니다";
        public static final String INTERNAL_SERVER_ERROR = "서버 내부 오류가 발생했습니다";
        
        private Message() {}
    }

    /**
     * 데이터베이스 관련 상수
     */
    public static final class Database {
        public static final int DEFAULT_STRING_LENGTH = 255;
        public static final int LARGE_TEXT_LENGTH = 1000;
        public static final int EMAIL_LENGTH = 100;
        public static final int NAME_LENGTH = 50;
        public static final int CODE_LENGTH = 20;
        
        private Database() {}
    }

    /**
     * 캐시 관련 상수
     */
    public static final class Cache {
        public static final String USER_CACHE = "users";
        public static final String ROLE_CACHE = "roles";
        public static final int DEFAULT_TTL_SECONDS = 3600; // 1시간
        public static final int LONG_TTL_SECONDS = 86400; // 24시간
        
        private Cache() {}
    }

    /**
     * 날짜/시간 관련 상수
     */
    public static final class DateTime {
        public static final String DATE_FORMAT = "yyyy-MM-dd";
        public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
        public static final String ISO_DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
        public static final String TIMEZONE_KST = "Asia/Seoul";
        public static final String TIMEZONE_UTC = "UTC";
        
        private DateTime() {}
    }

    /**
     * 파일 관련 상수
     */
    public static final class File {
        public static final long MAX_FILE_SIZE = 10 * 1024 * 1024; // 10MB
        public static final String[] ALLOWED_IMAGE_EXTENSIONS = {"jpg", "jpeg", "png", "gif"};
        public static final String[] ALLOWED_DOCUMENT_EXTENSIONS = {"pdf", "doc", "docx", "xls", "xlsx"};
        
        private File() {}
    }

    /**
     * 정규식 패턴 상수
     */
    public static final class Pattern {
        public static final String EMAIL = "^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+\\.[A-Za-z]{2,})$";
        public static final String PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        public static final String PHONE = "^\\d{2,3}-\\d{3,4}-\\d{4}$";
        public static final String KOREAN_NAME = "^[가-힣]{2,10}$";
        
        private Pattern() {}
    }
}
