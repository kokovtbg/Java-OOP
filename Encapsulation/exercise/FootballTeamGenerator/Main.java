package Encapsulation.exercise.FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        List<Team> teams = new ArrayList<>();
        while (!input.equals("END")) {
            String[] data = input.split(";");
            String command = data[0];
            if (command.equals("Team")) {
                Team team = new Team(data[1]);
                teams.add(team);
            } else if (command.equals("Add")) {
                String teamName = data[1];
                String playerName = data[2];
                int endurance = Integer.parseInt(data[3]);
                int sprint = Integer.parseInt(data[4]);
                int dribble = Integer.parseInt(data[5]);
                int passing = Integer.parseInt(data[6]);
                int shooting = Integer.parseInt(data[7]);
                boolean teamExists = false;
                for (int i = 0; i < teams.size(); i++) {
                    if (teams.get(i).getName().equals(teamName)) {
                        teamExists = true;
                        break;
                    }
                }
                if (!teamExists) {
                    System.out.printf("Team %s does not exist.%n", teamName);
                    input = scan.nextLine();
                    continue;
                }
                Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                if (player.getValidStats()) {
                    for (int i = 0; i < teams.size(); i++) {
                        if (teams.get(i).getName().equals(teamName)) {
                            teams.get(i).addPlayer(player);
                        }
                    }
                }
            } else if (command.equals("Remove")) {
                String teamName = data[1];
                String playerName = data[2];
                for (int i = 0; i < teams.size(); i++) {
                    if (teams.get(i).getName().equals(teamName)) {
                        teams.get(i).removePlayer(playerName);
                    }
                }
            } else if (command.equals("Rating")) {
                String teamName = data[1];
                boolean teamExists = false;
                for (int i = 0; i < teams.size(); i++) {
                    if (teams.get(i).getName().equals(teamName)) {
                        teamExists = true;
                        System.out.printf("%s - %.0f%n", teamName, teams.get(i).getRating());
                        break;
                    }
                }
                if (!teamExists) {
                    System.out.printf("Team %s does not exist.%n", teamName);
                }
            }

            input = scan.nextLine();
        }
    }
}
