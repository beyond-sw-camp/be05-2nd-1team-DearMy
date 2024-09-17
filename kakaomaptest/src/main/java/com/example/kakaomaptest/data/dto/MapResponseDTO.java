package com.example.kakaomaptest.data.dto;

import com.example.kakaomaptest.data.entity.MapEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MapResponseDTO {
    private Long favorites_tbl_id;
    private Integer user_tbl_id;
    private String chargingstation_id;

    public static MapResponseDTO mapResponseDTO(MapEntity mapEntity){
        MapResponseDTO mapResponseDTO = new MapResponseDTO();
        mapResponseDTO.setFavorites_tbl_id(mapEntity.getFavorites_tbl_id());
        mapResponseDTO.setUser_tbl_id(mapEntity.getUser_tbl_id());
        mapResponseDTO.setChargingstation_id(mapEntity.getChargingstation_id());
        return mapResponseDTO;
    }
}
