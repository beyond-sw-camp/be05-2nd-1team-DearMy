package com.example.kakaomaptest.controller;

import com.example.kakaomaptest.data.dto.MapRequestDTO;
import com.example.kakaomaptest.data.dto.MapResponseDTO;
import com.example.kakaomaptest.data.entity.MapEntity;
import com.example.kakaomaptest.service.MapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/babap")
public class MapController {

    private final MapService mapService;

    @PostMapping("/map/add")
    public void addFavorite(@RequestBody MapRequestDTO mapRequestDTO){
        System.out.println("즐겨찾기 추가 완료");
        mapService.saveFavorite(mapRequestDTO);
    }

    @GetMapping("/map/find")
    public ResponseEntity<MapResponseDTO> getFavorite(Long number){
        MapResponseDTO mapResponseDTO = mapService.findFavorite(number);
        System.out.println("즐겨찾기 조회 완료");
        return ResponseEntity.status(HttpStatus.OK).body(mapResponseDTO);
    }

    @DeleteMapping("/map/delete")
    public void deleteFavorite(Long number) throws Exception {
        mapService.deleteFavorite(number);
        System.out.println(number + "번 즐겨찾기 삭제 완료");
    }


}