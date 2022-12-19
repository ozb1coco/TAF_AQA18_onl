package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.date.StaticProvider;
import tests.testNG_HW.Calculator;

public class DataProviderTest extends BaseTest {
    Calculator calculator = new Calculator();
    @Test(dataProvider = "dataForDivTestInt", dataProviderClass = StaticProvider.class)
    public void testDivInt(int fistNum, int secondNum, int expected){
        double divResult = calculator.div(fistNum,secondNum);
        Assert.assertEquals(divResult, expected);
    }
    @Test(dataProvider = "dataForDivTestDouble", dataProviderClass = StaticProvider.class)
    public void testDivDouble(double fistNum, double secondNum, double expected){
        double divResult = calculator.div(fistNum, secondNum);
        Assert.assertEquals(divResult,expected);
    }
}
