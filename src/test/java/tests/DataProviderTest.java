package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.date.StaticProvider;
import tests.testNG_HW.Calculator;

public class DataProviderTest {
    Calculator calculator = new Calculator();
    @Test(dataProvider = "dataForSumTest", dataProviderClass = StaticProvider.class, threadPoolSize = 2)
    public void testSumm6(int a, int b, int expected) {
        Assert.assertEquals(calculator.sum(a, b), expected, "Error of summ");
    }
    @Test(dataProvider = "dataForDivTestInt", dataProviderClass = StaticProvider.class)
    public void testDivInt(int a, int b, int expected){
        Assert.assertEquals(calculator.div(a,b), expected, "Error of div int");
    }
    @Test(dataProvider = "dataForDivTestDouble", dataProviderClass = StaticProvider.class)
    public void testDivDouble(double a, double b, double expected){
        Assert.assertEquals(calculator.div(a,b), expected, "Error of div double");
    }
}
