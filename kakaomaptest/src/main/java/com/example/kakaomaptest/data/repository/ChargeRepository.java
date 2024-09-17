package com.example.kakaomaptest.data.repository;

import com.example.kakaomaptest.Charge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargeRepository extends JpaRepository<Charge, String> {

}