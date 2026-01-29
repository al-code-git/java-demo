package strategy_pattern;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ShoppingCart creditOrder = new ShoppingCart(PaymentMethod.CREDIT_CARD, getProducts()); // 0%
        ShoppingCart debtOrder = new ShoppingCart(PaymentMethod.DEBIT_CARD, getProducts()); // 5%
        ShoppingCart cashOrder = new ShoppingCart(PaymentMethod.CASH, getProducts()); // 10%

        printResult(creditOrder);
        printResult(debtOrder);
        printResult(cashOrder);
    }

    public static void printResult(ShoppingCart shoppingCart) {
        var order = shoppingCart.getOrder();
        System.out.printf("------ %s ------%n", order.getPaymentMethod());
        System.out.println("Total price: $" + order.getTotalPrice());
        System.out.println("Total price with discount: $"
                + shoppingCart.calculatePriceAfterDiscountIfStatements());
        System.out.printf("%n");
    }

    public static List<Product> getProducts() {
        return List.of(
                new Product("Laptop", new BigDecimal("900.00")),
                new Product("Smartphone", new BigDecimal("90.00")),
                new Product("Headphones", new BigDecimal("10.00"))
        );
    }

}
