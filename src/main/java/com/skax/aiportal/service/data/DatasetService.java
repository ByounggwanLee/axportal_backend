package com.skax.aiportal.service.data;

import com.skax.aiportal.dto.data.request.DatasetCreateReq;
import com.skax.aiportal.dto.data.request.DatasetDeleteReq;
import com.skax.aiportal.dto.data.request.DatasetGetReq;
import com.skax.aiportal.dto.data.request.DatasetListReq;
import com.skax.aiportal.dto.data.request.DatasetPreviewReq;
import com.skax.aiportal.dto.data.request.DatasetTagDeleteReq;
import com.skax.aiportal.dto.data.request.DatasetTagUpdateReq;
import com.skax.aiportal.dto.data.request.DatasetUpdateReq;
import com.skax.aiportal.dto.data.request.DatasetUploadFileReq;
import com.skax.aiportal.dto.data.response.DatasetCreateRes;
import com.skax.aiportal.dto.data.response.DatasetDeleteRes;
import com.skax.aiportal.dto.data.response.DatasetGetRes;
import com.skax.aiportal.dto.data.response.DatasetHardDeleteRes;
import com.skax.aiportal.dto.data.response.DatasetListRes;
import com.skax.aiportal.dto.data.response.DatasetPreviewRes;
import com.skax.aiportal.dto.data.response.DatasetTagDeleteRes;
import com.skax.aiportal.dto.data.response.DatasetTagUpdateRes;
import com.skax.aiportal.dto.data.response.DatasetUpdateRes;
import com.skax.aiportal.dto.data.response.DatasetUploadFileRes;

/**
 * 데이터셋 관리 서비스 인터페이스
 * 
 * <p>SKT AI 플랫폼의 데이터셋 관리 기능을 제공하는 서비스 인터페이스입니다.
 * 데이터셋의 생성, 조회, 수정, 삭제 및 태그 관리 등의 비즈니스 로직을 정의합니다.</p>
 * 
 * <p>주요 기능:</p>
 * <ul>
 *   <li>데이터셋 목록 조회 (페이징, 필터링, 검색)</li>
 *   <li>데이터셋 생성 및 파일 업로드</li>
 *   <li>데이터셋 상세 조회</li>
 *   <li>데이터셋 정보 수정</li>
 *   <li>데이터셋 삭제 (소프트/하드)</li>
 *   <li>데이터셋 미리보기</li>
 *   <li>데이터셋 태그 관리</li>
 * </ul>
 * 
 * @author ByounggwanLee
 * @since 2025-07-23
 * @version 1.0
 */
public interface DatasetService {

    /**
     * 데이터셋 목록 조회
     * 
     * <p>페이징, 정렬, 필터링, 검색 조건을 적용하여 데이터셋 목록을 조회합니다.
     * SKT AI API를 통해 데이터를 가져오고 응답 시간을 포함한 래핑된 결과를 반환합니다.</p>
     * 
     * @param request 데이터셋 목록 조회 요청 정보
     * @return 페이징된 데이터셋 목록과 메타데이터
     * @throws com.skax.aiportal.exception.BusinessException 데이터셋 목록 조회 실패 시
     */
    DatasetListRes getDatasets(DatasetListReq request);

    /**
     * 데이터셋 생성
     * 
     * <p>새로운 데이터셋을 생성합니다.
     * 데이터셋 이름, 타입, 설명, 태그, 프로젝트 정보 등을 설정하여 생성합니다.</p>
     * 
     * @param request 데이터셋 생성 요청 정보
     * @return 생성된 데이터셋 정보
     * @throws com.skax.aiportal.exception.BusinessException 데이터셋 생성 실패 시
     * @throws com.skax.aiportal.exception.ValidationException 입력값 검증 실패 시
     */
    DatasetCreateRes createDataset(DatasetCreateReq request);

    /**
     * 데이터셋 상세 조회
     * 
     * <p>데이터셋 ID를 통해 특정 데이터셋의 상세 정보를 조회합니다.
     * 데이터셋의 모든 메타데이터와 설정 정보를 포함합니다.</p>
     * 
     * @param request 데이터셋 조회 요청 정보
     * @return 데이터셋 상세 정보
     * @throws com.skax.aiportal.exception.BusinessException 데이터셋 조회 실패 시
     * @throws com.skax.aiportal.exception.NotFoundException 데이터셋을 찾을 수 없을 시
     */
    DatasetGetRes getDatasetById(DatasetGetReq request);

