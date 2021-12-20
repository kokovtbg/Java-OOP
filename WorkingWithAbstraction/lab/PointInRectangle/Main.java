package WorkingWithAbstraction.lab.PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] coordinatesRectangle = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Point pointBottomLeft = new Point(coordinatesRectangle[0], coordinatesRectangle[1]);
        Point pointTopRight = new Point(coordinatesRectangle[2], coordinatesRectangle[3]);
        Rectangle rectangle = new Rectangle(pointBottomLeft, pointTopRight);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            int[] coordinates = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            Point point = new Point(coordinates[0], coordinates[1]);
            System.out.println(rectangle.contains(point));
        }
    }
}
