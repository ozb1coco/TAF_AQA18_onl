package tests.testNG_HW;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import javax.swing.plaf.TableHeaderUI;
import java.util.List;

public class CalculatorTest extends BaseTest {
    @Test(testName = "Div with int")
    public void testDivInt() {
        Assert.assertEquals(calculator.div(6,3),2, "Error of div int");
    }
    @Test(testName = "Div with int divide by 0 exception", expectedExceptions = ArithmeticException.class)
    public void testDivIntByZeroException() {
        Assert.assertEquals(calculator.div(6,0),2, "Error of div by zero");
    }

    @Test(testName = "Div with double")
    public void testDivDouble() {
        Assert.assertEquals(calculator.div(5.2,2),2.6, "Error of div double");
    }
    @Test(testName = "Div with double divide by 0 exception")
    public void testDivDoubleByZeroException() {
        double result = calculator.div(5.2,0);
        Assert.assertTrue(Double.isInfinite(result), "Error of div by zero double");
    }

}
