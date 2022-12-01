package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PriorityTest {
    Calculator calculator = new Calculator();

    @Test
    public void stepB() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Error of summ");
    }

    @Test(priority = 1)
    public void stepA() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Error of summ");
    }

    @Test(priority = 2)
    public void stepD() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Error of summ");
    }

    @Test(priority = 3)
    public void stepC1() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Error of summ");
    }

}
