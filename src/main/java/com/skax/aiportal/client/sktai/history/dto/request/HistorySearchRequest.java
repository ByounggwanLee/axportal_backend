package com.skax.aiportal.client.sktai.history.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 히스토리 검색 요청 DTO
 * 
 * <p>SKT AI History 플랫폼에서 사용자 활동 히스토리를 검색하기 위한 요청 정보를 담는 객체입니다.
 * 엔티티 타입, 사용자, 기간 등 다양한 조건으로 검색할 수 있습니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
@Schema(
    title = "히스토리 검색 요청",
    description = "SKT AI History 플랫폼에서 사용자 활동 히스토리를 검색하기 위한 요청 정보"
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HistorySearchRequest {

    /**
     * 엔티티 타입
     * 
     * <p>검색할 엔티티의 종류입니다.</p>
     */
    @Schema(
        description = "엔티티 타입",
        example = "AGENT_APP",
        allowableValues = {"AGENT_APP", "FEW_SHOTS", "PROMPT", "GRAPH", "MODEL"}
    )
    @JsonProperty("entity_type")
    private String entityType;

    /**
     * 엔티티 ID
     * 
     * <p>특정 엔티티의 히스토리를 조회할 때 사용하는 식별자입니다.</p>
     */
    @Schema(
        description = "엔티티 ID",
        example = "app-12345",
        maxLength = 50
    )
    @Size(max = 50, message = "엔티티 ID는 50자를 초과할 수 없습니다.")
    @JsonProperty("entity_id")
    private String entityId;

    /**
     * 액션 타입 목록
     * 
     * <p>검색할 활동 유형들입니다.</p>
     */
    @Schema(
        description = "액션 타입 목록",
        example = "[\"CREATE\", \"UPDATE\", \"DELETE\"]",
        allowableValues = {"CREATE", "UPDATE", "DELETE", "DEPLOY", "TEST"}
    )
    @JsonProperty("action_types")
    private List<String> actionTypes;

    /**
     * 사용자 ID
     * 
     * <p>특정 사용자의 활동만 검색할 때 사용합니다.</p>
     */
    @Schema(
        description = "사용자 ID",
        example = "user@example.com",
        maxLength = 100
    )
    @Size(max = 100, message = "사용자 ID는 100자를 초과할 수 없습니다.")
    @JsonProperty("user_id")
    private String userId;

    /**
     * 검색 시작 날짜
     * 
     * <p>히스토리 검색 시작 날짜입니다. (ISO 8601 형식)</p>
     */
    @Schema(
        description = "검색 시작 날짜 (ISO 8601 형식)",
        example = "2025-01-01T00:00:00Z",
        format = "date-time"
    )
    @JsonProperty("start_date")
    private String startDate;

    /**
     * 검색 종료 날짜
     * 
     * <p>히스토리 검색 종료 날짜입니다. (ISO 8601 형식)</p>
     */
    @Schema(
        description = "검색 종료 날짜 (ISO 8601 형식)",
        example = "2025-12-31T23:59:59Z",
        format = "date-time"
    )
    @JsonProperty("end_date")
    private String endDate;

    /**
     * 검색 텍스트
     * 
     * <p>히스토리 내용에서 검색할 키워드입니다.</p>
     */
    @Schema(
        description = "검색 키워드",
        example = "AI 모델 업데이트",
        maxLength = 200
    )
    @Size(max = 200, message = "검색 텍스트는 200자를 초과할 수 없습니다.")
    @JsonProperty("search_text")
    private String searchText;

    /**
     * 태그 목록
     * 
     * <p>특정 태그가 포함된 히스토리를 검색할 때 사용합니다.</p>
     */
    @Schema(
        description = "검색할 태그 목록",
        example = "[\"production\", \"ai-model\"]"
    )
    @JsonProperty("tags")
    private List<String> tags;

    @JsonProperty("page")
    private Integer page;

    @JsonProperty("size")
    private Integer size;

    @JsonProperty("sort_by")
    private String sortBy;

    @JsonProperty("sort_direction")
    private String sortDirection;

    @JsonProperty("include_details")
    private Boolean includeDetails;
}
