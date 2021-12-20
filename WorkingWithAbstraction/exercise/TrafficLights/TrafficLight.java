package WorkingWithAbstraction.exercise.TrafficLights;

public class TrafficLight {
    enum Light {
        RED(0), GREEN(1), YELLOW(2);
        private int value;

        Light(int value) {
            this.value = value;
        }
        public int getValue() {
            return this.value;
        }
    }
    public static String changeLight(String light) {
        if (Light.valueOf(light) == Light.RED) {
            light = "GREEN";
            System.out.print(Light.GREEN + " ");
        } else if (Light.valueOf(light) == Light.GREEN) {
            light = "YELLOW";
            System.out.print(Light.YELLOW + " ");
        } else {
            light = "RED";
            System.out.print(Light.RED + " ");
        }
        return light;
    }
}
