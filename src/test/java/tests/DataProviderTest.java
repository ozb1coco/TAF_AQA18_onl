package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.date.StaticProvider;

public class DataProviderTest {
    Calculator calculator = new Calculator();
    @Test(dataProvider = "dataForSumTest", dataProviderClass = StaticProvider.class, threadPoolSize = 2)
    public void testSumm6(int a, int b, int expected) {
        Assert.assertEquals(calculator.sum(a, b), expected, "Error of summ");
    }
}
