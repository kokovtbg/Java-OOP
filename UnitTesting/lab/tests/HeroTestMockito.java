package UnitTesting.lab.tests;

import UnitTesting.lab.Hero;
import UnitTesting.lab.Target;
import UnitTesting.lab.Weapon;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTestMockito {
    private final static String HERO_NAME = "Niko";
    private final static int TARGET_XP = 100;

    @Test
    public void attackGainsExperienceIfTargetIsDead() {
        Weapon weaponMock = Mockito.mock(Weapon.class);
        Target targetMock = Mockito.mock(Target.class);

        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_XP);

        Hero hero = new Hero(HERO_NAME, weaponMock);
        hero.attack(targetMock);

        Assert.assertEquals("Wrong experience", TARGET_XP, hero.getExperience());
    }
}
