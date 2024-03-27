package com.encore.bbabap.api.user;

import com.encore.bbabap.api.user.request.LoginUserRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "LoginController", description = "로그인 기능")
public class UserLoginApi {

    @PostMapping("/login")
    @Operation(summary = "사용자 로그인", description = "사용자 로그인을 처리하는 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "로그인 성공"),
            @ApiResponse(responseCode = "401", description = "로그인 실패")
    })
    public String login(@RequestBody LoginUserRequest request) {



        return request.getPassword();
    }


}
