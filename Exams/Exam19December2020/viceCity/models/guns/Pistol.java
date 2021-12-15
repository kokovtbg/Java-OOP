package Exams.Exam19December2020.viceCity.models.guns;

public class Pistol extends BaseGun {
    private static final int INITIAL_BULLETS_PER_BARREL = 10;
    private static final int INITIAL_TOTAL_BULLETS = 100;
    private static final int INITIAL_BULLETS_FIRED = 1;

    public Pistol(String name) {
        super(name, INITIAL_BULLETS_PER_BARREL, INITIAL_TOTAL_BULLETS);
        setBulletsFired(INITIAL_BULLETS_FIRED);
        setBulletsInBarrel(INITIAL_BULLETS_PER_BARREL);
    }

}
