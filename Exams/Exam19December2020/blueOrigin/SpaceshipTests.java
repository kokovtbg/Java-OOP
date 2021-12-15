package Exams.Exam19December2020.blueOrigin;

import org.junit.Assert;
import org.junit.Test;

public class SpaceshipTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Spaceship
    @Test
    public void testCreateSuccessful() {
        Spaceship spaceship = new Spaceship("Nikola", 10);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateThrowsExNullName() {
        Spaceship spaceship = new Spaceship(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateThrowsExEmptyName() {
        Spaceship spaceship = new Spaceship("  ", 19);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateThrowsExBelowZeroCapacity() {
        Spaceship spaceship = new Spaceship("Nikola", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddThrowsWhenFull() {
        Spaceship spaceship = new Spaceship("Nikola", 0);
        Astronaut astronaut = new Astronaut("Nikola", 10);
        spaceship.add(astronaut);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddThrowsWhenSameAstronaut() {
        Spaceship spaceship = new Spaceship("Nikola", 2);
        Astronaut astronaut = new Astronaut("Nikola", 10);
        spaceship.add(astronaut);
        spaceship.add(astronaut);
    }

    @Test
    public void testAddSuccessful() {
        Spaceship spaceship = new Spaceship("Nikola", 2);
        Astronaut astronaut = new Astronaut("Nikola", 10);
        spaceship.add(astronaut);
        Assert.assertEquals(1, spaceship.getCount());
    }

    @Test
    public void testRemoveSuccessful() {
        Spaceship spaceship = new Spaceship("Nikola", 2);
        Astronaut astronaut = new Astronaut("Nikola", 10);
        spaceship.add(astronaut);
        Assert.assertTrue(spaceship.remove(astronaut.getName()));
    }

    @Test
    public void testRemoveReturnsFalse() {
        Spaceship spaceship = new Spaceship("Nikola", 2);
        Astronaut astronaut = new Astronaut("Nikola", 10);
        spaceship.add(astronaut);
        Assert.assertFalse(spaceship.remove("Nikita"));
    }
}
