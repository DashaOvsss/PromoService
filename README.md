# PromoService
com.example.promo
├── controller
│   └── PromoController.java       // REST-ендпоінти /promo
├── service
│   └── PromoService.java          // Бізнес-логіка
├── repository
│   └── PromoRepository.java       // Робота з базою даних
├── entity
│   └── PromoCode.java             // JPA-сутність
└── test
    ├── PromoServiceTest.java      // Юніт-тести для сервісу
    └── PromoControllerTest.java   // Тести для контролера


    POST /promo/generate?email=test@example.com
    GET /promo/validate?code=ABC123
