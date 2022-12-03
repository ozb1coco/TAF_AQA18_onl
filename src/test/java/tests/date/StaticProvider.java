package tests.date;

import org.testng.annotations.DataProvider;

public class StaticProvider {
    @DataProvider(name = "dataForSumTest")
    public static Object[][] dataForSumTest() {
        return new Object[][]{
                {-2, -3, -5},
                {0, 0, 0},
                {2, 3, 5}
        };
    }
    @DataProvider(name = "dataForDivTestInt")
    public static Object[][] dataForDivTestInt(){
        return new Object[][]{
                {4,2, 2},
                {6, 0, 0},
                {4,2,2}
        };
    }
    @DataProvider(name = "dataForDivTestDouble")
    public static Object[][] dataForDivTestDouble(){
        return new Object[][]{
                {4.2,2, 2.1},
                {6., 0, 0},
                {4,2.5,1.6}
        };
    }
}
