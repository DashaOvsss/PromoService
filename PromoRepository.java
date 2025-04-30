package com.example.promo.repository;

import com.example.promo.entity.PromoCode;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PromoRepository extends JpaRepository<PromoCode, Long> {
    Optional<PromoCode> findByCode(String code);
}
