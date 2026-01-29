package strategy_pattern;

import java.math.BigDecimal;
import java.util.List;

public class Order {
    private List<Product> products;
    private PaymentMethod paymentMethod;

    public Order(List<Product> products, PaymentMethod paymentMethod) {
        this.products = products;
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getTotalPrice() {
        return products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
}
