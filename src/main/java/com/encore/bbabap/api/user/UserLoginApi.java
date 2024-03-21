package com.encore.bbabap.api.user;

import com.encore.bbabap.api.user.request.LoginUserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLoginApi {

    // TODO : 지금은 필요없는 코드  -> rest api 형식으로 커스텀 하기
    @PostMapping("/login")
    public String login(@RequestBody LoginUserRequest request) {
        return request.getPassword();
    }


}
