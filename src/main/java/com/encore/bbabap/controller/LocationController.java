package com.encore.bbabap.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LocationController {

    @PostMapping("/api/location")
    public Map<String, Double> receiveUserLocation(@RequestBody Map<String, Double> userLocation) {
        // 클라이언트에서 전송한 위치 정보를 받아와서 처리
        double latitude = userLocation.get("latitude");
        double longitude = userLocation.get("longitude");

        // 여기서는 받은 위치 정보를 그대로 다시 클라이언트에게 전송하는 예시
        // 실제로는 해당 위치를 기반으로 다른 작업을 수행
        Map<String, Double> location = new HashMap<>();
        location.put("latitude", latitude);
        location.put("longitude", longitude);

        return location;
    }
}
