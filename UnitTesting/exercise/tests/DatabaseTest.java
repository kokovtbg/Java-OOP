package UnitTesting.exercise.tests;


import UnitTesting.exercise.p01_Database.Database;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class DatabaseTest {
    private final static int CAPACITY = 16;
    private final static int INITIAL_SIZE = 10;
    private final static Integer NUMBER_TO_ADD = 1;

    Integer[] integers = new Integer[INITIAL_SIZE];

    @Test
    public void arrayLengthToBeLikeInitial() {
        try {
            Class<Database> databaseClass = Database.class;
            Object database = databaseClass.getDeclaredConstructor(Integer[].class).newInstance((Object) integers);
            Field elementsField = databaseClass.getDeclaredField("elements");
            elementsField.setAccessible(true);
            Integer[] elements = (Integer[]) elementsField.get(database);
            Assert.assertEquals("Capacity should be as given", CAPACITY, elements.length);
        } catch (InstantiationException |
                InvocationTargetException |
                NoSuchMethodException |
                IllegalAccessException |
                NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addOperationAddingAtNextFreeCell() {
        Database database = null;
        try {
            database = new Database(integers);
            database.add(NUMBER_TO_ADD);
        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("Number must equals given", NUMBER_TO_ADD, database.getElements()[0]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addOperationShouldThrowException() throws OperationNotSupportedException {
        Database database = new Database(integers);
        database.add(null);

    }

    @Test
    public void removeOperationRemovesLastElement() throws OperationNotSupportedException {
        Database database = new Database(integers);
        database.add(NUMBER_TO_ADD);
        database.remove();
        Assert.assertNull("Number should be null", database.getElements()[0]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeOperationShouldThrowException() throws OperationNotSupportedException {
        Database database = new Database(integers);
        while (database.getElements().length > 0) {
            database.remove();
        }
        database.remove();
    }
}
