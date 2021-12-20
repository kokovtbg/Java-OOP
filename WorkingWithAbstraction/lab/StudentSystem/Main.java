package WorkingWithAbstraction.lab.StudentSystem;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<Student> students = new HashSet<>();
        String command = scan.nextLine();
        while (!command.equals("Exit")) {
            String[] data = command.split("\\s+");
            String input = data[0];
            if (input.equals("Create")) {
                Student student = new Student(data[1], Integer.parseInt(data[2]), Double.parseDouble(data[3]));
                students.add(student);
            } else if (input.equals("Show")) {
                String name = data[1];
                for (Student student : students) {
                    if (student.getName().equals(name)) {
                        System.out.printf("%s is %d years old. %s.%n", student.getName(), student.getAge(), student.getCommentary());
                    }
                }
            }

            command = scan.nextLine();
        }
    }
}
