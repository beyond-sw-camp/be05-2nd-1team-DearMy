package com.encore.bbabap.api.kakao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.encore.bbabap.domain.kakao.Charge;
import com.encore.bbabap.repository.kakao.ChargeRepository;
import java.util.List;

@RestController
public class ChargeRestController {

    private final ChargeRepository chargeRepository;

    public ChargeRestController(ChargeRepository chargeRepository) {
        this.chargeRepository = chargeRepository;
    }

    @GetMapping("/charges")
    public List<Charge> getAllCharges() {
        return chargeRepository.findAll();
    }
}