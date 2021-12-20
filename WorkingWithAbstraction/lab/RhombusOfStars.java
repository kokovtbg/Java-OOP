package WorkingWithAbstraction.lab;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        printRhombus(n);
    }

    private static void printRhombus(int n) {
        printRow(n);
    }

    private static void printRow(int n) {
        StringBuilder builder = new StringBuilder();
        int number = 1;

        while (number < n) {
            builder.append(" ".repeat(n - number));
            for (int i = 1; i <= number; i++) {
                builder.append("* ");
            }
            builder.append(System.lineSeparator());
            number++;
        }
        for (int j = 1; j <= n; j++) {
            builder.append("* ");
        }
        builder.append(System.lineSeparator());
        while (number > 1) {
            builder.append(" ".repeat(n - number + 1));
            for (int i = 1; i < number; i++) {
                builder.append("* ");
            }
            builder.append(System.lineSeparator());
            number--;
        }
        System.out.print(builder);
    }
}
