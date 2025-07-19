package com.skax.aiportal.client.sktai.authorization.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 클라이언트 생성 요청 DTO
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateClient {

    private CreateProject project;
    private CreateNamespace namespace;
}

/**
 * 프로젝트 생성 정보
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
class CreateProject {
    private String name;
}

/**
 * 네임스페이스 생성 정보
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
class CreateNamespace {
    private Double cpuQuota;
    private Double memQuota;
    private Double gpuQuota;
    private String privateVolumeName;
}
