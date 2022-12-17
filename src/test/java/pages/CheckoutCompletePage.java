package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutCompletePage extends BasePage {
    private final static String pagePath = "checkout-complete.html";

    private final By headerTitleLabelLocator = By.xpath("//span[contains(text(),'Checkout: Complete!')]");
    private final By backHomeButtonLocator = By.id("back-to-products");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public CheckoutCompletePage(WebDriver driver, boolean openPageByUrl) {
        super(driver);

        if (openPageByUrl) {
            openPageByUrl();
        }
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getBackHomeButton() {
        return driver.findElement(backHomeButtonLocator);
    }

}
