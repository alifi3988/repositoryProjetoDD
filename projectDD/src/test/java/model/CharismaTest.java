package model;

import org.junit.Assert;
import org.junit.Test;

public class CharismaTest {

    @Test
    public void shoud_calculate_modifier_positive(){
        Charisma charisma = new Charisma(15);
        Assert.assertEquals(2, charisma.getModifier());
    }

    @Test
    public void shoud_calculate_modifier_negative(){
        Charisma charisma = new Charisma(7);
        Assert.assertEquals(-2, charisma.getModifier());
    }

}