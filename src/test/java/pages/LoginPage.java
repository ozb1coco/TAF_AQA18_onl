package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import baseEntities.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPage extends BasePage {
    Logger logger = LogManager.getLogger();
    @FindBy(id = "user-name")
    public WebElement userNameInput;
    @FindBy(id = "password")
    public WebElement passwordInput;
    @FindBy(id = "login-button")
    public WebElement logInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        logger.info("PageFactory pattern is implemented in LoginPage class");
    }

    @Override
    protected WebElement getPageIdentifier() {
        return logInButton;
    }
}