package Exams.Exam12April2020.CounterStriker.models.players;

import Exams.Exam12April2020.CounterStriker.models.guns.Gun;

public interface Player {
    String getUsername();

    int getHealth();

    int getArmor();

    Gun getGun();

    boolean isAlive();

    void takeDamage(int points);
}
