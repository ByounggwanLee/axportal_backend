package com.skax.aiplatform.client.sktax.resource;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.skax.aiplatform.client.sktax.config.SktAxFeignConfig;
import com.skax.aiplatform.client.sktax.resource.dto.Namespace;
import com.skax.aiplatform.client.sktax.resource.dto.NamespaceDetail;
import com.skax.aiplatform.client.sktax.resource.dto.NamespaceBase;
import com.skax.aiplatform.client.sktax.resource.dto.ResourcePolicyPublic;
import com.skax.aiplatform.client.sktax.resource.dto.TaskQuotaBase;
import com.skax.aiplatform.client.sktax.resource.dto.TaskQuotaPublic;
import com.skax.aiplatform.client.sktax.resource.dto.request.NamespaceCreateReq;
import com.skax.aiplatform.client.sktax.resource.dto.request.ResourceCheckReq;
import com.skax.aiplatform.client.sktax.resource.dto.response.ClusterResourceRes;
import com.skax.aiplatform.client.sktax.resource.dto.response.NamespaceListRes;
import com.skax.aiplatform.client.sktax.resource.dto.response.ResourceCheckRes;
import com.skax.aiplatform.client.sktax.resource.dto.response.TaskResourceRes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * Resource Management API Feign Client
 * 
 * <p>SKTAX Resource Management 서비스와의 통신을 위한 Feign Client 인터페이스입니다.
 * 클러스터 리소스 조회, Task 리소스 관리, Namespace 관리 등의 기능을 제공합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-02
 * @version 1.0
 */
