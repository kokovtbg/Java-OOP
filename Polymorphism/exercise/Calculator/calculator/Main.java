package Polymorphism.exercise.Calculator.calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CalculationEngine engine = new CalculationEngine();
        InputInterpreter interpreter = Extensions.buildInterpreter(engine);
        MemorySave memorySave = new MemorySave();

        while (scanner.hasNext()) {
            String token = scanner.next();
            if (token.equals("end")) {
                break;
            }
            if (token.equals("ms")) {
                memorySave.setMemories(engine.getCurrentResult());
            } else if (token.equals("mr")) {
                interpreter.interpret(memorySave.recall());
            } else {
                interpreter.interpret(token);
            }
        }

        System.out.println(engine.getCurrentResult());
    }
}
