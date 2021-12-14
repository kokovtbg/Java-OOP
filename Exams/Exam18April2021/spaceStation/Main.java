package Exams.Exam18April2021.spaceStation;

import Exams.Exam18April2021.spaceStation.core.Controller;
import Exams.Exam18April2021.spaceStation.core.ControllerImpl;
import Exams.Exam18April2021.spaceStation.core.Engine;
import Exams.Exam18April2021.spaceStation.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
