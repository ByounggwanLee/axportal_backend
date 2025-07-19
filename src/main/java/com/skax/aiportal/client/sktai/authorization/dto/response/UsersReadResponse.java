package com.skax.aiportal.client.sktai.authorization.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.skax.aiportal.client.sktai.authorization.dto.PayloadInfo;

import java.util.List;

/**
 * SKT AI 사용자 관련 DTO 모음
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */

/**
 * 사용자 목록 조회 응답 DTO
 */
@Schema(description = "사용자 목록 조회 응답")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersReadResponse {

    @Schema(description = "사용자 데이터 목록")
    @JsonProperty("data")
    private List<UserResponse> data;

    @Schema(description = "페이징 정보")
    @JsonProperty("payload")
    private PayloadInfo payload;

}
