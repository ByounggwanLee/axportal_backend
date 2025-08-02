package com.skax.aiplatform.client.sktax.resource;

import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import com.skax.aiplatform.client.sktax.resource.dto.request.NamespaceCreateReq;
import com.skax.aiplatform.client.sktax.resource.dto.request.ResourceCheckReq;
import com.skax.aiplatform.client.sktax.resource.dto.response.ClusterResourceRes;
import com.skax.aiplatform.client.sktax.resource.dto.response.NamespaceListRes;
import com.skax.aiplatform.client.sktax.resource.dto.response.ResourceCheckRes;
import com.skax.aiplatform.client.sktax.resource.dto.response.TaskResourceRes;
import com.skax.aiplatform.client.sktax.resource.dto.Namespace;
import com.skax.aiplatform.client.sktax.resource.dto.NamespaceDetail;
import com.skax.aiplatform.client.sktax.resource.dto.NamespaceBase;
import com.skax.aiplatform.client.sktax.resource.dto.ResourcePolicyPublic;
import com.skax.aiplatform.client.sktax.resource.dto.TaskQuotaBase;
import com.skax.aiplatform.client.sktax.resource.dto.TaskQuotaPublic;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Resource Management API Feign Client
 * 
 * <p>SKTAX Resource Management 서비스와의 통신을 위한 Feign Client 인터페이스입니다.
 * 클러스터 리소스, 태스크 리소스, 네임스페이스 관리 등의 기능을 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@FeignClient(
    name = "resource-client",
    url = "${sktax.resource.url:https://aip-stg.sktai.io}",
    configuration = SktAxFeignConfig.class
)
@Tag(name = "Resource Management", description = "Resource Management API")
public interface ResourceClient {

