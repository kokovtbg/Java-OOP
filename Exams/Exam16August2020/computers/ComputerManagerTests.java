package Exams.Exam16August2020.computers;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ComputerManagerTests {

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerThrowsWhenNull() {
        ComputerManager computerManager = new ComputerManager();
        computerManager.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerThrowsWhenComputerExist() {
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Acer", "ASD", 9);
        computerManager.addComputer(computer);
        Computer computer1 = new Computer("Acer", "ASD", 10);
        computerManager.addComputer(computer1);
    }

    @Test
    public void testAddComputerSuccessful() {
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Acer", "ASD", 9);
        computerManager.addComputer(computer);
        Assert.assertEquals(1, computerManager.getCount());
        Assert.assertEquals(computer, computerManager.getComputer("Acer", "ASD"));
        for (Computer computerEntry : computerManager.getComputers()) {
            Assert.assertEquals(computer, computerEntry);
        }
    }

    @Test
    public void testRemoveComputerSuccessful() {
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Acer", "ASD", 9);
        computerManager.addComputer(computer);
        Assert.assertEquals(computer, computerManager.removeComputer("Acer", "ASD"));
        Assert.assertEquals(0, computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerThrowsWhenNullManufacturer() {
        ComputerManager computerManager = new ComputerManager();
        computerManager.getComputer(null, "ASD");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerThrowsWhenNullModel() {
        ComputerManager computerManager = new ComputerManager();
        computerManager.getComputer("Acer", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerThrowsWhenManufacturerNotPresent() {
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Acer", "ASD", 9);
        computerManager.addComputer(computer);
        computerManager.getComputer("Asus", "ASD");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerThrowsWhenModelNotPresent() {
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Acer", "ASD", 9);
        computerManager.addComputer(computer);
        computerManager.getComputer("Acer", "PPP");
    }

    @Test
    public void testGetComputerSuccessful() {
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Acer", "ASD", 9);
        computerManager.addComputer(computer);
        Assert.assertEquals(computer, computerManager.getComputer("Acer", "ASD"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputersByManufacturerThrowsWhenNullManufacturer() {
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Acer", "ASD", 9);
        computerManager.addComputer(computer);
        computerManager.getComputersByManufacturer(null);
    }

    @Test
    public void testGetComputersByManufacturerSuccessful() {
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Acer", "ASD", 9);
        computerManager.addComputer(computer);
        List<Computer> computers = new ArrayList<>();
        computers.add(computer);
        Assert.assertEquals(computers, computerManager.getComputersByManufacturer("Acer"));
    }
}