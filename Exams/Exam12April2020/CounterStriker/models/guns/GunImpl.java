package Exams.Exam12April2020.CounterStriker.models.guns;

import Exams.Exam12April2020.CounterStriker.common.ExceptionMessages;

public abstract class GunImpl implements Gun {
    private String name;
    private int bulletsCount;
    private int bulletsFired;

    public GunImpl(String name, int bulletsCount) {
        setName(name);
        setBulletsCount(bulletsCount);
    }

    protected void setBulletsFired(int bulletsFired) {
        this.bulletsFired  = bulletsFired;
    }
    private void setBulletsCount(int bulletsCount) {
        if (bulletsCount < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_GUN_BULLETS_COUNT);
        }
        this.bulletsCount = bulletsCount;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.INVALID_GUN_NAME);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getBulletsCount() {
        return bulletsCount;
    }

    @Override
    public int fire() {
        if (bulletsCount >= bulletsFired) {
            bulletsCount -= bulletsFired;
            return bulletsFired;
        }
        return 0;
    }
}
