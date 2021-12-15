package Exams.Exam19December2020.viceCity;

import Exams.Exam19December2020.viceCity.core.ControllerImpl;
import Exams.Exam19December2020.viceCity.core.EngineImpl;
import Exams.Exam19December2020.viceCity.core.interfaces.Controller;
import Exams.Exam19December2020.viceCity.core.interfaces.Engine;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
