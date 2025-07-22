package com.skax.aiportal.client.sktai.agent.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiportal.client.sktai.agent.dto.request.FewShotsCreateRequest.FewShotsItem;
import com.skax.aiportal.client.sktai.agent.dto.request.FewShotsCreateRequest.FewShotsTag;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * FewShots 수정 요청 DTO
 *
 * @author ByounggwanLee
 * @since 2025-07-22
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FewShotsUpdateRequest {

    /**
     * 새로운 FewShot 이름
     */
    @JsonProperty("new_name")
    private String newName;

    /**
     * 릴리즈 플래그
     */
    @Builder.Default
    private Boolean release = false;

    /**
     * FewShot 아이템 목록
     */
    private List<FewShotsItem> items;

    /**
     * FewShot 태그 목록
     */
    private List<FewShotsTag> tags;
}
