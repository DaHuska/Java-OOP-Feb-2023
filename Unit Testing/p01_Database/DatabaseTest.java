package p01_Database;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testArrayCapacityWhenNullIntegers() throws OperationNotSupportedException {
        exceptionRule.expect(OperationNotSupportedException.class);

        Database database = new Database(new Integer[] {});
    }

    @Test
    public void testArrayCapacityWhenElementsAreMoreThan16() throws OperationNotSupportedException {
        exceptionRule.expect(OperationNotSupportedException.class);

        Database database = new Database(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17});
    }

    @Test
    public void testArrayCapacityWhenElementsAreInRangeAndTestGetElementsMethod() throws OperationNotSupportedException {
        Database database = new Database(new Integer[] {1, 2, 3});

        Assert.assertEquals(3, database.getElements().length);
    }

    @Test
    public void testArrayAddWhenElementIsValid() throws OperationNotSupportedException {
        Database database = new Database(new Integer[] {1, 2, 3});

        database.add(3);
        int lastElement = 0;

        for (Integer element : database.getElements()) {
            lastElement = element;
        }

        Assert.assertEquals(3, lastElement);
    }

    @Test
    public void testArrayWhenElementIsNull() throws OperationNotSupportedException {
        exceptionRule.expect(OperationNotSupportedException.class);

        Database database = new Database(new Integer[] {1, 2, 3});

        database.add(null);
    }

    @Test
    public void testArrayRemoveWhenDatabaseIsEmpty() throws OperationNotSupportedException {
        exceptionRule.expect(OperationNotSupportedException.class);

        Database database = new Database(new Integer[] {});

        database.remove();
    }

    @Test
    public void testArrayRemoveWhenDatabaseExists() throws OperationNotSupportedException {
        Database database = new Database(new Integer[] {1, 2, 3});

        database.remove();
        int lastElement = 0;

        for (Integer element : database.getElements()) {
            lastElement = element;
        }

        Assert.assertEquals(2, lastElement);
    }
}
