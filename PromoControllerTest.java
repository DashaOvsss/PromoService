package com.example.promo;

import com.example.promo.controller.PromoController;
import com.example.promo.entity.PromoCode;
import com.example.promo.service.PromoService;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class PromoControllerTest {

    @Test
    void testGenerateEndpoint() {
        PromoService mockService = mock(PromoService.class);
        PromoController controller = new PromoController();
        controller.promoService = mockService;

        PromoCode mockCode = new PromoCode();
        mockCode.setCode("NEW123");
        when(mockService.generatePromoCode("test@example.com")).thenReturn(mockCode);

        PromoCode result = controller.generate("test@example.com");
        assertEquals("NEW123", result.getCode());
    }

    @Test
    void testValidateEndpoint() {
        PromoService mockService = mock(PromoService.class);
        PromoController controller = new PromoController();
        controller.promoService = mockService;

        when(mockService.validatePromoCode("ABC123")).thenReturn(true);
        assertTrue(controller.validate("ABC123"));
    }
}
