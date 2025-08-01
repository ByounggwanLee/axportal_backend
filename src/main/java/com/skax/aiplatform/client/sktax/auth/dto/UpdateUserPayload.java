package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 사용자 정보 수정 Payload DTO
 * 
 * <p>OpenAPI 스키마명: UpdateUserPayload</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "사용자 정보 수정 Payload")
public class UpdateUserPayload {

    @JsonProperty("email")
    @Schema(description = "이메일")
    private String email;

    @JsonProperty("first_name")
    @Schema(description = "이름")
    private String firstName;

    @JsonProperty("last_name")
    @Schema(description = "성")
    private String lastName;
}
