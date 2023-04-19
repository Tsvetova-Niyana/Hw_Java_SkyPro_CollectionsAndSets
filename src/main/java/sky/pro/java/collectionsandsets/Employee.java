package sky.pro.java.collectionsandsets;

import java.util.Objects;

public class Employee {
    /*
    Перенести из курсовой класс Employee, оставив в нем только поля firstName и lastName, конструктор, геттеры
    и методы hashCode, equals, toString.
     */

    /*
    Шаг 1. Добавить в поле Employee поля «Зарплата» и «Отдел» из курсовой работы.
     */

    private String firstName;
    private String lastName;
    private int department;
    private double salaryEmploy;


    // Формирование конструктора
    public Employee(String lastName, String firstName, int department, double salaryEmploy) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.department = department;
        this.salaryEmploy = salaryEmploy;
    }

    // Создание геттеров для всех полей

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getDepartment() {
        return this.department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public double getSalaryEmploy() {
        return this.salaryEmploy;
    }

    public void setSalaryEmploy(double salaryEmploy) {
        this.salaryEmploy = salaryEmploy;
    }

    // Переопределение метода toString для класса Employee
    @Override
    public String toString() {
        return "Ф.И.О сотрудника: " + firstName + " " + lastName + "\n"+
                "отдел :" + department +
                "\nЗарплата: " + salaryEmploy;
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


