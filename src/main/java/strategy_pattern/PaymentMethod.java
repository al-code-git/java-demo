package strategy_pattern;

import java.math.BigDecimal;
import java.util.Optional;

public enum PaymentMethod {
    CREDIT_CARD(BigDecimal.ONE),
    DEBIT_CARD(new BigDecimal("0.95")), // 5% discount
    PAYPAL(new BigDecimal("0.99")), // 1% discount
    BANK_TRANSFER(BigDecimal.ONE),
    CASH(new BigDecimal("0.90")); // 10% discount

    private final BigDecimal discountRate;

    PaymentMethod(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }

    public BigDecimal applyDiscount(BigDecimal amount) {
        return Optional.ofNullable(amount)
                .map(a -> a.multiply(discountRate))
                .orElse(amount);
    }
}
