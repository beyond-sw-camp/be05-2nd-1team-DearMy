package com.example.kakaomaptest.data.entity;


import com.example.kakaomaptest.data.dto.MapRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="favorites")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MapEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long favorites_tbl_id;

    @Column(name = "user_tbl_id")
    private Integer user_tbl_id;

    @Column(name = "chargingstation_id")
    private String chargingstation_id;

    public static MapEntity mapEntity(MapRequestDTO mapRequestDTO){
        MapEntity mapEntity = new MapEntity();
        mapEntity.setFavorites_tbl_id(mapRequestDTO.getFavorites_tbl_id());
        mapEntity.setUser_tbl_id(mapRequestDTO.getUser_tbl_id());
        mapEntity.setChargingstation_id(mapRequestDTO.getChargingstation_id());
        return mapEntity;
    }

}
