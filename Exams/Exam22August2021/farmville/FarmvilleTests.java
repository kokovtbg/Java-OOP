package Exams.Exam22August2021.farmville;

import org.junit.Assert;
import org.junit.Test;

public class FarmvilleTests {

    @Test
    public void testConstructorShouldCreateFarm() {
        String name = "Cow farm";
        int capacity = 5;
        Farm farm = new Farm(name, capacity);
        Assert.assertEquals(name, farm.getName());
        Assert.assertEquals(capacity, farm.getCapacity());
        Assert.assertEquals(0 , farm.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorThrowsWhenNameNull() {
        Farm farm = new Farm(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorThrowsWhenEmptyName() {
        Farm farm = new Farm("  ", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorThrowsWhenNegativeCapacity() {
        Farm farm = new Farm("Nikola", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddThrowsWhenReachedCapacity() {
        Farm farm = new Farm("Nikola", 0);
        farm.add(new Animal("Nikola", 10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddThrowsWhenAnimalExist() {
        Farm farm = new Farm("Farm", 10);
        farm.add(new Animal("Chicken", 5));
        farm.add(new Animal("Chicken", 11));
    }

    @Test
    public void testAddSuccessful() {
        Farm farm = new Farm("Farm", 10);
        Assert.assertEquals(10, farm.getCapacity());
        Assert.assertEquals(0, farm.getCount());
        farm.add(new Animal("Chicken", 10));
        Assert.assertEquals(10, farm.getCapacity());
        Assert.assertEquals(1, farm.getCount());
    }

    @Test
    public void testRemoveReturnsFalse() {
        Farm farm = new Farm("Farm", 10);
        Assert.assertFalse(farm.remove("Cow"));
    }

    @Test
    public void testRemoveReturnsTrue() {
        Farm farm = new Farm("Farm", 10);
        Animal animal = new Animal("Cow", 5);
        farm.add(animal);
        Assert.assertTrue(farm.remove("Cow"));
    }
}
