package com.skax.aiportal.client.sktai.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 페이지네이션 링크 클래스
 */
@Getter
@NoArgsConstructor
public class PaginationLink {
    private String url;
    private String label;
    private boolean active;
    private Integer page;
}
