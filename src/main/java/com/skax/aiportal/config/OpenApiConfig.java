package com.skax.aiportal.config;

import java.util.List;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * <b>OpenAPI 3 및 Swagger UI 문서화 설정 클래스</b>
 *
 * <p>
 * SpringDoc(OpenAPI 3) 기반의 API 명세 및 Swagger UI 문서화 설정을 담당합니다.<br>
 * <ul>
 *   <li>API 기본 정보(제목, 설명, 버전, 연락처, 라이선스 등)와 JWT 인증 스키마를 포함</li>
 *   <li>운영/개발 환경별로 API 문서화 활성화 조건 제어</li>
 *   <li>모든 엔드포인트 그룹화 및 보안 요구사항 일관 제공</li>
 * </ul>
 * </p>
 *
 * <p>
 * <b>보안:</b> JWT Bearer 인증 스키마를 기본 적용하며, API 문서화 활성화는 환경설정(springdoc.swagger-ui.enabled)으로 제어합니다.<br>
 * <b>확장:</b> Info, Contact, License 등 OpenAPI 표준 객체를 활용하여 문서화 품질을 높입니다.
 * </p>
 *
 * @author ByounggwanLee
 * @since 2025-07-19
 * @version 1.0
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
@ConditionalOnProperty(name = "springdoc.swagger-ui.enabled", havingValue = "true", matchIfMissing = true)
public class OpenApiConfig {
// https://codingnconcepts.com/spring-boot/configure-springdoc-openapi/
	private static final String BEARER_FORMAT = "JWT";
	private static final String SCHEME = "Bearer";
	private static final String SECURITY_SCHEME_NAME = "Security Scheme";

	@Value("${api.info.title: api.info.title}")
	private String title;

	@Value("${api.info.description: api.info.description}")
	private String description;

	@Value("${api.info.version: api.info.version}")
	private String version;

	@Value("${api.info.term-of-service: api.info.terms-of-service}")
	private String termOfService;

	@Value("${api.info.contact.name: api.info.contact.name}")
	private String contactName;

	@Value("${api.info.contact.email: api.info.contact.email}")
	private String contactEmail;

	@Value("${api.info.contact.url: api.info.contact.url}")
	private String contactUrl;

	@Value("${api.info.license.name: api.info.license.name}")
	private String licenseName;

	@Value("${api.info.license.url: api.info.license.url}")
	private String licenseUrl;

	/**
	 * OpenAPI 3 문서화 및 Swagger UI 설정 빈을 등록합니다.
	 *
	 * <p>API의 인증 방식, 기본 정보, 라이선스, 연락처, 보안 스키마 등을 포함한
	 * OpenAPI 3 스펙을 제공합니다.</p>
	 *
	 * @return OpenAPI 객체 (Swagger UI에서 사용)
	 * @author ByounggwanLee
	 * @since 2025-07-19
	 * @version 1.0
	 */
	@Bean
	OpenAPI api() {
		return new OpenAPI().schemaRequirement(SECURITY_SCHEME_NAME, getSecurityScheme())
				.security(getSecurityRequirement()).info(info());
	}

	/**
	 * 전체 API 엔드포인트를 Swagger UI에 그룹화하여 노출합니다.
	 *
	 * <p>모든 엔드포인트를 포함하는 GroupedOpenApi를 등록합니다.</p>
	 *
	 * @return GroupedOpenApi 객체
	 * @author ByounggwanLee
	 * @since 2025-07-19
	 * @version 1.0
	 */
	@Bean
	GroupedOpenApi apiAll() {
		return GroupedOpenApi.builder().group("all").pathsToMatch("/**").build();
	}

	/**
	 * Swagger 화면의 기본 API 정보를 설정합니다.
	 *
	 * <p>API 제목, 설명, 버전, 연락처, 라이선스 정보를 포함합니다.</p>
	 *
	 * @return Info 객체
	 */
	private Info info() {
		return new Info().title(title).description(description).version(version)
				.contact(new Contact().name(contactName).email(contactEmail).url(contactUrl))
				.license(new License().name(licenseName).url(licenseUrl));
	}

	/**
	 * Swagger 화면의 SecurityRequirement 정보를 설정합니다.
	 *
	 * <p>JWT 인증을 위한 SecurityRequirement를 추가합니다.</p>
	 *
	 * @return SecurityRequirement 리스트
	 */
	private List<SecurityRequirement> getSecurityRequirement() {
		SecurityRequirement securityRequirement = new SecurityRequirement();
		securityRequirement.addList(SECURITY_SCHEME_NAME);
		return List.of(securityRequirement);
	}

	/**
	 * Swagger 화면의 SecurityScheme 정보를 설정합니다.
	 *
	 * <p>JWT Bearer 인증 방식을 적용합니다.</p>
	 *
	 * @return SecurityScheme 객체
	 */
	private SecurityScheme getSecurityScheme() {
		SecurityScheme securityScheme = new SecurityScheme();
		securityScheme.bearerFormat(BEARER_FORMAT);
		securityScheme.type(SecurityScheme.Type.HTTP);
		securityScheme.in(SecurityScheme.In.HEADER);
		securityScheme.scheme(SCHEME);
		return securityScheme;
	}
}
//public class OpenApiConfig {

//     @Value("${server.servlet.context-path:/api/v1}")
//     private String contextPath;

//     @Value("${server.port:8080}")
//     private String serverPort;

	/**
	 * OpenAPI 3.0 설정을 정의합니다.
	 * 
	 * @return OpenAPI 설정 객체
	 */
//     @Bean
//     public OpenAPI customOpenAPI() {
//         return new OpenAPI()
//                 .servers(List.of(
//                         new Server()
//                                 .url("http://localhost:" + serverPort + contextPath)
//                                 .description("Development Server"),
//                         new Server()
//                                 .url("https://api.skax.com" + contextPath)
//                                 .description("Production Server")
//                 ))
//                 .info(new Info()
//                         .title("SKAX AI Portal API")
//                         .description("SKAX AI Portal API 서비스입니다. " +
//                                 "이 API는 AI 모델 관리, 데이터 처리, 에이전트 관리 등의 기능을 제공합니다.")
//                         .version("1.0.0")
//                         .contact(new Contact()
//                                 .name("SKAX Development Team")
//                                 .email("dev@skax.com")
//                                 .url("https://skax.com"))
//                         .license(new License()
//                                 .name("SKAX License")
//                                 .url("https://skax.com/license")));
//     }
//}