    /**
     * 데이터셋 정보 수정
     * 
     * <p>기존 데이터셋의 정보를 수정합니다.
     * 이름, 설명, 상태, 태그 등의 메타데이터를 업데이트할 수 있습니다.</p>
     * 
     * @param request 데이터셋 수정 요청 정보
     * @return 수정된 데이터셋 정보
     * @throws com.skax.aiportal.exception.BusinessException 데이터셋 수정 실패 시
     * @throws com.skax.aiportal.exception.NotFoundException 데이터셋을 찾을 수 없을 시
     * @throws com.skax.aiportal.exception.ValidationException 입력값 검증 실패 시
     */
    DatasetUpdateRes updateDataset(DatasetUpdateReq request);

    /**
     * 데이터셋 삭제 (소프트 삭제)
     * 
     * <p>데이터셋을 삭제 상태로 표시합니다.
     * 실제 데이터는 삭제되지 않고 삭제 상태로 마킹되어 목록에서 제외됩니다.</p>
     * 
     * @param request 데이터셋 삭제 요청 정보
     * @return 삭제 처리 결과
     * @throws com.skax.aiportal.exception.BusinessException 데이터셋 삭제 실패 시
     * @throws com.skax.aiportal.exception.NotFoundException 데이터셋을 찾을 수 없을 시
     */
    DatasetDeleteRes deleteDataset(DatasetDeleteReq request);

    /**
     * 모든 삭제된 데이터셋 하드 삭제
     * 
     * <p>삭제 상태로 표시된 모든 데이터셋을 완전히 제거합니다.
     * 이 작업은 되돌릴 수 없으므로 주의가 필요합니다.</p>
     * 
     * @return 하드 삭제 처리 결과
     * @throws com.skax.aiportal.exception.BusinessException 하드 삭제 실패 시
     */
    DatasetHardDeleteRes hardDeleteAllDatasets();

    /**
     * 파일 업로드를 통한 데이터셋 생성
     * 
     * <p>파일을 직접 업로드하여 데이터셋을 생성합니다.
     * 지원되는 파일 형식에 따라 자동으로 데이터셋 타입이 결정됩니다.</p>
     * 
     * @param request 파일 업로드 데이터셋 생성 요청 정보
     * @return 생성된 데이터셋 정보
     * @throws com.skax.aiportal.exception.BusinessException 파일 업로드 실패 시
     * @throws com.skax.aiportal.exception.ValidationException 파일 검증 실패 시
     */
    DatasetUploadFileRes uploadFileDataset(DatasetUploadFileReq request);

    /**
     * 데이터셋 미리보기
     * 
     * <p>데이터셋의 일부 데이터를 미리보기로 조회합니다.
     * 지정된 청크 크기만큼의 데이터 샘플을 반환합니다.</p>
     * 
     * @param request 데이터셋 미리보기 요청 정보
     * @return 데이터셋 미리보기 데이터
     * @throws com.skax.aiportal.exception.BusinessException 미리보기 조회 실패 시
     * @throws com.skax.aiportal.exception.NotFoundException 데이터셋을 찾을 수 없을 시
     */
    DatasetPreviewRes getDatasetPreview(DatasetPreviewReq request);

    /**
     * 데이터셋 태그 업데이트
     * 
     * <p>데이터셋의 태그 정보를 업데이트합니다.
     * 기존 태그를 대체하거나 새로운 태그를 추가할 수 있습니다.</p>
     * 
     * @param request 데이터셋 태그 업데이트 요청 정보
     * @return 태그가 업데이트된 데이터셋 정보
     * @throws com.skax.aiportal.exception.BusinessException 태그 업데이트 실패 시
     * @throws com.skax.aiportal.exception.NotFoundException 데이터셋을 찾을 수 없을 시
     * @throws com.skax.aiportal.exception.ValidationException 태그 검증 실패 시
     */
    DatasetTagUpdateRes updateDatasetTags(DatasetTagUpdateReq request);

    /**
     * 데이터셋 태그 삭제
     * 
     * <p>데이터셋에서 특정 태그들을 삭제합니다.
     * 지정된 태그만 제거하고 나머지 태그는 유지됩니다.</p>
     * 
     * @param request 데이터셋 태그 삭제 요청 정보
     * @return 태그가 삭제된 데이터셋 정보
     * @throws com.skax.aiportal.exception.BusinessException 태그 삭제 실패 시
     * @throws com.skax.aiportal.exception.NotFoundException 데이터셋을 찾을 수 없을 시
     * @throws com.skax.aiportal.exception.ValidationException 태그 검증 실패 시
     */
    DatasetTagDeleteRes deleteDatasetTags(DatasetTagDeleteReq request);
}