package Encapsulation.exercise.FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            System.out.println("A name should not be empty.");
        } else {
            this.name = name;
        }
    }

    public Team(String name) {
        setName(name);
        this.players = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String name) {
        boolean playerExists = false;
        for (int i = 0; i < this.players.size(); i++) {
            if (this.players.get(i).getName().equals(name)) {
                this.players.remove(this.players.get(i));
                playerExists = true;
            }
        }
        if (!playerExists) {
            System.out.printf("Player %s is not in %s team.%n", name, this.name);
        }
    }

    public double getRating() {
        double rating = 0;
        for (int i = 0; i < this.players.size(); i++) {
            rating += this.players.get(i).overallSkillLevel();
        }
        if (this.players.size() != 0) {
            return rating / this.players.size();
        } else {
            return 0;
        }
    }
}
