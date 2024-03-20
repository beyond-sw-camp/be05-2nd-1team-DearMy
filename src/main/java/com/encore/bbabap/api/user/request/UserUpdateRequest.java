package com.encore.bbabap.api.user.request;

import com.encore.bbabap.domain.enums.CarType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserUpdateRequest {


    private String nickname;

    private String password;

    private CarType carType;



}
