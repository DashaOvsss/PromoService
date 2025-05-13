interface PromoCodeRepository extends JpaRepository<PromoCode, Long> {
    Optional<PromoCode> findByCode(String code);
}

interface PromoUsageRepository extends JpaRepository<PromoUsage, Long> {
    boolean existsByPromoCodeAndBookingId(PromoCode code, Long bookingId);
}
