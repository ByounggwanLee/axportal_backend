# AI 명령어를 통한 프로그램 생성 프롬프트

## 사전작업 ##
1. 디렉토리 생성
2. .github에 coplot-instructions.md 파일 생성

## 프로젝트 생성 ##
1. 생성 프롬프트
``` ai prompt
프로젝트 생성해줘
```
2. Gradle/Maven Wrapper설치
``` ai prompt
maven[gradle] wrapper 를 생성해줘
```
3. 실행환경변경
``` ai prompt
Run 및 Debug 실행시 외부Local환경으로 설정해줘
```
4. 로깅 및 요청 추적 자동생성
``` ai prompt
구조화된 로깅 및 요청 추적 자동생성
```
5. Jwt인증 및 SpringSecutrity추가
```
springsecurity와 jwt인증 추가
```
6. CORS 설정
``` ai prompt
CORS를 허용하도록 설정해줘
```
7. 샘플 생성
``` ai prompt
Sample 생성해줘
```
8. SktAx FeignClient 및 DTO생성
   - 생성요청
``` ai prompt
- URL(https://aip-stg.sktai.io/api/v1/common/auth/openapi.json)를 참조
  - config, intercept는 /client/sktax/config, /client/sktax/intercept의 생성하여 공통으로 사용하며, 필요시 수정
  - Feign Client Interface는 접속 엔드포인트별로 Group화하여 /client/sktax/auth 디렉토리에 생성
  - dto생성
    - file명은 openapi.json의 명세을 기반으로 생성
    - file명에 Request, Req, request, req가 포함된 경우 /client/sktax/auth/dto/request에 생성
    - file명에 Response, Res, response, res가 포함된 경우 /client/sktax/auth/dto/response에 생성
    - 이외는 /client/sktax/auth/dto/ 기본 디렉토리에 생성
    - class내부에 inner class는 별도 독립 class로 생성(단, enum class는 예외)
  - 작업시 주의사항
    - Swagger UI에서 제공하는 예시를 참고하여 DTO를 작성하세요.
    - 요청 파라미터 및 응답 모델의 필드명은 OpenAPI 명세와 일치해야 합니다.
    - OpenAPI 명세에 정의된 필드 타입을 정확히 반영해야 합니다.
  - 수행전 coplot-instructions.md과 충돌내용 있으면 확인 요청
- 작업완료 후 openapi.json 명세와 비교 누락된 부분은 재생성
```
  - 수행점검
```ai prompt
다시한번 openapi.json 명세와 비교 누락된 부분은 재생성
```
   - 수행완료 후 재점검
```
생성된 파일이 OpenAPI 명세와 일치하는지 확인
  - 작업시 주의사항
    - Swagger UI에서 제공하는 예시를 참고하여 DTO를 작성하세요.
    - 요청 파라미터 및 응답 모델의 필드명은 OpenAPI 명세와 일치해야 합니다.
    - OpenAPI 명세에 정의된 필드 타입을 정확히 반영해야 합니다.
```   

## 기타 ##
** 소스파일 변경 **
``` ai prompt
소스파일을 타켓파일로 변경해줘
```
** 파일 삭제 **
``` ai prompt
파일을 삭제해줘
```
** maven 컴파일 **
.\mvnw.cmd clean compile
```
mvnw로 컴파일해줘
```

** 삭제파일 복구되는 문제 **
git commit & push 후 "Developer: Reload window"실행 파일 생면
git restore .
git clean -fd
```
현재 git 변경된 파일 원복해줘
```