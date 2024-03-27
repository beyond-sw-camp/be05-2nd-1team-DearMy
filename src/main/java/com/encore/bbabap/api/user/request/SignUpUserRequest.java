package com.encore.bbabap.api.user.request;

import com.encore.bbabap.domain.enums.CarType;
import jakarta.validation.constraints.Email;
import lombok.Getter;

@Getter
public class SignUpUserRequest {

    @Email
    private String email;

    private String password;

    private String nickname;

//    private CarType carType;


}
