-- AXPORTAL BACKEND 초기 데이터
-- 개발 환경에서 사용할 테스트 데이터를 정의합니다.

-- 샘플 테이블 초기 데이터
INSERT INTO samples (title, content, active, status, view_count, created_at, updated_at, created_by, updated_by) VALUES 
('첫 번째 샘플', '이것은 첫 번째 샘플 내용입니다. 개발 및 테스트를 위한 데이터입니다.', true, 'PUBLISHED', 150, NOW(), NOW(), 'admin', 'admin'),
('두 번째 샘플', '이것은 두 번째 샘플 내용입니다. 더 많은 내용을 포함하고 있습니다.', true, 'PUBLISHED', 89, NOW(), NOW(), 'admin', 'admin'),
('초안 샘플', '아직 작성 중인 초안 상태의 샘플입니다.', true, 'DRAFT', 5, NOW(), NOW(), 'admin', 'admin'),
('보관된 샘플', '더 이상 사용하지 않는 보관된 샘플입니다.', false, 'ARCHIVED', 200, NOW(), NOW(), 'admin', 'admin'),
('인기 샘플', '가장 많이 조회된 인기 샘플입니다. 유용한 정보가 많이 포함되어 있습니다.', true, 'PUBLISHED', 350, NOW(), NOW(), 'admin', 'admin');

-- 사용자 테이블 초기 데이터 (추후 실제 테이블 생성 시 활용)
-- INSERT INTO users (username, email, password, created_at, updated_at) VALUES 
-- ('admin', 'admin@axportal.com', '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2uheWG/igi.', NOW(), NOW()),
-- ('user1', 'user1@axportal.com', '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2uheWG/igi.', NOW(), NOW());

-- 권한 테이블 초기 데이터
-- INSERT INTO roles (name, description, created_at, updated_at) VALUES 
-- ('ROLE_ADMIN', '관리자 권한', NOW(), NOW()),
-- ('ROLE_USER', '일반 사용자 권한', NOW(), NOW());

-- 사용자-권한 매핑 테이블 초기 데이터
-- INSERT INTO user_roles (user_id, role_id) VALUES 
-- (1, 1),
-- (2, 2);
