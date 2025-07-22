package com.skax.aiportal.client.sktai.history.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistoryListResponse {

    @JsonProperty("histories")
    private List<HistoryResponse> histories;

    @JsonProperty("total_count")
    private Integer totalCount;

    @JsonProperty("page")
    private Integer page;

    @JsonProperty("size")
    private Integer size;

    @JsonProperty("total_pages")
    private Integer totalPages;

    @JsonProperty("search_summary")
    private SearchSummary searchSummary;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchSummary {

        @JsonProperty("entity_types")
        private List<EntityTypeSummary> entityTypes;

        @JsonProperty("action_types")
        private List<ActionTypeSummary> actionTypes;

        @JsonProperty("users")
        private List<UserSummary> users;

        @JsonProperty("date_range")
        private DateRange dateRange;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EntityTypeSummary {

        @JsonProperty("entity_type")
        private String entityType;

        @JsonProperty("count")
        private Integer count;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ActionTypeSummary {

        @JsonProperty("action_type")
        private String actionType;

        @JsonProperty("count")
        private Integer count;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserSummary {

        @JsonProperty("user_id")
        private String userId;

        @JsonProperty("user_name")
        private String userName;

        @JsonProperty("count")
        private Integer count;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DateRange {

        @JsonProperty("start_date")
        private String startDate;

        @JsonProperty("end_date")
        private String endDate;
    }
}
