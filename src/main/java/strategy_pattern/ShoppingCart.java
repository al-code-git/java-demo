package strategy_pattern;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

import static strategy_pattern.PaymentMethod.*;

public class ShoppingCart {
    private Order order;
    private List<Product> products;

    public ShoppingCart(PaymentMethod paymentMethod, List<Product> products) {
        this.order = new Order(products, paymentMethod);
        this.products = products;
    }

    public BigDecimal calculatePriceAfterDiscountIfStatements() {
        if(DEBIT_CARD.equals(order.getPaymentMethod())) {
            return calculatePrice(new BigDecimal("0.95"));
        } else if(PAYPAL.equals(order.getPaymentMethod())) {
            return calculatePrice(new BigDecimal("0.99"));
        } else if(CASH.equals(order.getPaymentMethod())) {
            return calculatePrice(new BigDecimal("0.90"));
        } else {
            return order.getTotalPrice();
        }
    }

    public BigDecimal calculatePriceAfterDiscountSwitchCase() {
        return switch (order.getPaymentMethod()) {
            case DEBIT_CARD -> calculatePrice(new BigDecimal("0.95"));
            case PAYPAL -> calculatePrice(new BigDecimal("0.99"));
            case CASH -> calculatePrice(new BigDecimal("0.90"));
            default -> order.getTotalPrice();
        };
    }

    public BigDecimal calculatePriceAfterDiscountWithStrategy() {
        return order.getPaymentMethod()
                .applyDiscount(order.getTotalPrice())
                .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal calculatePrice(BigDecimal discount) {
        return Optional.ofNullable(order.getTotalPrice())
                .map(t ->
                        t.multiply(discount)
                                .setScale(2, RoundingMode.HALF_UP)
                ).orElse(BigDecimal.ZERO);
    }

    public Order getOrder() {
        return order;
    }
}
