package com.example.promo.service;

import com.example.promo.entity.PromoCode;
import com.example.promo.repository.PromoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class PromoService {

    @Autowired
    private PromoRepository promoRepository;

    public PromoCode generatePromoCode(String userEmail) {
        String code = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        PromoCode promo = new PromoCode();
        promo.setCode(code);
        promo.setDiscountPercentage(10); // fixed discount or dynamic logic
        promo.setCreatedAt(LocalDate.now());
        promo.setExpiresAt(LocalDate.now().plusDays(30));
        promo.setUsed(false);
        return promoRepository.save(promo);
    }

    public boolean validatePromoCode(String code) {
        return promoRepository.findByCode(code)
                .filter(p -> !p.isUsed() && p.getExpiresAt().isAfter(LocalDate.now()))
                .isPresent();
    }
}
