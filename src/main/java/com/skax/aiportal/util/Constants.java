package com.skax.aiportal.util;

/**
 * 애플리케이션 상수 클래스
 * 
 * <p>애플리케이션 전반에서 사용되는 상수들을 정의합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
public final class Constants {

    // 생성자를 private으로 설정하여 인스턴스화 방지
    private Constants() {
        throw new UnsupportedOperationException("유틸리티 클래스는 인스턴스화할 수 없습니다.");
    }

    /**
     * API 관련 상수
     */
    public static final class Api {
        public static final String VERSION_V1 = "/v1";
        public static final String BASE_PATH = "/api" + VERSION_V1;
        public static final String HEALTH_PATH = "/health";
        public static final String AUTH_PATH = "/auth";
        public static final String USERS_PATH = "/users";
        
        private Api() {}
    }

    /**
     * 페이징 관련 상수
     */
    public static final class Pagination {
        public static final int DEFAULT_PAGE = 0;
        public static final int DEFAULT_SIZE = 20;
        public static final int MAX_SIZE = 100;
        public static final String DEFAULT_SORT = "createdAt";
        public static final String DEFAULT_DIRECTION = "desc";
        
        private Pagination() {}
    }

    /**
     * 보안 관련 상수
     */
    public static final class Security {
        public static final String BEARER_PREFIX = "Bearer ";
        public static final String AUTHORIZATION_HEADER = "Authorization";
        public static final String ROLE_PREFIX = "ROLE_";
        public static final String ROLE_USER = "USER";
        public static final String ROLE_ADMIN = "ADMIN";
        
        private Security() {}
    }

    /**
     * JWT 관련 상수
     */
    public static final class Jwt {
        public static final String TOKEN_TYPE = "JWT";
        public static final String ISSUER = "axportal-backend";
        public static final String CLAIM_USER_ID = "userId";
        public static final String CLAIM_USERNAME = "username";
        public static final String CLAIM_ROLES = "roles";
        public static final long ACCESS_TOKEN_EXPIRE_TIME = 30 * 60 * 1000L; // 30분
        public static final long REFRESH_TOKEN_EXPIRE_TIME = 7 * 24 * 60 * 60 * 1000L; // 7일
        
        private Jwt() {}
    }

    /**
     * 메시지 관련 상수
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
        public static final String INTERNAL_ERROR = "서버 내부 오류가 발생했습니다";
        
        private Message() {}
    }

    /**
     * 검증 관련 상수
     */
    public static final class Validation {
        public static final int MIN_PASSWORD_LENGTH = 8;
        public static final int MAX_PASSWORD_LENGTH = 20;
        public static final int MAX_EMAIL_LENGTH = 100;
        public static final int MAX_USERNAME_LENGTH = 50;
        public static final int MAX_NAME_LENGTH = 100;
        public static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        public static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]";
        
        private Validation() {}
    }

    /**
     * 캐시 관련 상수
     */
    public static final class Cache {
        public static final String USERS = "users";
        public static final String USER_PROFILE = "userProfile";
        public static final String AUTHORITIES = "authorities";
        public static final long DEFAULT_TTL = 300; // 5분
        public static final long USER_TTL = 600; // 10분
        
        private Cache() {}
    }

    /**
     * 날짜/시간 관련 상수
     */
    public static final class DateTime {
        public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
        public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
        public static final String ISO_DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
        public static final String TIMEZONE = "Asia/Seoul";
        
        private DateTime() {}
    }

    /**
     * 파일 관련 상수
     */
    public static final class File {
        public static final long MAX_FILE_SIZE = 10 * 1024 * 1024; // 10MB
        public static final String[] ALLOWED_IMAGE_EXTENSIONS = {"jpg", "jpeg", "png", "gif"};
        public static final String[] ALLOWED_DOCUMENT_EXTENSIONS = {"pdf", "doc", "docx", "xls", "xlsx", "ppt", "pptx"};
        public static final String UPLOAD_PATH = "/uploads";
        
        private File() {}
    }
}
