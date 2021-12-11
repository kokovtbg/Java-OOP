package Encapsulation.lab.FirstAndReserveTeam;

import java.text.DecimalFormat;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public void setFirstName(String firstname) {
        if (firstname.length() < 3) {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstname;
    }

    public void setLastName(String lastname) {
        if (lastname.length() < 3) {
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastname;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    public Person(String firstname, String lastname, int age, double salary) {
        setFirstName(firstname);
        setLastName(lastname);
        setAge(age);
        setSalary(salary);
    }

    public int getAge() {
        return age;
    }

    public String getFirstname() {
        return firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public double getSalary() {
        return salary;
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
            return String.format("%s %s gets %.1f leva", this.getFirstname(), this.getLastname(), this.getSalary());
        }
        return String.format("%s %s gets %s leva", this.getFirstname(), this.getLastname(), decimalFormat.format(this.getSalary()));
    }
}
