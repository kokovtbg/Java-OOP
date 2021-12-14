package Exams.Exam18April2021.spaceStation.models.astronauts;

public class Meteorologist extends BaseAstronaut {
    private static final double INITIAL_OXYGEN = 90;

    public Meteorologist(String name) {
        super(name, INITIAL_OXYGEN);
    }
}
