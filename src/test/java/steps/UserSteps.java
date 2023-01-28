package steps;

import org.openqa.selenium.WebDriver;
import baseEntities.BaseStep;
import models.User;
import pages.LoginPage;

public class UserSteps extends BaseStep {
    private LoginPage loginPage;
    private CheckoutSteps checkoutStep;

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
        login(user.getUsername(), user.getPassword());

        return new CheckoutSteps(driver);
    }
}