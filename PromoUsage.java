@Entity
@Table(name = "promo_usage")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromoUsage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "promo_code_id")
    private PromoCode promoCode;

    private Long bookingId;

    private LocalDate appliedAt;
}
