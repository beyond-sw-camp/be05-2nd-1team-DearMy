package com.encore.bbabap.api.member;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberApi {

    @GetMapping("/member")
    public String test() {
        System.out.println("git branch test 입니다.");
        return null;
    }

}
