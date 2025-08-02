package com.skax.aiplatform.client.sktax.resource.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.resource.dto.ClusterResource;
import com.skax.aiplatform.client.sktax.resource.dto.NodeResource;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 클러스터 리소스 응답
 * 
 * <p>클러스터 리소스 조회 결과를 담는 응답 객체입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "클러스터 리소스 응답")
public class ClusterResourceRes {

    /**
     * 노드 리소스 목록
     */
    @JsonProperty("node_resource")
    @Schema(description = "노드 리소스 목록")
    private List<NodeResource> nodeResource;

    /**
     * 클러스터 리소스
     */
    @JsonProperty("cluster_resource")
    @Schema(description = "클러스터 리소스")
    private ClusterResource clusterResource;
}
