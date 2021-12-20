package UnitTesting.exercise.tests;

import UnitTesting.exercise.p02_ExtendedDatabase.Database;
import UnitTesting.exercise.p02_ExtendedDatabase.Person;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ExtendedDatabaseTest {
    private final static int ID_ONE = 10;
    private final static int ID_TWO = 20;
    private final static String NAME = "Nikola";
    private final static String NAME_TWO = "Georgi";
    private final static int NEGATIVE_ID = -1;
    private Person person;
    private Database database;

    @Before
    public void initializeObjects() throws OperationNotSupportedException {
        this.person = new Person(ID_ONE, NAME);
        this.database = new Database(person);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addOperationThrowsExceptionForEqualID() throws OperationNotSupportedException {
        Person person = new Person(ID_ONE, NAME_TWO);
        this.database.add(person);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addOperationThrowsExceptionForNegativeID() throws OperationNotSupportedException {
        Person person = new Person(NEGATIVE_ID, NAME_TWO);
        this.database.add(person);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeOperationTest() throws OperationNotSupportedException {
        this.database.remove();
        this.database.remove();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameOperationThrowsExceptionWhenUserNotExist() throws OperationNotSupportedException {
        this.database.findByUsername(NAME_TWO);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameOperationThrowsExceptionWhenUserNull() throws OperationNotSupportedException {
        this.database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByIDOperationThrowsException() throws OperationNotSupportedException {
        this.database.findById(ID_TWO);
    }
}
