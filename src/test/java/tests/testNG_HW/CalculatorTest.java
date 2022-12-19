package tests.testNG_HW;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class CalculatorTest extends BaseTest {
    @Test(testName = "Div with int", groups = "smoke",description = "with correct data", timeOut = 500)
    public void testDivInt() {
        Assert.assertEquals(calculator.div(6, 3), 2, "Incorrect data");
    }

    @Test(testName = "Div with int divide by 0 exception", expectedExceptions = ArithmeticException.class, groups = "regression")
    public void testDivIntByZeroException() {
        Assert.assertEquals(calculator.div(6, 0), 0, "Error of div by zero");
    }

    @Test(testName = "Div with double", dependsOnMethods = "divDoubleByZeroPositiveTest")
    public void testDivDouble() {
        Assert.assertEquals(calculator.div(5.2, 2), 2.6, "Error of div double");
    }

    @Test(testName = "Div with double positive", priority = 3, invocationCount = 2, invocationTimeOut = 500, threadPoolSize = 2)
    public void divDoubleByZeroPositiveTest() {
        Assert.assertEquals(calculator.div(5.2, 0), Double.POSITIVE_INFINITY);
    }

    @Test(testName = "Div with double negative", priority = 2, alwaysRun = true)
    public void divDoubleByZeroNegativeTest() {
        Assert.assertEquals(calculator.div(-5.2, 0), Double.NEGATIVE_INFINITY);
    }
    @Test(testName = "Div for NaN", priority = 1, enabled = true)
    public void divDoubleByZeroNaNTest(){
        Assert.assertEquals(calculator.div(0.0d, 0.0),Double.NaN);
    }

}


//invocationCount, invocationTimeOut, threadPoolSize




