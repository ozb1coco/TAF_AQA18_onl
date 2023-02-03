package steps;

import models.User;
import pages.LoginPage;

public class UserSteps {
    private LoginPage loginPage;



    public UserSteps() {
        this.loginPage = new LoginPage();
    }

    public void login(String username, String password) {
        loginPage.getUserNameInputLocator().setValue(username);
        loginPage.getPasswordInputLocator().setValue(password);
        loginPage.getLogInButtonLocator().click();
    }

    public CheckoutSteps successfulLogin(User user) {
        login(user.getUsername(), user.getPassword());
        return new CheckoutSteps();
    }
}