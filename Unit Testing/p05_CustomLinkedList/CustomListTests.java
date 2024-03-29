package p05_CustomLinkedList;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CustomListTests {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testCustomLinkedListAdd() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();

        customLinkedList.add("Banica");

        Assert.assertEquals("Banica", customLinkedList.get(0));
    }

    @Test
    public void testCustomLinkedListAddTwoItems() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();

        customLinkedList.add("Banica");
        customLinkedList.add("Tarator");

        Assert.assertEquals("Tarator", customLinkedList.get(1));
    }

    @Test
    public void testCustomLinkedListContainsWhenFound() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();

        customLinkedList.add("Banica");

        Assert.assertTrue(customLinkedList.contains("Banica"));
    }

    @Test
    public void testCustomLinkedListContainsWhenNotFound() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();

        customLinkedList.add("Banica");

        Assert.assertFalse(customLinkedList.contains("Tarator"));
    }

    @Test
    public void testCustomLinkedListSetWhenInvalidIndex() {
        exceptionRule.expect(IllegalArgumentException.class);

        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();

        customLinkedList.add("Banica");
        customLinkedList.set(2, "Tarator");
    }

    @Test
    public void testCustomLinkedListSetWhenValidIndex() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();

        customLinkedList.add("Banica");
        customLinkedList.set(0, "Tarator");

        String item = customLinkedList.get(0);

        Assert.assertEquals("Tarator", item);
    }

    @Test
    public void testCustomLinkedListRemoveAtWhenInvalidIndex() {
        exceptionRule.expect(IllegalArgumentException.class);

        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("Banica");
        customLinkedList.removeAt(1);
    }

    @Test
    public void testCustomLinkedListRemoveAtWhenIndexValid() {
        exceptionRule.expect(IllegalArgumentException.class);

        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("Banica");
        customLinkedList.removeAt(0);

        customLinkedList.get(0);
    }

    @Test
    public void testCustomLinkedListRemoveWhenItemNotFound() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("Banica");

        int index = customLinkedList.remove("Tarator");

        Assert.assertEquals(-1, index);
    }

    @Test
    public void testCustomLinkedListRemoveWhenItemIsValid() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("Banica");

        int index = customLinkedList.remove("Banica");

        Assert.assertEquals(0, index);
    }
}
