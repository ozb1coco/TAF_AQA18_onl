package baseEntities;

import configuration.ReadProperties;
import factory.BrowsersFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.*;

public class BaseTest {
    protected WebDriver driver;
    protected UserStep userStep;
    protected InventorySteps inventorySteps;
    protected CartSteps cartSteps;
    protected CheckoutSteps checkoutSteps;
    protected CheckoutStepTwoSteps checkoutStepTwoSteps;


    @BeforeMethod
    public void setUp() {
        driver = new BrowsersFactory().getDriver();
        driver.get(ReadProperties.getUrl());

        userStep = new UserStep(driver);
        inventorySteps = new InventorySteps(driver);
        cartSteps = new CartSteps(driver);
        checkoutSteps = new CheckoutSteps(driver);
        checkoutStepTwoSteps = new CheckoutStepTwoSteps(driver);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
