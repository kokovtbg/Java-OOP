package UnitTesting.lab.tests;

import UnitTesting.lab.Axe;
import UnitTesting.lab.Dummy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {
    private final static int ATTACK = 5;
    private final static int DURABILITY = 10;
    private final static int HEALTH = 100;
    private final static int XP = 100;
    private Axe axe;
    private Dummy dummy;

    @Before
    public void initializeObjects() {
        this.axe = new Axe(ATTACK, DURABILITY);
        this.dummy = new Dummy(HEALTH, XP);
    }

    @Test
    public void axeShouldLooseDurabilityAfterAttack() {
        axe.attack(dummy);
        Assert.assertEquals("Axe should loose durability", 9, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void brokenAxeCanNotAttack() {
        for (int i = 0; i <= DURABILITY; i++) {
            axe.attack(dummy);
        }
    }

}
