package Exams.Exam19December2020.blueOrigin;

public class Astronaut {
    private String name;
    private double oxygenInPercentage;

    public Astronaut(String name, double oxygenInPercentage) {
        this.name = name;
        this.oxygenInPercentage = oxygenInPercentage;
    }

    public String getName() {
        return this.name;
    }

    public double getOxygenInPercentage() {
        return this.oxygenInPercentage;
    }
}
