package strategy_pattern;

import java.util.List;

public class Order {
    private List<Product> products;
    private PaymentMethod paymentMethod;

    public Order(List<Product> products, PaymentMethod paymentMethod) {
        this.products = products;
        this.paymentMethod = paymentMethod;
    }

    public List<Product> getProducts() {
        return products;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
}
