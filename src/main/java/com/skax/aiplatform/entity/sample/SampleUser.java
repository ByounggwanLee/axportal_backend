package com.skax.aiplatform.entity.sample;

import com.skax.aiplatform.entity.common.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * 샘플 사용자 엔티티
 * 
 * <p>샘플 프로젝트의 사용자 정보를 나타내는 엔티티입니다.
 * 기본적인 CRUD 작업의 예시를 보여줍니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
@Entity
@Table(name = "sample_users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class SampleUser extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", unique = true, nullable = false, length = 50)
    @NotBlank(message = "사용자명은 필수입니다")
    @Size(min = 3, max = 50, message = "사용자명은 3-50자 사이여야 합니다")
    private String username;

    @Column(name = "email", unique = true, nullable = false, length = 100)
    @NotBlank(message = "이메일은 필수입니다")
    @Size(max = 100, message = "이메일은 100자 이하여야 합니다")
    private String email;

    @Column(name = "password", nullable = false)
    @NotBlank(message = "패스워드는 필수입니다")
    private String password;

    @Column(name = "full_name", length = 100)
    @Size(max = 100, message = "전체 이름은 100자 이하여야 합니다")
    private String fullName;

    @Column(name = "phone", length = 20)
    @Size(max = 20, message = "전화번호는 20자 이하여야 합니다")
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    @Builder.Default
    private UserStatus status = UserStatus.ACTIVE;

    @Column(name = "age")
    private Integer age;

    /**
     * 사용자 상태 열거형
     */
    public enum UserStatus {
        ACTIVE("활성"),
        INACTIVE("비활성"),
        SUSPENDED("정지"),
        DELETED("삭제");

        private final String description;

        UserStatus(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    /**
     * 사용자 정보 업데이트
     * 
     * @param fullName 전체 이름
     * @param phone 전화번호
     * @param age 나이
     */
    public void updateUserInfo(String fullName, String phone, Integer age) {
        this.fullName = fullName;
        this.phone = phone;
        this.age = age;
    }

    /**
     * 사용자 상태 변경
     * 
     * @param status 새로운 상태
     */
    public void changeStatus(UserStatus status) {
        this.status = status;
    }

    /**
     * 패스워드 변경
     * 
     * @param newPassword 새로운 패스워드 (암호화된)
     */
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }
}
