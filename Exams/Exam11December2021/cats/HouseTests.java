package Exams.Exam11December2021.cats;

import org.junit.Assert;
import org.junit.Test;

public class HouseTests {

    @Test(expected = NullPointerException.class)
    public void testCreateHouseThrowsOnNullName() {
        House house = new House(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateHouseThrowsOnEmptyName() {
        House house = new House("  ", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateHouseThrowsOnNegativeCapacity() {
        House house = new House("CatHouse", -1);
    }

    @Test
    public void testCreateHouseSuccessful() {
        House house = new House("CatHouse", 10);
        Assert.assertEquals("CatHouse", house.getName());
        Assert.assertEquals(10, house.getCapacity());
        Assert.assertEquals(0, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatThrowsWhenReachedCapacity() {
        House house = new House("CatHouse", 0);
        house.addCat(new Cat("Nikola"));
    }

    @Test
    public void testAddCatSuccessful() {
        House house = new House("CatHouse", 10);
        Assert.assertEquals(0, house.getCount());
        Assert.assertEquals(10, house.getCapacity());
        house.addCat(new Cat("Nikola"));
        Assert.assertEquals(1, house.getCount());
        Assert.assertEquals(10, house.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatThrowsWhenNoSuchCat() {
        House house = new House("CatHouse", 10);
        house.removeCat("Nikola");
    }

    @Test
    public void testRemoveCatSuccessful() {
        House house = new House("CatHouse", 10);
        Cat cat = new Cat("Nikola");
        Assert.assertEquals(0, house.getCount());
        Assert.assertEquals(10, house.getCapacity());
        house.addCat(cat);
        Assert.assertEquals(1, house.getCount());
        Assert.assertEquals(10, house.getCapacity());
        house.removeCat("Nikola");
        Assert.assertEquals(0, house.getCount());
        Assert.assertEquals(10, house.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleThrowsIfNoCatIsFound() {
        House house = new House("CatHouse", 10);
        house.catForSale("Nikola");
    }

    @Test
    public void testCatForSaleSuccessful() {
        House house = new House("CatHouse", 10);
        Cat cat = new Cat("Nikola");
        house.addCat(cat);
        Assert.assertTrue(cat.isHungry());
        house.catForSale("Nikola");
        Assert.assertFalse(cat.isHungry());
    }

    @Test
    public void testStatistics() {
        House house = new House("CatHouse", 10);
        Cat cat = new Cat("Nikola");
        house.addCat(cat);
        Assert.assertEquals("The cat Nikola is in the house CatHouse!", house.statistics());
    }
}
