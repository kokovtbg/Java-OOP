package Exams.Exam22August2021.glacialExpedition;

import Exams.Exam22August2021.glacialExpedition.core.Controller;
import Exams.Exam22August2021.glacialExpedition.core.ControllerImpl;
import Exams.Exam22August2021.glacialExpedition.core.Engine;
import Exams.Exam22August2021.glacialExpedition.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
