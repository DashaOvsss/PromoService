package com.example.promo;

import com.example.promo.entity.PromoCode;
import com.example.promo.repository.PromoRepository;
import com.example.promo.service.PromoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PromoServiceTest {

    @Test
    void testGeneratePromoCode() {
        PromoRepository mockRepo = mock(PromoRepository.class);
        PromoService service = new PromoService();
        service = Mockito.spy(service);
        service.promoRepository = mockRepo;

        PromoCode savedPromo = new PromoCode();
        savedPromo.setCode("PROMO123");
        when(mockRepo.save(any(PromoCode.class))).thenReturn(savedPromo);

        PromoCode result = service.generatePromoCode("test@example.com");
        assertNotNull(result);
        verify(mockRepo, times(1)).save(any(PromoCode.class));
    }

    @Test
    void testValidatePromoCode_Success() {
        PromoRepository mockRepo = mock(PromoRepository.class);
        PromoService service = new PromoService();
        service.promoRepository = mockRepo;

        PromoCode validPromo = new PromoCode();
        validPromo.setCode("ABC123");
        validPromo.setUsed(false);
        validPromo.setExpiresAt(LocalDate.now().plusDays(5));

        when(mockRepo.findByCode("ABC123")).thenReturn(Optional.of(validPromo));

        assertTrue(service.validatePromoCode("ABC123"));
    }

    @Test
    void testValidatePromoCode_Expired() {
        PromoRepository mockRepo = mock(PromoRepository.class);
        PromoService service = new PromoService();
        service.promoRepository = mockRepo;

        PromoCode expiredPromo = new PromoCode();
        expiredPromo.setCode("OLD123");
        expiredPromo.setUsed(false);
        expiredPromo.setExpiresAt(LocalDate.now().minusDays(1));

        when(mockRepo.findByCode("OLD123")).thenReturn(Optional.of(expiredPromo));

        assertFalse(service.validatePromoCode("OLD123"));
    }
}
