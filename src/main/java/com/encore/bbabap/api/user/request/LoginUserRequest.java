package com.encore.bbabap.api.user.request;


import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Getter;

@Getter
public class LoginUserRequest {

    @Email
    private final String email;

    private final String password;

    @Builder
    public LoginUserRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
