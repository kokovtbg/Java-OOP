package Encapsulation.lab.IncreaseSalary;

import java.text.DecimalFormat;

public class Person {
    private String firstname;
    private String  lastname;
    private int age;
    private double salary;

    public Person(String firstname, String lastname, int age, double salary) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double bonus) {
        if (this.getAge() >= 30) {
            this.salary = (100 + bonus) / 100 * this.salary;
        } else {
            this.salary = (100 + bonus / 2) / 100 * this.salary;
        }
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        if (!decimalFormat.format(this.salary).contains(",")) {
            return String.format("%s %s gets %.1f leva", this.getFirstname(), this.getLastname(), this.salary);
        }
        return String.format("%s %s gets %s leva", this.getFirstname(), this.getLastname(), decimalFormat.format(this.salary));
    }
}
