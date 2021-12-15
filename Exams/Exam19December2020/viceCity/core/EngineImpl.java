package Exams.Exam19December2020.viceCity.core;

import Exams.Exam19December2020.viceCity.common.Command;
import Exams.Exam19December2020.viceCity.core.interfaces.Controller;
import Exams.Exam19December2020.viceCity.core.interfaces.Engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private Controller controller;
    private BufferedReader reader;

    public EngineImpl(Controller controller) {
        this.controller = controller;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals(Command.Exit.name())) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String result = null;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
            case AddPlayer:
                result = addPlayer(data);
                break;
            case AddGun:
                result = addGun(data);
                break;
            case AddGunToPlayer:
                result = addGunToPlayer(data);
                break;
            case Fight:
                result = fight();
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }

        return result;
    }

    private String fight() {
        return controller.fight();
    }

    private String addGunToPlayer(String[] data) {
        return controller.addGunToPlayer(data[0]);
    }

    private String addGun(String[] data) {
        return controller.addGun(data[0], data[1]);
    }

    private String addPlayer(String[] data) {
        return controller.addPlayer(data[0]);
    }
}
