package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.naming.OperationNotSupportedException;

public class DatabaseTests {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testDatabaseCtorWhenInputIsInvalid() throws OperationNotSupportedException {
        exceptionRule.expect(OperationNotSupportedException.class);

        Database database = new Database();
    }

    @Test
    public void testDatabaseCtorWhenInputIsValid() throws OperationNotSupportedException {
        Database database = new Database(new Person(123, "John"), new Person(456, "Tom"));

        Assert.assertNotNull(database);
    }

    @Test
    public void testAddWhenPersonIsNull() throws OperationNotSupportedException {
        exceptionRule.expect(OperationNotSupportedException.class);

        Database database = new Database(new Person(123, "John"));
        Person person = null;

        database.add(person);
    }

    @Test
    public void testRemoveWhenThereAreNoPeopleToRemove() throws OperationNotSupportedException {
        exceptionRule.expect(OperationNotSupportedException.class);

        Database database = new Database(new Person(123, "John"));

        database.remove();
        database.remove();
    }

    @Test
    public void testGetElements() throws OperationNotSupportedException {
        Database database = new Database(new Person(123, "John"));

        int databaseSize = database.getElements().length;

        Assert.assertEquals(1, databaseSize);
    }

    @Test
    public void testRemoveWhenOperationIsValid() throws OperationNotSupportedException {
        Database database = new Database(new Person(123, "John"));

        database.remove();
        int databaseSize = database.getElements().length;

        Assert.assertEquals(0, databaseSize);
    }

    @Test
    public void testFindByUsernameWhenUserIsNull() throws OperationNotSupportedException {
        exceptionRule.expect(OperationNotSupportedException.class);

        Database database = new Database(new Person(123, "John"));

        database.findByUsername(null);
    }

    @Test
    public void testFindByUsernameWhenThereAreMoreUsersWithTheSameName() throws OperationNotSupportedException {
        exceptionRule.expect(OperationNotSupportedException.class);

        Database database = new Database(new Person(123, "John"), new Person(123456, "John"));

        database.findByUsername("John");
    }

    @Test
    public void testFindByUsernameWhenOperationShouldBeValid() throws OperationNotSupportedException {
        Database database = new Database(new Person(123, "John"), new Person(123456, "Gosho"));

        Person foundPerson = database.findByUsername("John");
        String foundUserName = foundPerson.getUsername();

        Assert.assertEquals("John", foundUserName);
    }

    @Test
    public void testFindByIdWhenMultiplePeopleHaveSameID() throws OperationNotSupportedException {
        exceptionRule.expect(OperationNotSupportedException.class);

        Database database = new Database(new Person(123, "John"), new Person(123, "Gosho"));

        database.findById(123);
    }

    @Test
    public void testFindByIdWhenOperationShouldBeValid() throws OperationNotSupportedException {
        Database database = new Database(new Person(123, "John"), new Person(567, "Gosho"));

        Person foundPerson = database.findById(123);
        int foundPersonId = foundPerson.getId();

        Assert.assertEquals(123, foundPersonId);
    }
}
