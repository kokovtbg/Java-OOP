package Exams.Exam19December2020.viceCity.models.guns;

import Exams.Exam19December2020.viceCity.common.ExceptionMessages;

public abstract class BaseGun implements Gun {
    private String name;
    private int bulletsPerBarrel;
    private int totalBullets;
    private boolean canFire;
    private int bulletsFired;
    private int bulletsInBarrel;

    public BaseGun(String name, int bulletsPerBarrel, int totalBullets) {
        setName(name);
        setBulletsPerBarrel(bulletsPerBarrel);
        setTotalBullets(totalBullets);
        canFire = true;
        this.bulletsInBarrel = bulletsPerBarrel;
    }

    protected void setBulletsInBarrel(int bulletsInBarrel) {
        this.bulletsInBarrel = bulletsPerBarrel;
    }

    protected void setBulletsFired(int bulletsFired) {
        this.bulletsFired = bulletsFired;
    }

    private void setTotalBullets(int totalBullets) {
        if (totalBullets < 0) {
            throw new IllegalArgumentException(ExceptionMessages.TOTAL_BULLETS_LESS_THAN_ZERO);
        }
        this.totalBullets = totalBullets;
    }

    private void setBulletsPerBarrel(int bulletsPerBarrel) {
        if (bulletsPerBarrel < 0) {
            throw new IllegalArgumentException(ExceptionMessages.BULLETS_LESS_THAN_ZERO);
        }
        this.bulletsPerBarrel = bulletsPerBarrel;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.NAME_NULL);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getBulletsPerBarrel() {
        return bulletsPerBarrel;
    }

    @Override
    public boolean canFire() {
        return canFire;
    }

    @Override
    public int getTotalBullets() {
        return totalBullets;
    }

    @Override
    public int fire() {
        if (bulletsFired <= bulletsInBarrel) {
            bulletsInBarrel -= bulletsFired;
            return bulletsFired;
        } else {
            while (totalBullets > 0 && bulletsInBarrel < bulletsPerBarrel) {
                totalBullets--;
                bulletsInBarrel++;
            }
            if (bulletsFired <= bulletsInBarrel) {
                bulletsInBarrel -= bulletsFired;
                return bulletsFired;
            }
        }
        canFire = false;
        return 0;
    }
}
