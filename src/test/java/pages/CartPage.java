package pages;

import baseEntities.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CartPage extends BasePage {
    private Logger logger = LogManager.getLogger();
    @FindBy(id = "checkout")
    public WebElement buttonCheckOut;

    public CartPage(WebDriver driver) {
        super(driver);
        logger.info("PageFactory pattern is implemented in CartPage class");
    }

    @Override
    protected WebElement getPageIdentifier() {
        return buttonCheckOut;
    }
}
