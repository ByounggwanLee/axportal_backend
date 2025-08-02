package com.skax.aiplatform.client.sktax.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * OpenAPI 명세: GroupsRead
 * 그룹 목록 조회 응답
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupsRead {

    @JsonProperty("data")
    private List<GroupBase> data;

    @JsonProperty("payload")
    private Payload payload;
}
