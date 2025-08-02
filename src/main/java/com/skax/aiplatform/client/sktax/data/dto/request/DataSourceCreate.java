package com.skax.aiplatform.client.sktax.data.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skax.aiplatform.client.sktax.data.dto.DatasourceTypeEnum;
import com.skax.aiplatform.client.sktax.data.dto.DatasourceScopeEnum;
import com.skax.aiplatform.client.sktax.data.dto.S3Config;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 데이터소스 생성 요청 DTO
 * 
 * <p>새로운 데이터소스를 생성할 때 사용하는 요청 모델입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-01-21
 * @version 1.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataSourceCreate {

    /**
     * 프로젝트 ID
     */
    @JsonProperty("project_id")
    private String projectId;

    /**
     * 데이터소스명 (필수)
     */
    @JsonProperty("name")
    private String name;

    /**
     * 데이터소스 타입 (기본값: file)
     */
    @JsonProperty("type")
    @Builder.Default
    private DatasourceTypeEnum type = DatasourceTypeEnum.FILE;

    /**
     * 설명 (기본값: "")
     */
    @JsonProperty("description")
    @Builder.Default
    private String description = "";

    /**
     * S3 설정
     */
    @JsonProperty("s3_config")
    private S3Config s3Config;

    /**
     * 범위 (기본값: public)
     */
    @JsonProperty("scope")
    @Builder.Default
    private DatasourceScopeEnum scope = DatasourceScopeEnum.PUBLIC;
}
