package UnitTesting.exercise.tests;


import UnitTesting.exercise.p04_BubbleSortTest.Bubble;
import org.junit.Assert;
import org.junit.Test;


public class BubbleSortTest {

    @Test
    public void testOne() {
        int[] array = {1, 2, 3};
        Bubble.sort(array);
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = array[i];
        }
        for (int i = 0; i < array.length; i++) {
            Assert.assertEquals(sortedArray[i], array[i]);
        }

    }

    @Test
    public void testTwo() {
        int[] array = {3, 2, 1};
        Bubble.sort(array);
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = array[i];
        }
        for (int i = 0; i < array.length; i++) {
            Assert.assertEquals(sortedArray[i], array[i]);
        }
    }

    @Test
    public void testThree() {
        int[] array = {2, 0, -1, 2, 1};
        Bubble.sort(array);
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = array[i];
        }
        for (int i = 0; i < array.length; i++) {
            Assert.assertEquals(sortedArray[i], array[i]);
        }
    }
}
