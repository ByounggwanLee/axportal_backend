#!/bin/bash
#---------------------------------------------------------------------
# SKT OpenAPI Feign Client Interface 생성 스크립트
#---------------------------------------------------------------------
#-- SKT OpenAPI Url
skturl=("https://aip-stg.sktai.io/api/v1/agent" \
        "https://aip-stg.sktai.io/api/v1/common/auth" \
        "https://aip-stg.sktai.io/api/v1/data" \
        "https://aip-stg.sktai.io/api/v1/evaluation" \
        "https://aip-stg.sktai.io/api/v1/knowledge" \
        "https://aip-stg.sktai.io/api/v1/model" \
        "https://aip-stg.sktai.io/api/v1/management/safety_filter" \
        "https://aip-stg.sktai.io/api/v1/finetuning" \
        "https://aip-stg.sktai.io/api/v1/serving" \
        "https://aip-stg.sktai.io/api/v1/model_gateway" \
        "https://aip-stg.sktai.io/api/v1/agent_gateway" \
        "https://aip-stg.sktai.io/api/v1/management/resource" \
        "https://aip-stg.sktai.io/api/v1/management/history") 

#-- prompt file
result=./prompt/sktfeign.txt

if [ -e ${result} ]; then rm ${result}; fi

for api in "${skturl[@]}"
do name=$(basename $api | sed 's/_//g') 
   echo $name, $api 
   echo "- URL(${api}/openapi.json)를 참조" | tee -a ${result}
   echo "  - config, intercept는 /client/sktax/config, /client/sktax/intercept의 생성하여 공통으로 사용하며, 필요시 수정" | tee -a ${result}
   echo "  - Feign Client Interface는 접속 엔드포인트별로 Group화하여 /client/sktax/$name 디렉토리에 생성" | tee -a ${result}
   echo "  - dto생성" | tee -a ${result}
   echo "    - file명은 openapi.json의 명세을 기반으로 생성" | tee -a ${result}
   echo "    - file명에 Request, Req, request, req가 글자가 포함된 경우만 /client/sktax/$name/dto/request에 생성"| tee -a ${result}
   echo "    - file명에 Response, Res, response, res가 포함된 경우만 /client/sktax/$name/dto/response에 생성" | tee -a ${result}
   echo "    - 이외는 /client/sktax/$name/dto/ 기본 디렉토리에 생성" | tee -a ${result}
   echo "    - class내부에 inner class는 별도 독립 class로 생성(단, enum class는 예외)" | tee -a ${result}
   echo "  - 작업시 주의사항" | tee -a ${result}
   echo "    - Swagger UI에서 제공하는 예시를 참고하여 DTO를 작성하세요." | tee -a ${result}
   echo "    - 요청 파라미터 및 응답 모델의 필드명은 OpenAPI 명세와 일치해야 합니다." | tee -a ${result}
   echo "    - OpenAPI 명세에 정의된 필드 타입을 정확히 반영해야 합니다." | tee -a ${result}
   echo "  - 수행전 coplot-instructions.md과 충돌내용 있으면 확인 요청" | tee -a ${result}
   echo "- 작업완료 후 openapi.json 명세와 비교 누락된 부분은 재생성" | tee -a ${result}
   echo "---" | tee -a ${result}
done
echo "생성된 내용은 ${result} 파일을 확인하세요."