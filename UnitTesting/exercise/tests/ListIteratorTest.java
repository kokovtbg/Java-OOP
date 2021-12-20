package UnitTesting.exercise.tests;

import UnitTesting.exercise.p03_IteratorTest.ListIterator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Scanner;

public class ListIteratorTest {
    private ListIterator listIteratorEmpty;
    private ListIterator listIteratorFull;
    private String[] elements;
    private final static int SIZE = 3;

    @Before
    public void initializeObjects() throws OperationNotSupportedException {
        this.listIteratorEmpty = new ListIterator();
        this.elements = new String[SIZE];
        this.listIteratorFull = new ListIterator(this.elements);
    }

    @Test(expected = IllegalStateException.class)
    public void printCommandThrowsExceptionWhenEmptyList() {
        this.listIteratorEmpty.print();
    }

    @Test
    public void moveCommandShouldBeTrueWhenNotLastElement() {
        Assert.assertTrue("Move command returns True when not last element", this.listIteratorFull.move());
    }

    @Test
    public void moveCommandShouldBeFalseWhenLastElement() {
        int countElements = SIZE;
        while (countElements > 0) {
            this.listIteratorFull.move();
            countElements--;
        }
        Assert.assertFalse("Move command should be False when on last element", this.listIteratorFull.move());
    }
}
