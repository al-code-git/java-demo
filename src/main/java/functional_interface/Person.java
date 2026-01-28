package functional_interface;

import java.math.BigDecimal;

public class Person {
    private final String name;
    private final int age;
    private final BigDecimal salary;
    private final PersonType type;

    public Person(String name, int age, BigDecimal salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.type = PersonType.determineStrategyByPerson(this);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public PersonType getType() {
        return type;
    }

    @Override
    public String toString() {
        return name + " is " + type;
    }
}