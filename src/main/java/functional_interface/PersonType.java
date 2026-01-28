package functional_interface;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.function.Predicate;

public enum PersonType {
    VIP((Person person) -> new BigDecimal("10000.00").compareTo(person.getSalary()) < 1),
    SENIOR((person) -> { return person.getAge() >= 60; }),
    YOUNG(person -> {
        int age = person.getAge();
        return age >= 18 && age <= 25;
    }),
    NONE(p -> false);

    private final Predicate<Person> determinePerson;

    PersonType(Predicate<Person> determinePerson) {
        this.determinePerson = determinePerson;
    }

    public static PersonType determineStrategyByPerson(Person person) {
        return Arrays.stream(PersonType.values())
                .filter(type -> type.determinePerson.test(person))
                .findFirst()
                .orElse(NONE);
    }
}
