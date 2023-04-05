package sky.pro.java.collectionsandsets;

import java.util.Objects;

public class Employee {
    /*
    Перенести из курсовой класс Employee, оставив в нем только поля firstName и lastName, конструктор, геттеры
    и методы hashCode, equals, toString.
     */

    private String firstName;
    private String lastName;


    // Формирование конструктора
    public Employee(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    // Создание геттеров для всех полей

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }


    // Переопределение метода toString для класса Employee
    @Override
    public String toString() {
        return "Ф.И.О сотрудника: " + firstName + " " + lastName + "\n";
    }

    // Переопределение метода equals для класса Employee
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    // Переопределение метода hashCode для класса Employee
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}


