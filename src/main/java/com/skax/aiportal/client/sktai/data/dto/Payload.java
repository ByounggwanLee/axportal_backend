package com.skax.aiportal.client.sktai.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 페이지네이션 페이로드 클래스
 */
@Getter
@NoArgsConstructor
public class Payload {
    private Pagination pagination;
}