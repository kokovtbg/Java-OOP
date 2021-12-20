package WorkingWithAbstraction.exercise.TrafficLights;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] lights = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < lights.length; j++) {
                lights[j] = TrafficLight.changeLight(lights[j]);
            }
            System.out.println();
        }
    }
}
