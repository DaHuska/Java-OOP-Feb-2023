package p05_CustomLinkedList;

import org.junit.Assert;
import org.junit.Test;

public class CustomListTests {

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

    
}
