package Exams.Exam16August2020.onlineShop;

import Exams.Exam16August2020.onlineShop.core.EngineImpl;
import Exams.Exam16August2020.onlineShop.core.interfaces.Engine;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
