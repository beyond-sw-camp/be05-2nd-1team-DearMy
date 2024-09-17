package com.example.kakaomaptest.service;

import com.example.kakaomaptest.data.dto.MapRequestDTO;
import com.example.kakaomaptest.data.dto.MapResponseDTO;
import com.example.kakaomaptest.data.entity.MapEntity;
import com.example.kakaomaptest.data.repository.MapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MapService {

    private final MapRepository mapRepository;

    public void saveFavorite(MapRequestDTO mapRequestDTO){
        MapEntity mapEntity = MapEntity.mapEntity(mapRequestDTO);
        mapRepository.save(mapEntity);
    }

    public MapResponseDTO findFavorite(Long number){
        MapEntity mapEntity = mapRepository.getById(number);
        MapResponseDTO mapResponseDTO = new MapResponseDTO();
        mapResponseDTO.setFavorites_tbl_id(mapEntity.getFavorites_tbl_id());
        mapResponseDTO.setUser_tbl_id(mapEntity.getUser_tbl_id());
        mapResponseDTO.setChargingstation_id(mapEntity.getChargingstation_id());
        return mapResponseDTO;
    }

    public void deleteFavorite(Long number) throws Exception{
        mapRepository.deleteById(number);
    }

}
