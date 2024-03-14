package com.encore.bbabap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestClass {
    @GetMapping("/hello")
    public String hello(){
        return "Hello Spring";
    }
    @GetMapping("/zzimni")
    public String zzimniTest(){
        return "Hello Spring I'm zzimni";
    }
    @GetMapping("/zzimni2")
    public String zzimniTest2(){
        return "Hello Spring I'm zzimni2";
    }
}
