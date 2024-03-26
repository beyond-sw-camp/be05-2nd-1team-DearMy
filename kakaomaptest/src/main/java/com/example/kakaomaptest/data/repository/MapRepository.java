package com.example.kakaomaptest.data.repository;

import com.example.kakaomaptest.data.entity.MapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface MapRepository extends JpaRepository<MapEntity, Long>{
    //해당 Repository로 JpaRepository의 다양한 메서드를 사용할 수 있다.

}
