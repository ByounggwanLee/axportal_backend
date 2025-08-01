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
3. CORS 설정
``` ai prompt
CORS를 허용하도록 설정해줘
```
4. 샘플 생성
``` ai prompt
CORS를 허용하도록 설정해줘
```
5. 실행환경변경
``` ai prompt
Run 및 Debug 실행시 외부Local환경으로 설정해줘
```
6. Jwt인증 및 SpringSecutrity추가
```
springsecurity와 jwt인증 추가
```
7. SktAx FeignClient 및 DTO생성
   - 생성요청
```
- URL(https://aip-stg.sktai.io/api/v1/common/auth/openapi.json)를 참조 
 - config, intercept는 /client/sktax/config, /client/sktax/intercept의 생성하여 공통으로 사용하며, 필요시 수정
 - Feign Client Interface는 접속 엔드포인트별로 Group화하여 /client/sktax/auth 디렉토리에 생성
 - dto생성
   - file명은 openapi.json의 명세을 기반으로 생성
   - file명에 Request, Req, request, req가 포함된 경우 /client/sktax/auth/dto/request에 생성
   - file명에 Response, Res, response, res가 포함된 경우 /client/sktax/auth/dto/response에 생성
   - 이외는 /client/sktax/auth/dto/ 기본 디렉토리에 생성
   - class내부에 inner class는 별도 독립 class로 생성(단, enum class는 예외)
 - 수행전 coplot-instructions.md과 충돌내용 있으면 확인 요청
```
   - 수행완료 후 재점검
```
다생성되지 않은 것 같아 
- openapi.json 재분석해서 client, dto 생성해줘
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
