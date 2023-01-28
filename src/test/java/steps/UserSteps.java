package steps;

import org.openqa.selenium.WebDriver;
import baseEntities.BaseStep;
import models.User;
import pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserSteps extends BaseStep {
    private LoginPage loginPage;
    Logger loggerUser = LogManager.getLogger();


    public UserSteps(WebDriver driver) {
        super(driver);

        this.loginPage = new LoginPage(driver);
    }

    public void login(String username, String password) {
        loginPage.userNameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.logInButton.click();
    }

    public CheckoutSteps successfulLogin(User user) {
        loggerUser.info("In checkoutStep user object contains next details: " + user);
        login(user.getUsername(), user.getPassword());

        return new CheckoutSteps(driver);
    }
}