package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InputDataPage extends BasePage {
    private Logger logger = LogManager.getLogger();
    @FindBy(id = "first-name")
    public WebElement inputFirstName;
    @FindBy(id = "last-name")
    public WebElement inputLastName;
    @FindBy(id = "postal-code")
    public WebElement inputZIPCode;
    @FindBy(id = "continue")
    public WebElement buttonContinue;

    public InputDataPage(WebDriver driver) {
        super(driver);
        logger.info("PageFactory pattern is implemented in InputDataPage class");
    }

    @Override
    protected WebElement getPageIdentifier() {
        return buttonContinue;
    }
}