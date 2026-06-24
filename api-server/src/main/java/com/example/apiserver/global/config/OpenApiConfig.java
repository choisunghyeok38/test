package com.example.apiserver.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value; // ✅ 주입을 위해 추가
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Value("${openapi.domain}")
    private String domain;

    @Bean
    public OpenAPI openAPI() {
        String jwtSchemeName = "jwtAuth";
        SecurityRequirement securityRequirement = new SecurityRequirement().addList(jwtSchemeName);
        Components components = new Components()
                .addSecuritySchemes(jwtSchemeName, new SecurityScheme()
                        .name(jwtSchemeName)
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT"));

        String serverUrl = domain.startsWith("http") ? domain : "https://" + domain;

        return new OpenAPI()
                .addServersItem(new Server().url(serverUrl).description("현재 환경 서버 주소"))
                .info(new Info()
                        .title("Account Book API")
                        .description("가계부 서버 API 명세서 (JWT 인증이 필요한 경우 Authorize 버튼을 이용하세요)")
                        .version("v1.0.0"))
                .addSecurityItem(securityRequirement)
                .components(components);
    }
}