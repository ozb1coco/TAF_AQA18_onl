package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.testNG_HW.Calculator;

public class DependencyTest {
    Calculator calculator = new Calculator();

    @Test
    public void stepB() {
        Assert.assertEquals(calculator.div(2.2, 2), 1.1, "Error of div double");
    }

    @Test(dependsOnMethods = "stepB")
    public void stepA() {
        Assert.assertEquals(calculator.div(3., 2), 1.5, "Error of div double");
    }

    @Test(dependsOnMethods = "stepA")
    public void stepD() {
        Assert.assertEquals(calculator.div(4, 2), 2, "Error of div int");
    }

    @Test(dependsOnMethods = "stepD", alwaysRun = true)
    public void stepC() {
        Assert.assertEquals(calculator.div(6, 3), 2, "Error of summ");
    }


}
