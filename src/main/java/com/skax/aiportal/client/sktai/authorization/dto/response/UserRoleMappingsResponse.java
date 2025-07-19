package com.skax.aiportal.client.sktai.authorization.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiportal.client.sktai.authorization.dto.PayloadInfo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * SKT AI 사용자 역할 매핑 응답 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Schema(description = "사용자 역할 매핑 응답")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleMappingsResponse {

    @Schema(description = "프로젝트 역할 데이터 목록")
    @JsonProperty("data")
    private List<ProjectRolesResponse> data;

    @Schema(description = "페이징 정보")
    @JsonProperty("payload")
    private PayloadInfo payload;
}
