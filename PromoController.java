package com.example.promo.controller;

import com.example.promo.entity.PromoCode;
import com.example.promo.service.PromoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/promo")
public class PromoController {

    @Autowired
    private PromoService promoService;

    @PostMapping("/generate")
    public PromoCode generate(@RequestParam String email) {
        return promoService.generatePromoCode(email);
    }

    @GetMapping("/validate")
    public boolean validate(@RequestParam String code) {
        return promoService.validatePromoCode(code);
    }
}
