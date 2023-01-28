package baseEntities;


import configuration.ReadProperties;
import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.UserSteps;

public class BaseTest {
    protected WebDriver driver;
    protected UserSteps userSteps;


    @BeforeMethod
    public void setUp() {
        driver = new BrowserFactory().getDriver();
        driver.get(ReadProperties.getUrl());

        userSteps = new UserSteps(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}