package UnitTesting.lab.tests;

import UnitTesting.lab.*;
import org.junit.Assert;
import org.junit.Test;


public class HeroTest {
    private final static String HERO_NAME = "Niko";
    private final static int WEAPON_ATTACK = 100;
    private final static int TARGET_XP = 100;
    @Test
    public void heroGetsXPWhenTargetDies() {
        Weapon fakeWeapon = new Weapon() {
            @Override
            public void attack(Target target) {

            }

            @Override
            public int getAttackPoints() {
                return WEAPON_ATTACK;
            }

            @Override
            public int getDurabilityPoints() {
                return 0;
            }
        };
        Target fakeTarget = new Target() {
            @Override
            public void takeAttack(int attackPoints) {

            }

            @Override
            public int getHealth() {
                return 0;
            }

            @Override
            public int giveExperience() {
                return TARGET_XP;
            }

            @Override
            public boolean isDead() {
                return true;
            }
        };

        Hero hero = new Hero(HERO_NAME, fakeWeapon);
        hero.attack(fakeTarget);
        Assert.assertEquals("XP must be " + TARGET_XP, TARGET_XP, hero.getExperience());
    }
}
