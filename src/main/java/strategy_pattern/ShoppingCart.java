package strategy_pattern;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

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
            return calculateTotalPrice().multiply(new BigDecimal("0.95"));
        } else if(PAYPAL.equals(order.getPaymentMethod())) {
            return calculateTotalPrice().multiply(new BigDecimal("0.99"));
        } else if(CASH.equals(order.getPaymentMethod())) {
            return calculateTotalPrice().multiply(new BigDecimal("0.90"));
        } else {
            return calculateTotalPrice();
        }
    }

    public BigDecimal calculatePriceAfterDiscountSwitchCase() {
        return switch (order.getPaymentMethod()) {
            case DEBIT_CARD -> calculateTotalPrice().multiply(new BigDecimal("0.95"));
            case PAYPAL -> calculateTotalPrice().multiply(new BigDecimal("0.99"));
            case CASH -> calculateTotalPrice().multiply(new BigDecimal("0.90"));
            default -> calculateTotalPrice();
        };
    }

    public BigDecimal calculatePriceAfterDiscountWithStrategy() {
        return order.getPaymentMethod()
                .applyDiscount(calculateTotalPrice())
                .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal calculateTotalPrice() {
        return products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
