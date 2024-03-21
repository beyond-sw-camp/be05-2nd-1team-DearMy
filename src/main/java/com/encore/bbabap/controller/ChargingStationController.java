package com.encore.bbabap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ChargingStationController {

    @GetMapping("/api/charging-stations")
    public String getChargingStations() {
        String url = "https://safemap.go.kr/openApiService/data/getChargingStationData.do";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}
