package com.skax.aiportal.client.sktai.data.dto.response;

import java.util.List;

import com.skax.aiportal.client.sktai.data.dto.Payload;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 데이터셋 목록 응답 DTO
 * 
 * <p>SKT AI 플랫폼에서 데이터셋 목록을 반환할 때 사용하는 응답 데이터입니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Getter
@NoArgsConstructor
public class DatasetListResponse {

    /**
     * 데이터셋 목록
     */
    private List<DatasetResponse> data;

    /**
     * 페이지네이션 정보
     */
    private Payload payload;
}
