package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.testNG_HW.Calculator;

public class GroupsTest {
    Calculator calculator = new Calculator();

    @Test (groups = "smoke")
    public void stepA() {Assert.assertEquals(calculator.div(6, 2), 3, "Error of div");}

    @Test (groups = "regression")
    public void stepB() {
        Assert.assertEquals(calculator.div(6.2, 2), 3.1, "Error of div");
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
