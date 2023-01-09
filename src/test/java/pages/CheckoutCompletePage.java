package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutCompletePage extends BasePage {
    private final By checkoutCompletePage = By.xpath("//span[contains(text(),'Checkout: Complete!')]");
    private final By backHomeButtonLocator = By.id("back-to-products");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return checkoutCompletePage;
    }

    public WebElement getBackHomeButton() {
        return driver.findElement(backHomeButtonLocator);
    }

}
