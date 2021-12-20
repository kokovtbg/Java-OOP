package WorkingWithAbstraction.lab.StudentSystem;

public class Student {
    private String name;
    private int age;
    private double grade;
    private String commentary;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        if (this.grade >= 5.00) {
            this.commentary = "Excellent student";
        } else if (this.grade < 5.00 && this.grade >= 3.50) {
            this.commentary = "Average student";
        } else {
            this.commentary =  "Very nice person";
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCommentary() {
        return commentary;
    }

}
