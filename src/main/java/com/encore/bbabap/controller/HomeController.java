package com.encore.bbabap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/map")
    public String home(){
        return "map/homeMap";
    }
}
