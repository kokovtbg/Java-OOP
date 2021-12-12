package Exams.Exam12April2020.CounterStriker.repositories;

import Exams.Exam12April2020.CounterStriker.common.ExceptionMessages;
import Exams.Exam12April2020.CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;

public class PlayerRepository implements Repository<Player> {
    private Collection<Player> models;

    public PlayerRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Player> getModels() {
        return this.models;
    }

    @Override
    public void add(Player player) {
        if (player == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_PLAYER_REPOSITORY);
        }
        this.models.add(player);
    }

    @Override
    public boolean remove(Player player) {
        return this.models.remove(player);
    }

    @Override
    public Player findByName(String name) {
        return this.models.stream().filter(p -> p.getUsername().equals(name)).findFirst().orElse(null);
    }
}
