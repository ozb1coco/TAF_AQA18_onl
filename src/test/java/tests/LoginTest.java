package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Inventory;
import pages.LoginPage;

public class LoginTest extends BaseTest {

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

}
