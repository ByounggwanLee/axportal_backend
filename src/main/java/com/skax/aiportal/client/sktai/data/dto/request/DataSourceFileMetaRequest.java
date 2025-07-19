package com.skax.aiportal.client.sktai.data.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

/**
 * 데이터소스 파일 메타데이터 업데이트 요청 DTO
 * 
 * <p>SKT AI 플랫폼의 데이터소스 파일 메타데이터 업데이트 요청 정보를 담는 클래스입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@Builder
@Jacksonized
public class DataSourceFileMetaRequest {

    /**
     * 파일 메타데이터
     */
    @JsonProperty("file_metadata")
    private Object fileMetadata;
}
