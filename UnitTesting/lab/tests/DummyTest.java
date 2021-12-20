package UnitTesting.lab.tests;

import UnitTesting.lab.Dummy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {
    private final static int HEALTH = 100;
    private final static int XP = 100;
    private final static int ATTACK_POINTS = 10;
    private final static int ATTACK_CONSTANT = 10;
    private Dummy dummy;

    @Before
    public void initializeObject() {
        this.dummy = new Dummy(HEALTH, XP);
    }

    @Test
    public void dummyLoosesHealthWhenAttacked() {
        dummy.takeAttack(ATTACK_POINTS);

        Assert.assertEquals("Health must be " + (HEALTH - ATTACK_POINTS),HEALTH - ATTACK_POINTS, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsException() {
        dummy.takeAttack(ATTACK_POINTS * ATTACK_CONSTANT);
    }

    @Test
    public void deadDummyCanGiveXP() {
        dummy.takeAttack(ATTACK_POINTS * ATTACK_CONSTANT);
        Assert.assertEquals("Dead Dummy must give XP", XP, dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCanNotGiveXP() {
        dummy.giveExperience();
    }
}
