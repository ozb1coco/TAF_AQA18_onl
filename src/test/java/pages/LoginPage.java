package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private By userNameInputLocator = By.id("user-name");

    private By passwordInputLocator = By.id("password");

    private By logInButtonLocator = By.id("login-button");

    public SelenideElement getUserNameInputLocator() {
        return $(userNameInputLocator);
    }

    public SelenideElement getPasswordInputLocator() {
        return $(passwordInputLocator);
    }

    public SelenideElement getLogInButtonLocator() {
        return $(logInButtonLocator);
    }
}