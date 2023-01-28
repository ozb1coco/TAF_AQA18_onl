package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import baseEntities.BasePage;

public class CartPage extends BasePage {
    @FindBy(id = "checkout")
    public WebElement buttonCheckOut;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return buttonCheckOut;
    }
}
