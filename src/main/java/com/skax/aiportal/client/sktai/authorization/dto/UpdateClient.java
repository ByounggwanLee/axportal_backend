package com.skax.aiportal.client.sktai.authorization.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 클라이언트 수정 요청 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateClient {

    private UpdateProject project;
    private UpdateNamespace namespace;
}

/**
 * 프로젝트 수정 정보
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
class UpdateProject {
    private String name;
}

/**
 * 네임스페이스 수정 정보
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
class UpdateNamespace {
    private Double cpuQuota;
    private Double memQuota;
    private Double gpuQuota;
}
