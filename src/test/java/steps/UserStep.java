package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.Inventory;
import pages.LoginPage;

public class UserStep extends BaseStep {
    private final LoginPage loginPage;


    public UserStep(WebDriver driver) {
        super(driver);

        loginPage = new LoginPage(driver);

    }

    public void login(String email, String psw) {
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPassword().sendKeys(psw);
        loginPage.getLogInButton().click();
    }

    public Inventory loginSuccessful(String email, String psw) {
        login(email, psw);

        return new Inventory(driver);
    }

    public LoginPage loginIncorrect(String email, String psw) {
        login(email, psw);

        return loginPage;
    }
}
