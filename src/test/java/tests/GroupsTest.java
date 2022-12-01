package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupsTest {
    Calculator calculator = new Calculator();

    @Test (groups = "smoke")
    public void stepB() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Error of summ");
    }

    @Test (groups = "regression")
    public void stepA() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Error of summ");
    }

    @Test (groups = "regression")
    public void stepD() {
        Assert.assertEquals(calculator.sum(2, 3), 6, "Error of summ");
    }

    @Test(groups = {"smoke", "regression"})
    public void stepC1() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Error of summ");
    }

    @Test
    public void stepC10() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Error of summ");
    }

    @Test
    public void stepC2() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Error of summ");
    }

}
