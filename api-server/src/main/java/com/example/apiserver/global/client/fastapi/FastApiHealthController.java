package com.example.apiserver.global.client.fastapi;

import com.example.apiserver.global.common.ApiResponse;
import com.example.apiserver.global.common.SuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "External - FastAPI", description = "FastAPI 서버 연동 확인용 API")
@RestController
@RequestMapping("/api/v1/external/fastapi")
@RequiredArgsConstructor
public class FastApiHealthController {

    private final FastApiClient fastApiClient;

    @Operation(summary = "FastAPI 서버 헬스체크", description = "Spring Boot 서버가 FastAPI 서버와 통신 가능한지 확인합니다.")
    @GetMapping("/health")
    public ApiResponse<String> checkFastApiHealth() {
        return ApiResponse.success(SuccessCode.SUCCESS, fastApiClient.checkHealth());
    }
}
