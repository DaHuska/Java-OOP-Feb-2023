package rpg_lab;

import org.junit.Assert;
import org.junit.Test;

public class DummyTest {

    @Test
    public void testDummyLosesHealthIfAttacked() {
        Dummy dummy = new Dummy(10, 10);
        Axe axe = new Axe(1, 10);

        axe.attack(dummy);

        Assert.assertEquals(9, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyThrowsExceptionIfAttacked() {
        Dummy dummy = new Dummy(0, 10);
        Axe axe = new Axe(1, 2);

        axe.attack(dummy);
    }

    @Test
    public void testDeadDummyGivesXP() {
        Dummy dummy = new Dummy(0, 10);

        int gavenXP = dummy.giveExperience();

        Assert.assertEquals(10, gavenXP);
    }

    @Test(expected = IllegalStateException.class)
    public void testALiveDummyCannotGiveXP() {
        Dummy dummy = new Dummy(1, 10);

        dummy.giveExperience();
    }
}
