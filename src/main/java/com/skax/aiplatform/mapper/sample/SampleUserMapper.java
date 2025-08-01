package com.skax.aiplatform.mapper.sample;

import com.skax.aiplatform.dto.sample.request.SampleUserCreateReq;
import com.skax.aiplatform.dto.sample.request.SampleUserUpdateReq;
import com.skax.aiplatform.dto.sample.response.SampleUserRes;
import com.skax.aiplatform.entity.sample.SampleUser;
import org.mapstruct.*;

/**
 * 샘플 사용자 MapStruct 매퍼
 * 
 * <p>SampleUser 엔티티와 DTO 간의 변환을 처리합니다.
 * MapStruct를 사용하여 컴파일 타임에 최적화된 변환 코드를 생성합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface SampleUserMapper {

    /**
     * SampleUser 엔티티를 SampleUserRes DTO로 변환
     * 
     * @param entity 변환할 엔티티
     * @return 변환된 응답 DTO
     */
    @Mapping(target = "statusDescription", ignore = true)
    SampleUserRes toResponse(SampleUser entity);

    /**
     * 상세 정보가 포함된 응답 생성 (statusDescription 포함)
     * 
     * @param entity 변환할 엔티티
     * @return 변환된 응답 DTO
     */
    default SampleUserRes toDetailResponse(SampleUser entity) {
        SampleUserRes response = toResponse(entity);
        if (entity.getStatus() != null) {
            response.setStatusDescription(entity.getStatus().getDescription());
        }
        return response;
    }

    /**
     * SampleUserCreateReq DTO를 SampleUser 엔티티로 변환
     * 
     * @param request 생성 요청 DTO
     * @param encodedPassword 암호화된 비밀번호
     * @return 변환된 엔티티
     */
    @Mapping(target = "id", ignore = true) // ID는 DB에서 자동 생성
    @Mapping(target = "status", constant = "ACTIVE") // 기본 상태는 ACTIVE
    @Mapping(source = "encodedPassword", target = "password")
    SampleUser toEntity(SampleUserCreateReq request, String encodedPassword);

    /**
     * SampleUserUpdateReq DTO로 기존 SampleUser 엔티티 업데이트
     * 
     * @param request 수정 요청 DTO
     * @param entity 업데이트할 기존 엔티티
     */
    @Mapping(target = "id", ignore = true) // ID는 변경하지 않음
    @Mapping(target = "username", ignore = true) // 사용자명은 변경하지 않음
    @Mapping(target = "password", ignore = true) // 비밀번호는 별도 메서드로 처리
    void updateEntity(SampleUserUpdateReq request, @MappingTarget SampleUser entity);
}
