package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import baseEntities.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OverviewPage extends BasePage {
    Logger logger = LogManager.getLogger();
    @FindBy(id = "finish")
    public WebElement buttonFinish;
    @FindBy(xpath = "//*[text()='Your order has been dispatched, and will arrive just as fast as the pony can get there!']")
    WebElement completePage;

    public OverviewPage(WebDriver driver) {
        super(driver);
        logger.info("PageFactory pattern is implemented in OverviewPage class");
    }

    @Override
    protected WebElement getPageIdentifier() {
        return completePage;
    }
}