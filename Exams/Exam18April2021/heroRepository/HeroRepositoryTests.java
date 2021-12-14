package Exams.Exam18April2021.heroRepository;

import org.junit.Assert;
import org.junit.Test;

public class HeroRepositoryTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS HeroRepository

    @Test(expected = NullPointerException.class)
    public void testHeroThrowsWhenCreated() {
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHeroThrowsIllExWhenCreated() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("Nikola", 50);
        Hero hero1 = new Hero("Nikola", 100);
        heroRepository.create(hero);
        heroRepository.create(hero1);
    }

    @Test
    public void testCreateHeroSuccessfulGetCount() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("Nikola", 50);
        heroRepository.create(hero);
        Assert.assertEquals(1, heroRepository.getCount());
    }

    @Test
    public void testCreateHeroSuccessfulPrintMessage() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("Nikola", 50);
        Assert.assertEquals(String.format("Successfully added hero %s with level %d", "Nikola", 50), heroRepository.create(hero));
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveThrowsNPEWhenNameNull() {
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveThrowsNullPEWhenNameEmpty() {
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.remove("   ");
    }

    @Test
    public void testRemoveReturnsTrue() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("Nikola", 50);
        heroRepository.create(hero);
        Assert.assertTrue(heroRepository.remove("Nikola"));
    }

    @Test
    public void testRemoveReturnsFalse() {
        HeroRepository heroRepository = new HeroRepository();
        Assert.assertFalse(heroRepository.remove("Nikola"));
    }

    @Test
    public void testGetHeroWithHighestLevelReturnsHero() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("Nikola", 50);
        heroRepository.create(hero);
        Assert.assertEquals(hero, heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void testGetHeroWithHighestLevelReturnsNull() {
        HeroRepository heroRepository = new HeroRepository();
        Assert.assertNull(heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void testGetHeroReturnsHero() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("Nikola", 50);
        heroRepository.create(hero);
        Assert.assertEquals(hero, heroRepository.getHero("Nikola"));
    }

    @Test
    public void testGetHeroReturnsNull() {
        HeroRepository heroRepository = new HeroRepository();
        Assert.assertNull(heroRepository.getHero("Nikola"));
    }
}
