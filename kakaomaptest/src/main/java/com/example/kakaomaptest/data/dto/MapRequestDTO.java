package com.example.kakaomaptest.data.dto;

import com.example.kakaomaptest.data.entity.MapEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MapRequestDTO {

    private Long favorites_tbl_id;
    private Integer user_tbl_id;
    private String chargingstation_id;

    public static MapRequestDTO mapRequestDTO(MapEntity mapEntity){
        MapRequestDTO mapRequestDTO = new MapRequestDTO();
        mapRequestDTO.setFavorites_tbl_id(mapEntity.getFavorites_tbl_id());
        mapRequestDTO.setUser_tbl_id(mapEntity.getUser_tbl_id());
        mapRequestDTO.setChargingstation_id(mapEntity.getChargingstation_id());
        return mapRequestDTO;
    }

}
