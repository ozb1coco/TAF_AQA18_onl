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
}