@FeignClient(
    name = "resource-management-client",
    url = "${sktax.resource.url:https://aip-stg.sktai.io}",
    configuration = SktAxFeignConfig.class
)
@Tag(name = "Resource Management", description = "Resource Management API")
public interface ResourceManagementClient {

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
            description = "인증 실패"
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류"
        )
    })
    ClusterResourceRes getClusterResource(
        @Parameter(description = "노드 타입")
        @RequestParam(value = "node_type", required = false) String nodeType
    );

    /**
     * Task 리소스 조회
     * 
     * <p>Task 실행 전 리소스 정보를 조회합니다.</p>
     * 
     * @param taskType Task 타입
     * @param projectId 프로젝트 ID
     * @return Task 리소스 정보
     */
    @GetMapping(
        value = "/api/v1/resources/task/{task_type}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "Task 리소스 조회",
        description = "Task 실행 전 리소스 정보를 조회합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Task 리소스 조회 성공",
            content = @Content(schema = @Schema(implementation = TaskResourceRes.class))
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 실패"
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류"
        )
    })
    TaskResourceRes getTaskResource(
        @Parameter(description = "Task 타입", required = true)
        @PathVariable("task_type") String taskType,
        
        @Parameter(description = "프로젝트 ID", required = true)
        @RequestParam("project_id") String projectId
    );

    /**
     * Task 리소스 확인
     * 
     * <p>Task 실행 시 리소스를 확인합니다.</p>
     * 
     * @param taskType Task 타입
     * @param projectId 프로젝트 ID
     * @param request 리소스 확인 요청 정보
     * @return 리소스 확인 결과
     */
    @PostMapping(
        value = "/api/v1/resources/task/{task_type}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "Task 리소스 확인",
        description = "Task 실행 시 리소스를 확인합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "리소스 확인 성공",
            content = @Content(schema = @Schema(implementation = ResourceCheckRes.class))
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 실패"
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류"
        )
    })
    ResourceCheckRes checkTaskResource(
        @Parameter(description = "Task 타입", required = true)
        @PathVariable("task_type") String taskType,
        
        @Parameter(description = "프로젝트 ID", required = true)
        @RequestParam("project_id") String projectId,
        
        @Parameter(description = "리소스 확인 요청 정보", required = true)
        @Valid @RequestBody ResourceCheckReq request
    );

    /**
     * Task Policy 목록 조회
     * 
     * <p>Task policy 전체 목록을 조회합니다.</p>
     * 
     * @return Task Policy 목록
     */
    @GetMapping(
        value = "/api/v1/resources/task_policy",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "Task Policy 목록 조회",
        description = "Task policy 전체 목록을 조회합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Task Policy 조회 성공",
            content = @Content(schema = @Schema(implementation = List.class))
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 실패"
        )
    })
    List<ResourcePolicyPublic> getTaskPolicyList();

    /**
     * Task Policy 수정
     * 
     * <p>Task Policy를 수정합니다.</p>
     * 
     * @param resources Task Policy 목록
     * @return 수정된 Task Policy 목록
     */
    @PutMapping(
        value = "/api/v1/resources/task_policy",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "Task Policy 수정",
        description = "Task Policy를 수정합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Task Policy 수정 성공",
            content = @Content(schema = @Schema(implementation = List.class))
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 실패"
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류"
        )
    })
    List<ResourcePolicyPublic> updateTaskPolicy(
        @Parameter(description = "Task Policy 목록", required = true)
        @Valid @RequestBody List<ResourcePolicyPublic> resources
    );

    /**
     * Task Policy 등록
     * 
     * <p>새로운 Task Policy를 등록합니다.</p>
     * 
     * @param resources Task Policy 목록
     * @return 등록된 Task Policy 목록
     */
    @PostMapping(
        value = "/api/v1/resources/task_policy",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "Task Policy 등록",
        description = "새로운 Task Policy를 등록합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "201",
            description = "Task Policy 등록 성공",
            content = @Content(schema = @Schema(implementation = List.class))
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 실패"
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류"
        )
    })
    List<ResourcePolicyPublic> addTaskPolicy(
        @Parameter(description = "Task Policy 목록", required = true)
        @Valid @RequestBody List<ResourcePolicyPublic> resources
    );

    /**
     * Task Policy 삭제
     * 
     * <p>지정된 Task Policy를 삭제합니다.</p>
     * 
     * @param taskType Task 타입
     */
    @DeleteMapping(value = "/api/v1/resources/task_policy/{task_type}")
    @Operation(
        summary = "Task Policy 삭제",
        description = "지정된 Task Policy를 삭제합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "204",
            description = "Task Policy 삭제 성공"
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 실패"
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류"
        )
    })
    void deleteTaskPolicy(
        @Parameter(description = "Task 타입", required = true)
        @PathVariable("task_type") String taskType
    );

    /**
     * Task Quota 조회
     * 
     * <p>Task별 Quota 설정을 조회합니다.</p>
     * 
     * @return Task Quota 정보
     */
    @GetMapping(
        value = "/api/v1/resources/task_quota",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "Task Quota 조회",
        description = "Task별 Quota 설정을 조회합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Task Quota 조회 성공",
            content = @Content(schema = @Schema(implementation = TaskQuotaPublic.class))
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 실패"
        )
    })
    TaskQuotaPublic getTaskQuota();

    /**
     * Task Quota 수정
     * 
     * <p>Task별 Quota 설정을 수정합니다.</p>
     * 
     * @param resources Task Quota 목록
     * @return 수정된 Task Quota 목록
     */
    @PutMapping(
        value = "/api/v1/resources/task_quota",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "Task Quota 수정",
        description = "Task별 Quota 설정을 수정합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Task Quota 수정 성공",
            content = @Content(schema = @Schema(implementation = List.class))
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 실패"
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류"
        )
    })
    List<TaskQuotaBase> updateTaskQuota(
        @Parameter(description = "Task Quota 목록", required = true)
        @Valid @RequestBody List<TaskQuotaBase> resources
    );

    /**
     * Task Quota 등록
     * 
     * <p>Task별 Quota 설정을 등록합니다.</p>
     * 
     * @param resources Task Quota 목록
     * @return 등록된 Task Quota 목록
     */
    @PostMapping(
        value = "/api/v1/resources/task_quota",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "Task Quota 등록",
        description = "Task별 Quota 설정을 등록합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "201",
            description = "Task Quota 등록 성공",
            content = @Content(schema = @Schema(implementation = List.class))
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 실패"
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류"
        )
    })
    List<TaskQuotaBase> addTaskQuota(
        @Parameter(description = "Task Quota 목록", required = true)
        @Valid @RequestBody List<TaskQuotaBase> resources
    );

    /**
     * Task Quota 삭제
     * 
     * <p>Task별 Quota 설정을 삭제합니다.</p>
     */
    @DeleteMapping(value = "/api/v1/resources/task_quota")
    @Operation(
        summary = "Task Quota 삭제",
        description = "Task별 Quota 설정을 삭제합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "204",
            description = "Task Quota 삭제 성공"
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 실패"
        )
    })
    void deleteTaskQuota();

    /**
     * Namespace 목록 조회
     * 
     * <p>Namespace 목록을 조회합니다.</p>
     * 
     * @param projectId 프로젝트 ID (선택사항)
     * @return Namespace 목록
     */
    @GetMapping(
        value = "/api/v1/namespaces",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "Namespace 목록 조회",
        description = "Namespace 목록을 조회합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Namespace 목록 조회 성공",
            content = @Content(schema = @Schema(implementation = NamespaceListRes.class))
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 실패"
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류"
        )
    })
    NamespaceListRes getNamespaceList(
        @Parameter(description = "프로젝트 ID")
        @RequestParam(value = "project_id", required = false) String projectId
    );

    /**
     * Namespace 생성
     * 
     * <p>새로운 Namespace를 생성합니다.</p>
     * 
     * @param request Namespace 생성 요청 정보
     * @return 생성된 Namespace 정보
     */
    @PostMapping(
        value = "/api/v1/namespaces",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "Namespace 생성",
        description = "새로운 Namespace를 생성합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "201",
            description = "Namespace 생성 성공",
            content = @Content(schema = @Schema(implementation = Namespace.class))
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 실패"
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류"
        )
    })
    Namespace createNamespace(
        @Parameter(description = "Namespace 생성 요청 정보", required = true)
        @Valid @RequestBody NamespaceCreateReq request
    );

    /**
     * Namespace 정보 조회
     * 
     * <p>지정된 Namespace의 상세 정보를 조회합니다.</p>
     * 
     * @param namespaceId Namespace ID
     * @return Namespace 상세 정보
     */
    @GetMapping(
        value = "/api/v1/namespaces/{namespace_id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "Namespace 정보 조회",
        description = "지정된 Namespace의 상세 정보를 조회합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Namespace 정보 조회 성공",
            content = @Content(schema = @Schema(implementation = NamespaceDetail.class))
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 실패"
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류"
        )
    })
    NamespaceDetail getNamespaceInfo(
        @Parameter(description = "Namespace ID", required = true)
        @PathVariable("namespace_id") String namespaceId
    );

    /**
     * Namespace 수정
     * 
     * <p>지정된 Namespace를 수정합니다.</p>
     * 
     * @param namespaceId Namespace ID
     * @param request Namespace 수정 요청 정보
     * @return 수정된 Namespace 정보
     */
    @PutMapping(
        value = "/api/v1/namespaces/{namespace_id}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
        summary = "Namespace 수정",
        description = "지정된 Namespace를 수정합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Namespace 수정 성공",
            content = @Content(schema = @Schema(implementation = Namespace.class))
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 실패"
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류"
        )
    })
    Namespace updateNamespace(
        @Parameter(description = "Namespace ID", required = true)
        @PathVariable("namespace_id") String namespaceId,
        
        @Parameter(description = "Namespace 수정 요청 정보", required = true)
        @Valid @RequestBody NamespaceBase request
    );

    /**
     * Namespace 삭제
     * 
     * <p>지정된 Namespace를 삭제합니다.</p>
     * 
     * @param namespaceId Namespace ID
     */
    @DeleteMapping(value = "/api/v1/namespaces/{namespace_id}")
    @Operation(
        summary = "Namespace 삭제",
        description = "지정된 Namespace를 삭제합니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "204",
            description = "Namespace 삭제 성공"
        ),
        @ApiResponse(
            responseCode = "401",
            description = "인증 실패"
        ),
        @ApiResponse(
            responseCode = "422",
            description = "입력 데이터 검증 오류"
        )
    })
    void deleteNamespace(
        @Parameter(description = "Namespace ID", required = true)
        @PathVariable("namespace_id") String namespaceId
    );
}
