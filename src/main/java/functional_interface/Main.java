package functional_interface;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var people = List.of(
                new Person("O Urso Judeu", 30, new BigDecimal("10000.00")),
                new Person("Hans Landa", 60, new BigDecimal("900.00")),
                new Person("Aldo o Apache", 25, new BigDecimal("111.00")),
                new Person("Shosanna", 17, new BigDecimal("100.00")),
                new Person("Marcel", 108, new BigDecimal("1000.00"))
        );

        printPerson(people);
    }

    public static void printPerson(List<Person> people) {
        for (Person person : people) {
            System.out.println("--------------------------------------------------");
            System.out.println(person);
        }
    }
}
