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
    public String zzimniTest2() {
        return "Hello Spring I'm zzimni2";
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "Hello Spring";
    }

    @GetMapping("/hello3")
    public String hello3(){
        return "Hello Spring";
    }

    @GetMapping("/hello4")
    public String hello4(){
        return "Hello Spring";
    }

    @GetMapping("/hello5")
    public String hello5() {
        return "Hello Spring";
    }

    @GetMapping("/hello6")
    public String hello6() {
        return "Hello Spring";

    }
}
