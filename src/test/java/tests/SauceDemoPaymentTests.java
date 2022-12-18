package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Inventory;
import pages.LoginPage;

public class SauceDemoPaymentTests extends BaseTest {

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailInput().sendKeys(ReadProperties.username());
        loginPage.getPassword().sendKeys(ReadProperties.password());
        loginPage.getLogInButton().click();

        Assert.assertTrue(new Inventory(driver).isPageOpened());
    }

    @Test
    public void loginSuccessfulTest() {
        Assert.assertTrue(
                userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password())
                        .isPageOpened()
        );
    }

    @Test
    public void loginIncorrectTest() {
        Assert.assertEquals(
                userStep.loginIncorrect(ReadProperties.username(), "sdfsdfsdf")
                        .getErrorTextElement().getText(),
                "Epic sadface: Username and password do not match any user in this service"
        );
    }

    @Test
    public void checkQuantityValueTest() {
        Assert.assertEquals(
                inventorySteps.goingToCart(ReadProperties.username(), ReadProperties.password())
                        .getCartQuantity().getText(), "1"
        );
    }

    @Test
    public void checkPriceValueTest() {
        Assert.assertEquals(
                inventorySteps.goingToCart(ReadProperties.username(), ReadProperties.password())
                        .getPriceValue().getText(), "$49.99"
        );
    }

    @Test
    public void goingToCheckoutTest() {
        Assert.assertTrue(cartSteps.goingToCheckout(ReadProperties.username(), ReadProperties.password())
                .isPageOpened());
    }

    @Test
    public void inputInfoAndContinuePressButtonTest() {
        Assert.assertTrue(
                checkoutSteps.inputInformation(ReadProperties.username(), ReadProperties.password())
                        .isPageOpened());
    }

    @Test
    public void addToCartTest() {
        Assert.assertTrue(
                inventorySteps.addToCartStuff(ReadProperties.username(), ReadProperties.password())
                        .isPageOpened()
        );
    }

    @Test
    public void goingToBucketAfterAddStuffTest() {
        Assert.assertTrue(
                inventorySteps.goingToCart(ReadProperties.username(), ReadProperties.password())
                        .isPageOpened()
        );
    }

    @Test
    public void fullCheckListTest() throws InterruptedException {
        Assert.assertTrue(
                checkoutStepTwoSteps.pressFinishButton(ReadProperties.username(), ReadProperties.password())
                        .isPageOpened());
        Thread.sleep(2000);
    }
}
