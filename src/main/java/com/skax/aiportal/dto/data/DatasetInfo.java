package com.skax.aiportal.dto.data;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 애플리케이션용 데이터셋 정보 DTO
 * 
 * <p>애플리케이션 계층에서 사용하는 데이터셋 정보를 담는 DTO입니다.
 * Client DTO와 독립적으로 설계되어 애플리케이션의 요구사항에 맞게 구성됩니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-07-24
 * @version 1.0
 */
@Schema(description = "애플리케이션용 데이터셋 정보")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DatasetInfo {

    /**
     * 데이터셋 ID
     */
    @Schema(description = "데이터셋 고유 식별자", example = "dataset-12345")
    private String id;

    /**
     * 데이터셋 이름
     */
    @Schema(description = "데이터셋 이름", example = "고객 데이터셋")
    private String name;

    /**
     * 데이터셋 타입
     */
    @Schema(description = "데이터셋 타입", example = "TABLE")
    private String type;

    /**
     * 데이터셋 설명
     */
    @Schema(description = "데이터셋 설명", example = "고객 정보를 담은 데이터셋입니다.")
    private String description;

    /**
     * 데이터셋 태그 목록
     */
    @Schema(description = "데이터셋 태그 목록", example = "[\"ML\", \"고객분석\"]")
    private List<String> tags;

    /**
     * 데이터셋 상태
     */
    @Schema(description = "데이터셋 상태", example = "ACTIVE")
    private String status;

    /**
     * 프로젝트 ID
     */
    @Schema(description = "프로젝트 ID", example = "project-123")
    @JsonProperty("project_id")
    private String projectId;

    /**
     * 삭제 여부
     */
    @Schema(description = "삭제 여부", example = "false")
    @JsonProperty("is_deleted")
    private Boolean isDeleted;

    /**
     * 생성일시
     */
    @Schema(description = "생성일시", example = "2025-07-24T10:30:00")
    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    /**
     * 수정일시
     */
    @Schema(description = "수정일시", example = "2025-07-24T15:45:00")
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    /**
     * 생성자
     */
    @Schema(description = "생성자", example = "user123")
    @JsonProperty("created_by")
    private String createdBy;

    /**
     * 수정자
     */
    @Schema(description = "수정자", example = "user456")
    @JsonProperty("updated_by")
    private String updatedBy;

    /**
     * 데이터소스 ID
     */
    @Schema(description = "데이터소스 ID", example = "datasource-789")
    @JsonProperty("datasource_id")
    private String datasourceId;

    /**
     * 데이터소스 파일 목록
     */
    @Schema(description = "데이터소스 파일 목록", example = "[\"file1.csv\", \"file2.json\"]")
    @JsonProperty("datasource_files")
    private List<String> datasourceFiles;

    /**
     * 파일 경로
     */
    @Schema(description = "파일 경로", example = "/data/datasets/dataset-12345")
    @JsonProperty("file_path")
    private String filePath;
}
