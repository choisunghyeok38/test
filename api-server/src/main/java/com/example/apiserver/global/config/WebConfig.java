package com.example.apiserver.global.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${cors.allowed-origins:http://localhost:3000,http://localhost:5173}")
    private String allowedOrigins;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // TODO: registry.addMapping(...) 으로 CORS 매핑을 채워보세요.
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        // TODO: CorsConfiguration을 구성하고 UrlBasedCorsConfigurationSource에 등록해서 반환하세요.
        return new UrlBasedCorsConfigurationSource();
    }
}
