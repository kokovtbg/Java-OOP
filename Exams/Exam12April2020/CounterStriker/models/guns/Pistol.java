package Exams.Exam12April2020.CounterStriker.models.guns;

public class Pistol extends GunImpl {
    private static final int BULLETS_FIRED_PISTOL = 1;

    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
        setBulletsFired(BULLETS_FIRED_PISTOL);
    }
}
