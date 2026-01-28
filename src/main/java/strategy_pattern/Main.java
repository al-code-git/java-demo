package strategy_pattern;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ShoppingCart creditOrder = new ShoppingCart(PaymentMethod.CREDIT_CARD, getProducts()); // 0%
        ShoppingCart debtOrder = new ShoppingCart(PaymentMethod.DEBIT_CARD, getProducts()); // 5%
        ShoppingCart cashOrder = new ShoppingCart(PaymentMethod.CASH, getProducts()); // 10%

        printResult(cashOrder);
    }

    public static void printResult(ShoppingCart order) {
        System.out.println("--------------------------------------------------");
        System.out.println("Total price: $"
                + order.calculateTotalPrice());
        System.out.println("Total price with discount: $"
                + order.calculatePriceAfterDiscountIfStatements());
        System.out.println("--------------------------------------------------");
    }

    public static List<Product> getProducts() {
        return List.of(
                new Product("Laptop", new BigDecimal("900.00")),
                new Product("Smartphone", new BigDecimal("90.00")),
                new Product("Headphones", new BigDecimal("10.00"))
        );
    }

}
