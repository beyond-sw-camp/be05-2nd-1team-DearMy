package com.encore.bbabap.api.user;

import com.encore.bbabap.api.user.request.LoginUserRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserLoginApi {

    @GetMapping("/login")
    public String getLoginPage() {
        return "login"; // 로그인 페이지의 HTML 파일명 또는 경로를 반환
    }

    // POST 메서드는 그대로 유지
    @PostMapping("/login")
    public String login(@RequestBody LoginUserRequest request) {
        return request.getPassword();
    }
}
