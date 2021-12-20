package WorkingWithAbstraction.exercise.JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] galaxy = Galaxy.drawGalaxy(rows, cols);
        long sum = 0;
        String input = scan.nextLine();
        while (!input.equals("Let the Force be with you")) {
            int[] dimensionsPlayer = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int playerRow = dimensionsPlayer[0];
            int playerCol = dimensionsPlayer[1];
            int[] dimensionsEvil = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int evilRow = dimensionsEvil[0];
            int evilCol = dimensionsEvil[1];
            Galaxy.moveEvil(galaxy, evilRow, evilCol);
            sum += Galaxy.movePlayer(galaxy, playerRow, playerCol);

            input = scan.nextLine();
        }
        System.out.println(sum);
    }
}
