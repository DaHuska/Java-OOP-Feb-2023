package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Test;

public class PersonTests {

    @Test
    public void testPersonCtor() {
        Person person = new Person(123456, "John");

        Assert.assertEquals(123456, person.getId());
        Assert.assertEquals("John", person.getUsername());
    }
}
