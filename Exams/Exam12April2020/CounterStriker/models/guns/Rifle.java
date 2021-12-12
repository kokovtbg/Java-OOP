package Exams.Exam12April2020.CounterStriker.models.guns;

public class Rifle extends GunImpl {
    private static final int BULLETS_FIRED_RIFLE = 10;

    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
        setBulletsFired(BULLETS_FIRED_RIFLE);
    }
}
