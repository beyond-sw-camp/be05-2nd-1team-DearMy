package com.encore.bbabap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestClass {
    @GetMapping("/hello")
    public String hello(){
        return "Hello Spring";
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
}
