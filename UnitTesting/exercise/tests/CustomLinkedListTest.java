package UnitTesting.exercise.tests;

import UnitTesting.exercise.p05_CustomLinkedList.CustomLinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomLinkedListTest {
    private CustomLinkedList<Integer> linkedList;
    private final static Integer NUMBER_TO_MANIPULATE = 1;
    private final static int INDEX_TO_MANIPULATE = 0;

    @Before
    public void initializeObjects() {
        this.linkedList = new CustomLinkedList<>();
    }

    @Test
    public void getOperationTest() {
        this.linkedList.add(NUMBER_TO_MANIPULATE);
        Assert.assertEquals("Numbers should match", NUMBER_TO_MANIPULATE, linkedList.get(INDEX_TO_MANIPULATE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getOperationThrowsExceptionWhenEmpty() {
        this.linkedList.get(INDEX_TO_MANIPULATE);
    }

    @Test
    public void setOperationTest() {
        this.linkedList.add(INDEX_TO_MANIPULATE);
        this.linkedList.set(INDEX_TO_MANIPULATE, NUMBER_TO_MANIPULATE);
        Assert.assertEquals("Numbers should match", NUMBER_TO_MANIPULATE, linkedList.get(INDEX_TO_MANIPULATE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setOperationThrowsException() {
        this.linkedList.add(NUMBER_TO_MANIPULATE);
        this.linkedList.set(NUMBER_TO_MANIPULATE, NUMBER_TO_MANIPULATE);
    }

    @Test
    public void addOperationTest() {
        this.linkedList.add(NUMBER_TO_MANIPULATE);
        Assert.assertEquals("Numbers should match", NUMBER_TO_MANIPULATE, linkedList.get(INDEX_TO_MANIPULATE));
    }

    @Test
    public void removeAtOperationTest() {
        this.linkedList.add(NUMBER_TO_MANIPULATE);
        Assert.assertEquals("Numbers should match", NUMBER_TO_MANIPULATE, linkedList.removeAt(INDEX_TO_MANIPULATE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeAtOperationThrowsException() {
        this.linkedList.removeAt(INDEX_TO_MANIPULATE);
    }

    @Test
    public void removeOperationTest() {
        this.linkedList.add(NUMBER_TO_MANIPULATE);
        Assert.assertEquals("Index should be as given", INDEX_TO_MANIPULATE, linkedList.remove(NUMBER_TO_MANIPULATE));
    }

    @Test
    public void removeOperationTestOnNotPresentElement() {
        Assert.assertEquals("Index should be as given", -NUMBER_TO_MANIPULATE, linkedList.remove(NUMBER_TO_MANIPULATE));
    }

    @Test
    public void indexOfOperationTest() {
        this.linkedList.add(NUMBER_TO_MANIPULATE);
        Assert.assertEquals("Index should be as given", INDEX_TO_MANIPULATE, linkedList.indexOf(NUMBER_TO_MANIPULATE));
    }

    @Test
    public void indexOfOperationOnNotPresentElement() {
        Assert.assertEquals("Index should be as given", -NUMBER_TO_MANIPULATE, linkedList.indexOf(NUMBER_TO_MANIPULATE));
    }

    @Test
    public void containsOperationTest() {
        this.linkedList.add(NUMBER_TO_MANIPULATE);
        Assert.assertTrue("Number should be present", linkedList.contains(NUMBER_TO_MANIPULATE));
    }
}
