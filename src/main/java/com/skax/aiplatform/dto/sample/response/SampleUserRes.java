package com.skax.aiplatform.dto.sample.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.skax.aiplatform.entity.sample.SampleUser;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 샘플 사용자 응답 DTO
 * 
 * <p>사용자 정보를 클라이언트에게 반환할 때 사용하는 응답 데이터 전송 객체입니다.
 * 보안상 패스워드는 제외됩니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "샘플 사용자 응답")
public class SampleUserRes {

    @Schema(description = "사용자 ID", example = "1")
    private Long id;

    @Schema(description = "사용자명", example = "john_doe")
    private String username;

    @Schema(description = "이메일", example = "john.doe@example.com")
    private String email;

    @Schema(description = "전체 이름", example = "John Doe")
    private String fullName;

    @Schema(description = "전화번호", example = "010-1234-5678")
    private String phone;

    @Schema(description = "나이", example = "30")
    private Integer age;

    @Schema(description = "사용자 상태", example = "ACTIVE")
    private SampleUser.UserStatus status;

    @Schema(description = "상태 설명", example = "활성")
    private String statusDescription;

    @Schema(description = "생성일시", example = "2025-08-01T10:30:00")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;

    @Schema(description = "수정일시", example = "2025-08-01T10:30:00")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedAt;

    @Schema(description = "생성자", example = "admin")
    private String createdBy;

    @Schema(description = "수정자", example = "admin")
    private String updatedBy;
}
