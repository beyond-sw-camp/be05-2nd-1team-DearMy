package com.encore.bbabap.domain.user;

public enum UserStatus {
    Y("Y"),
    N("N");

    private String code;

    UserStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
