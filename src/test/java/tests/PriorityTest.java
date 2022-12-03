package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.testNG_HW.Calculator;

public class PriorityTest {
    Calculator calculator = new Calculator();

    @Test(priority = 2)
    public void stepA() {
        Assert.assertEquals(calculator.div(5.2, 2), 2.6, "Error of div");
    }

    @Test(priority = 1)
    public void stepB() {
        Assert.assertEquals(calculator.div(4, 2), 2, "Error of div");
    }
}