    /**
     * 클러스터 리소스 조회
     * 
     * <p>클러스터의 전체 리소스 정보를 조회합니다.</p>
     * 
     * @param nodeType 노드 타입 (선택사항)
     * @return 클러스터 리소스 정보
     */
    @GetMapping(
        value = "/api/v1/resources/cluster",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "클러스터 리소스 조회",
        description = "클러스터의 전체 리소스 정보를 조회합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "클러스터 리소스 조회 성공",
            content = @Content(schema = @Schema(implementation = ClusterResourceRes.class))
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        )
    })
    ClusterResourceRes getClusterResource(
        @Parameter(description = "노드 타입")
        @RequestParam(value = "node_type", required = false) String nodeType
    );

    /**
     * 태스크 리소스 조회
     * 
     * <p>태스크 실행 전 리소스 정보를 조회합니다.</p>
     * 
     * @param taskType 태스크 타입
     * @param projectId 프로젝트 ID
     * @return 태스크 리소스 정보
     */
    @GetMapping(
        value = "/api/v1/resources/task/{task_type}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "태스크 리소스 조회",
        description = "태스크 실행 전 리소스 정보를 조회합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "태스크 리소스 조회 성공",
            content = @Content(schema = @Schema(implementation = TaskResourceRes.class))
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        )
    })
    TaskResourceRes getTaskResource(
        @Parameter(description = "태스크 타입", required = true)
        @PathVariable("task_type") String taskType,
        
        @Parameter(description = "프로젝트 ID", required = true)
        @RequestParam("project_id") String projectId
    );

    /**
     * 태스크 리소스 확인
     * 
     * <p>태스크 실행 시 리소스를 확인합니다.</p>
     * 
     * @param taskType 태스크 타입
     * @param projectId 프로젝트 ID
     * @param request 리소스 확인 요청
     * @return 리소스 확인 결과
     */
    @PostMapping(
        value = "/api/v1/resources/task/{task_type}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "태스크 리소스 확인",
        description = "태스크 실행 시 리소스를 확인합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "리소스 확인 성공",
            content = @Content(schema = @Schema(implementation = ResourceCheckRes.class))
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        )
    })
    ResourceCheckRes checkTaskResource(
        @Parameter(description = "태스크 타입", required = true)
        @PathVariable("task_type") String taskType,
        
        @Parameter(description = "프로젝트 ID", required = true)
        @RequestParam("project_id") String projectId,
        
        @Parameter(description = "리소스 확인 요청", required = true)
        @Valid @RequestBody ResourceCheckReq request
    );

    /**
     * 태스크 정책 목록 조회
     * 
     * <p>태스크 정책 전체 목록을 조회합니다.</p>
     * 
     * @return 태스크 정책 목록
     */
    @GetMapping(
        value = "/api/v1/resources/task_policy",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "태스크 정책 목록 조회",
        description = "태스크 정책 전체 목록을 조회합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "태스크 정책 조회 성공",
            content = @Content(schema = @Schema(implementation = List.class))
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        )
    })
    List<ResourcePolicyPublic> getTaskPolicies();

    /**
     * 태스크 정책 수정
     * 
     * <p>태스크 정책을 수정합니다.</p>
     * 
     * @param policies 수정할 태스크 정책 목록
     * @return 수정된 태스크 정책 목록
     */
    @PutMapping(
        value = "/api/v1/resources/task_policy",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "태스크 정책 수정",
        description = "태스크 정책을 수정합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "태스크 정책 수정 성공",
            content = @Content(schema = @Schema(implementation = List.class))
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        )
    })
    List<ResourcePolicyPublic> updateTaskPolicies(
        @Parameter(description = "수정할 태스크 정책 목록", required = true)
        @Valid @RequestBody List<ResourcePolicyPublic> policies
    );

    /**
     * 태스크 정책 등록
     * 
     * <p>새로운 태스크 정책을 등록합니다.</p>
     * 
     * @param policies 등록할 태스크 정책 목록
     * @return 등록된 태스크 정책 목록
     */
    @PostMapping(
        value = "/api/v1/resources/task_policy",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "태스크 정책 등록",
        description = "새로운 태스크 정책을 등록합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "201",
            description = "태스크 정책 등록 성공",
            content = @Content(schema = @Schema(implementation = List.class))
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        )
    })
    List<ResourcePolicyPublic> addTaskPolicies(
        @Parameter(description = "등록할 태스크 정책 목록", required = true)
        @Valid @RequestBody List<ResourcePolicyPublic> policies
    );

    /**
     * 태스크 정책 삭제
     * 
     * <p>지정된 태스크 타입의 정책을 삭제합니다.</p>
     * 
     * @param taskType 삭제할 태스크 타입
     */
    @DeleteMapping(
        value = "/api/v1/resources/task_policy/{task_type}"
    )
    @Operation(
        summary = "태스크 정책 삭제",
        description = "지정된 태스크 타입의 정책을 삭제합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "204",
            description = "태스크 정책 삭제 성공"
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        )
    })
    void deleteTaskPolicy(
        @Parameter(description = "삭제할 태스크 타입", required = true)
        @PathVariable("task_type") String taskType
    );

    /**
     * 태스크 할당량 조회
     * 
     * <p>태스크별 할당량 설정을 조회합니다.</p>
     * 
     * @return 태스크 할당량 정보
     */
    @GetMapping(
        value = "/api/v1/resources/task_quota",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "태스크 할당량 조회",
        description = "태스크별 할당량 설정을 조회합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "태스크 할당량 조회 성공",
            content = @Content(schema = @Schema(implementation = TaskQuotaPublic.class))
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        )
    })
    TaskQuotaPublic getTaskQuota();

    /**
     * 태스크 할당량 수정
     * 
     * <p>태스크별 할당량 설정을 수정합니다.</p>
     * 
     * @param quotas 수정할 태스크 할당량 목록
     * @return 수정된 태스크 할당량 목록
     */
    @PutMapping(
        value = "/api/v1/resources/task_quota",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "태스크 할당량 수정",
        description = "태스크별 할당량 설정을 수정합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "태스크 할당량 수정 성공",
            content = @Content(schema = @Schema(implementation = List.class))
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        )
    })
    List<TaskQuotaBase> updateTaskQuota(
        @Parameter(description = "수정할 태스크 할당량 목록", required = true)
        @Valid @RequestBody List<TaskQuotaBase> quotas
    );

    /**
     * 태스크 할당량 등록
     * 
     * <p>새로운 태스크 할당량을 등록합니다.</p>
     * 
     * @param quotas 등록할 태스크 할당량 목록
     * @return 등록된 태스크 할당량 목록
     */
    @PostMapping(
        value = "/api/v1/resources/task_quota",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "태스크 할당량 등록",
        description = "새로운 태스크 할당량을 등록합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "201",
            description = "태스크 할당량 등록 성공",
            content = @Content(schema = @Schema(implementation = List.class))
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        )
    })
    List<TaskQuotaBase> addTaskQuota(
        @Parameter(description = "등록할 태스크 할당량 목록", required = true)
        @Valid @RequestBody List<TaskQuotaBase> quotas
    );

    /**
     * 태스크 할당량 삭제
     * 
     * <p>태스크별 할당량 설정을 삭제합니다.</p>
     */
    @DeleteMapping(
        value = "/api/v1/resources/task_quota"
    )
    @Operation(
        summary = "태스크 할당량 삭제",
        description = "태스크별 할당량 설정을 삭제합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "204",
            description = "태스크 할당량 삭제 성공"
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        )
    })
    void deleteTaskQuota();

    /**
     * 네임스페이스 목록 조회
     * 
     * <p>네임스페이스 목록을 조회합니다.</p>
     * 
     * @param projectId 프로젝트 ID (선택사항)
     * @return 네임스페이스 목록
     */
    @GetMapping(
        value = "/api/v1/namespaces",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "네임스페이스 목록 조회",
        description = "네임스페이스 목록을 조회합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "네임스페이스 목록 조회 성공",
            content = @Content(schema = @Schema(implementation = NamespaceListRes.class))
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        )
    })
    NamespaceListRes getNamespaces(
        @Parameter(description = "프로젝트 ID")
        @RequestParam(value = "project_id", required = false) String projectId
    );

    /**
     * 네임스페이스 생성
     * 
     * <p>새로운 네임스페이스를 생성합니다.</p>
     * 
     * @param request 네임스페이스 생성 요청
     * @return 생성된 네임스페이스 정보
     */
    @PostMapping(
        value = "/api/v1/namespaces",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "네임스페이스 생성",
        description = "새로운 네임스페이스를 생성합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "201",
            description = "네임스페이스 생성 성공",
            content = @Content(schema = @Schema(implementation = Namespace.class))
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        )
    })
    Namespace createNamespace(
        @Parameter(description = "네임스페이스 생성 요청", required = true)
        @Valid @RequestBody NamespaceCreateReq request
    );

    /**
     * 네임스페이스 정보 조회
     * 
     * <p>지정된 네임스페이스의 상세 정보를 조회합니다.</p>
     * 
     * @param namespaceId 네임스페이스 ID
     * @return 네임스페이스 상세 정보
     */
    @GetMapping(
        value = "/api/v1/namespaces/{namespace_id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "네임스페이스 정보 조회",
        description = "지정된 네임스페이스의 상세 정보를 조회합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "네임스페이스 정보 조회 성공",
            content = @Content(schema = @Schema(implementation = NamespaceDetail.class))
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        )
    })
    NamespaceDetail getNamespace(
        @Parameter(description = "네임스페이스 ID", required = true)
        @PathVariable("namespace_id") String namespaceId
    );

    /**
     * 네임스페이스 수정
     * 
     * <p>지정된 네임스페이스를 수정합니다.</p>
     * 
     * @param namespaceId 네임스페이스 ID
     * @param request 네임스페이스 수정 요청
     * @return 수정된 네임스페이스 정보
     */
    @PutMapping(
        value = "/api/v1/namespaces/{namespace_id}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "네임스페이스 수정",
        description = "지정된 네임스페이스를 수정합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "네임스페이스 수정 성공",
            content = @Content(schema = @Schema(implementation = Namespace.class))
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        )
    })
    Namespace updateNamespace(
        @Parameter(description = "네임스페이스 ID", required = true)
        @PathVariable("namespace_id") String namespaceId,
        
        @Parameter(description = "네임스페이스 수정 요청", required = true)
        @Valid @RequestBody NamespaceBase request
    );

    /**
     * 네임스페이스 삭제
     * 
     * <p>지정된 네임스페이스를 삭제합니다.</p>
     * 
     * @param namespaceId 네임스페이스 ID
     */
    @DeleteMapping(
        value = "/api/v1/namespaces/{namespace_id}"
    )
    @Operation(
        summary = "네임스페이스 삭제",
        description = "지정된 네임스페이스를 삭제합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "204",
            description = "네임스페이스 삭제 성공"
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류",
            content = @Content(schema = @Schema(implementation = Map.class))
        )
    })
    void deleteNamespace(
        @Parameter(description = "네임스페이스 ID", required = true)
        @PathVariable("namespace_id") String namespaceId
    );
}
