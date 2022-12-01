package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTest {
    Calculator calculator = new Calculator();

    @Test
    public void stepB() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Error of summ");
    }

    @Test(dependsOnMethods = "stepB")
    public void stepA() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Error of summ");
    }

    @Test(dependsOnMethods = "stepA")
    public void stepD() {
        Assert.assertEquals(calculator.sum(2, 3), 6, "Error of summ");
    }

    @Test(dependsOnMethods = "stepD", alwaysRun = true)
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
