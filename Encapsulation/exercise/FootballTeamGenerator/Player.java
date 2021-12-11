package Encapsulation.exercise.FootballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;
    private boolean validStats = true;

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            validStats = false;
            System.out.println("A name should not be empty.");
        } else {
            this.name = name;
        }
    }

    private void setEndurance(int endurance) {
        if (endurance < 0 || endurance > 100) {
            validStats = false;
            System.out.println("Endurance should be between 0 and 100.");
        } else {
            this.endurance = endurance;
        }
    }

    private void setSprint(int sprint) {
        if (sprint < 0 || sprint > 100) {
            validStats = false;
            System.out.println("Sprint should be between 0 and 100.");
        } else {
            this.sprint = sprint;
        }
    }

    private void setDribble(int dribble) {
        if (dribble < 0 || dribble > 100) {
            validStats = false;
            System.out.println("Dribble should be between 0 and 100.");
        } else {
            this.dribble = dribble;
        }
    }

    private void setPassing(int passing) {
        if (passing < 0 || passing > 100) {
            validStats = false;
            System.out.println("Passing should be between 0 and 100.");
        } else {
            this.passing = passing;
        }
    }

    private void setShooting(int shooting) {
        if (shooting < 0 || shooting > 100) {
            validStats = false;
            System.out.println("Shooting should be between 0 and 100.");
        } else {
            this.shooting = shooting;
        }
    }

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    public boolean getValidStats() {
        return this.validStats;
    }

    public String getName() {
        return this.name;
    }

    public double overallSkillLevel() {
        return (this.endurance + this.sprint + this.dribble + this.passing + this.shooting) * 1.0 / 5;
    }
}
