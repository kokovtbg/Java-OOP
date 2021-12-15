package Exams.Exam19December2020.viceCity.models.guns;

public class Rifle extends BaseGun {
    private static final int INITIAL_BULLETS_PER_BARREL = 50;
    private static final int INITIAL_TOTAL_BULLETS = 500;
    private static final int INITIAL_BULLETS_FIRED = 5;

    public Rifle(String name) {
        super(name, INITIAL_BULLETS_PER_BARREL, INITIAL_TOTAL_BULLETS);
        setBulletsFired(INITIAL_BULLETS_FIRED);
        setBulletsInBarrel(INITIAL_BULLETS_PER_BARREL);
    }
}
