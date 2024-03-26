package com.encore.bbabap.repository.kakao;

import com.encore.bbabap.domain.kakao.Charge;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChargeRepository extends JpaRepository<Charge, String> {
    List<Charge> findByBusiNameContaining(String busiName);
    List<Charge> findByChargeTypeContaining(String busiName);
    List<Charge> findByChargeAddrContaining(String busiName);
    List<Charge> findByChargeNameContaining(String busiName);
}