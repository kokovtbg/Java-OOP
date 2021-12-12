package Exams.Exam12April2020.halfLife;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTests {

    @Test(expected = NullPointerException.class)
    public void testCreatePlayerThrowsWhenNameNull() {
        Player player = new Player(null, 100);
    }

    @Test(expected = NullPointerException.class)
    public void testCreatePlayerThrowsWhenNameEmpty() {
        Player player = new Player("  ", 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateThrowsWhenHealthBelowZero() {
        Player player = new Player("Nikola", -1);
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamageThrowsWhenHealthEqualOrBelowZero() {
        Player player = new Player("Nikola", 0);
        player.takeDamage(2);
    }

    @Test
    public void testTakeDamageSuccessfulWhenHealthBecomesBelowZero() {
        Player player = new Player("Nikola", 1);
        player.takeDamage(2);
        Assert.assertEquals(0, player.getHealth());
    }

    @Test
    public void testTakeDamageSuccessfulWhenHealthAboveZero() {
        Player player = new Player("Nikola", 2);
        player.takeDamage(1);
        Assert.assertEquals(1, player.getHealth());
    }

    @Test(expected = NullPointerException.class)
    public void testAddGunThrowsWhenGunNull() {
        Player player = new Player("Nikola", 2);
        player.addGun(null);
    }

    @Test
    public void testAddGunSuccessful() {
        Player player = new Player("Nikola", 2);
        Gun gun = new Gun("Kalashnikov", 100);
        player.addGun(gun);
        Assert.assertEquals(gun, player.getGun("Kalashnikov"));
    }

    @Test
    public void testRemoveSuccessfulReturnsTrue() {
        Player player = new Player("Nikola", 2);
        Gun gun = new Gun("Kalashnikov", 100);
        player.addGun(gun);
        Assert.assertTrue(player.removeGun(gun));
    }

    @Test
    public void testRemoveUnsuccessfulReturnsFalse() {
        Player player = new Player("Nikola", 2);
        Gun gun = new Gun("Kalashnikov", 100);
        Assert.assertFalse(player.removeGun(gun));
    }

    @Test
    public void testGetGunReturnsNull() {
        Player player = new Player("Nikola", 2);
        Gun gun = new Gun("Kalashnikov", 100);
        player.addGun(gun);
        Assert.assertNull(player.getGun("Glock"));
    }
}
