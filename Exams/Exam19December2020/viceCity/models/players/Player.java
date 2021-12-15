package Exams.Exam19December2020.viceCity.models.players;

import Exams.Exam19December2020.viceCity.models.guns.Gun;
import Exams.Exam19December2020.viceCity.repositories.interfaces.Repository;

public interface Player {
    String getName();

    int getLifePoints();

    boolean isAlive();

    Repository<Gun> getGunRepository();

    void takeLifePoints(int points);
}
