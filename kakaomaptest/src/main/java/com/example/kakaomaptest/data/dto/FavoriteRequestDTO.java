package com.example.kakaomaptest.data.dto;

import com.example.kakaomaptest.data.entity.FavoriteEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteRequestDTO {

    private Long id;
    private String chargerName;
    private String chargerAddress;
    private String chargerPower;
    private String chargerType;

    public static FavoriteRequestDTO favoriteRequestDTO(FavoriteEntity favoriteEntity){
        FavoriteRequestDTO favoriteRequestDTO = new FavoriteRequestDTO();
        favoriteRequestDTO.setId(favoriteEntity.getId());
        favoriteRequestDTO.setChargerName(favoriteEntity.getChargerName());
        favoriteRequestDTO.setChargerAddress(favoriteEntity.getChargerAddress());
        favoriteRequestDTO.setChargerPower(favoriteEntity.getChargerPower());
        favoriteRequestDTO.setChargerType(favoriteEntity.getChargerType());
        return favoriteRequestDTO;
    }


}
