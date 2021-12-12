package Exams.Exam12April2020.CounterStriker.models.field;

import Exams.Exam12April2020.CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FieldImpl implements Field {
    private List<Player> terrorists;
    private List<Player> counterTerrorists;

    public FieldImpl() {
        this.terrorists = new ArrayList<>();
        this.counterTerrorists = new ArrayList<>();
    }

    @Override
    public String start(Collection<Player> players) {
        for (Player player : players) {
            if (player.getClass().getSimpleName().equals("Terrorist")) {
                terrorists.add(player);
            } else if (player.getClass().getSimpleName().equals("CounterTerrorist")) {
                counterTerrorists.add(player);
            }
        }
        for (Player terrorist : terrorists) {
            for (Player counterTerrorist : counterTerrorists) {
                if (terrorist.isAlive()) {
                    while (terrorist.getGun().fire() > 0 && counterTerrorist.isAlive()) {
                        terrorist.getGun().fire();
                        counterTerrorist.takeDamage(terrorist.getGun().fire());
                    }
                }
            }
        }
        for (Player counterTerrorist : counterTerrorists) {
            for (Player terrorist : terrorists) {
                if (counterTerrorist.isAlive()) {
                    while (counterTerrorist.getGun().fire() > 0 && terrorist.isAlive()) {
                        counterTerrorist.getGun().fire();
                        terrorist.takeDamage(counterTerrorist.getGun().fire());
                    }
                }
            }
        }
        boolean allTerroristsDead = true;
        for (Player terrorist : terrorists) {
            if (terrorist.isAlive()) {
                allTerroristsDead = false;
                break;
            }
        }
        if (allTerroristsDead) {
            return "Counter Terrorist wins!";
        }
        return "Terrorist wins!";
    }
}
