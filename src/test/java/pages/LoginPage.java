package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    // Блок описания локаторов для эментов
    private final By usernameInputLocator = By.id("user-name");
    private final By passwordInputLocator = By.id("password");
    private final By logInButtonLocator = By.id("login-button");

    // Блок иницализации страницы
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return logInButtonLocator;
    }


    public WebElement getUsernameInput() {
        return driver.findElement(usernameInputLocator);
    }

    public WebElement getPassword() {
        return driver.findElement(passwordInputLocator);
    }

    public WebElement getLogInButton() {
        return driver.findElement(logInButtonLocator);
    }

}
