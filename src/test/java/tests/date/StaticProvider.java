package tests.date;

import org.testng.annotations.DataProvider;

public class StaticProvider {

    @DataProvider(name = "dataForDivTestInt")
    public static Object[][] dataForDivTestInt(){
        return new Object[][]{
                {4,2, 2},
                {6, 2, 3},
                {4,2,2}
        };
    }
    @DataProvider(name = "dataForDivTestDouble")
    public static Object[][] dataForDivTestDouble(){
        return new Object[][]{
                {4.2,2, 2.1},
                {6.2, 2, 3.1},
                {4,2.5,1.6}
        };
    }
}
