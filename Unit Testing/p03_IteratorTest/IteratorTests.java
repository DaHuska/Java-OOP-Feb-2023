package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Field;

public class IteratorTests {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testIteratorCtorWhenElementsAreNull() throws OperationNotSupportedException {
        exceptionRule.expect(OperationNotSupportedException.class);

        ListIterator listIterator = new ListIterator(null);
    }

    @Test
    public void testMoveWhenThereAreNoIndexes() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator("Something");

       boolean isMoved = listIterator.move();

        Assert.assertFalse(isMoved);
    }

    @Test
    public void testMoveWhenThereAreIndexesToMoveOn() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator("Something", "is", "bad");

        boolean isMoved = listIterator.move();

        Assert.assertTrue(isMoved);
    }

    @Test
    public void testMoveIfThereIsWherePlaceToMove() throws OperationNotSupportedException, NoSuchFieldException, IllegalAccessException {
        ListIterator listIterator = new ListIterator("Something", "is", "bad");
        Class<ListIterator> clazz = ListIterator.class;

        listIterator.move();

        Field field = clazz.getDeclaredField("currentIndex");
        field.setAccessible(true);
        Object value = field.get(listIterator);

        int currentIndex = (int) value;

        Assert.assertEquals(1, currentIndex);
    }

    @Test
    public void testMoveWhenUnableToMove() throws OperationNotSupportedException, NoSuchFieldException, IllegalAccessException {
        ListIterator listIterator = new ListIterator("Something");
        Class<ListIterator> clazz = ListIterator.class;

        listIterator.move();

        Field field = clazz.getDeclaredField("currentIndex");
        field.setAccessible(true);
        Object value = field.get(listIterator);

        int currentIndex = (int) value;

        Assert.assertEquals(0, currentIndex);
    }

    @Test
    public void testHasNextWhenThereIsAnotherElement() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator("Something", "is", "bad");

        boolean hasNext = listIterator.hasNext();

        Assert.assertTrue(hasNext);
    }

    @Test
    public void testHasNextWhenThereAreNoMoreElements() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator("Something");

        boolean hasNext = listIterator.hasNext();

        Assert.assertFalse(hasNext);
    }

    @Test
    public void testPrintWhenThereAreNoElements() throws OperationNotSupportedException {
        exceptionRule.expect(IllegalStateException.class);

        ListIterator listIterator = new ListIterator();

        listIterator.print();
    }

    @Test
    public void testPrintWhenThereAreElementsStart() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator("Something", "is", "bad");

        String output = listIterator.print();

        Assert.assertEquals("Something", output);
    }

    @Test
    public void testPrintWhenThereAreElementsMiddle() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator("Something", "is", "bad");

        listIterator.move();
        String output = listIterator.print();

        Assert.assertEquals("is", output);
    }

    @Test
    public void testPrintWhenThereAreElementsEnd() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator("Something", "is", "bad");

        listIterator.move();
        listIterator.move();
        String output = listIterator.print();

        Assert.assertEquals("bad", output);
    }
}