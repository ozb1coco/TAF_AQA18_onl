package tests;

import org.testng.annotations.Test;

public class simpleTest extends BaseTest {
    @Test
    public void simpleTest1(){
        System.out.println("this is my first test!");
    }
    @Test
    public void simpleTest2(){
        System.out.println("this is my second test!");
    }
}
