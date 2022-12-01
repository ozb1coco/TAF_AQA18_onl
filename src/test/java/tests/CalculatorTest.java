package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.plaf.TableHeaderUI;
import java.util.List;

public class CalculatorTest extends BaseTest{
    @Test
    public void testSumm(){
        Assert.assertEquals(calculator.sum(2,3),5, "Error of summ");
    }
    @Test(enabled = false)
    public void testSumm1(){
        Assert.assertEquals(calculator.sum(2,3),5, "Error of summ");
    }

    @Test(description = "Test in description")
    public void testSumm2(){
        Assert.assertEquals(calculator.sum(2,3),5, "Error of summ");
    }
    @Test(testName = "NameTest")
    public void testSumm3(){
        Assert.assertEquals(calculator.sum(2,3),5, "Error of summ");
    }
    @Test(testName = "NameTest")
    public void testSumm22(){
        Assert.assertEquals(calculator.sum(2,3),5, "Error of summ");
    }
    @Test(timeOut = 1000)
    public void testSumm4() throws InterruptedException {
        Thread.sleep(500);
    }
    @Test(invocationCount = 3, invocationTimeOut = 1000, threadPoolSize = 3)
    public void testSumm5() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(calculator.sum(2,3),5, "Error of summ");
    }
    @Test(invocationCount = 3, invocationTimeOut = 1000, threadPoolSize = 3)
    public void testSumm6() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(calculator.sum(2,3),5, "Error of summ");
    }
    @Test(expectedExceptions = NullPointerException.class)
    public void exceptionTest(){
        List list = null;
        int size = list.size();
    }
}
