package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Inventory extends BasePage {
    private final static String pagePath = "inventory.html";

    private final By headerTitleLabelLocator = By.xpath("//span[contains(text(),'Products')]");
    private final By addToCartButtonLocator = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private final By buttonIntoBucketLocator = new By.ByClassName("shopping_cart_link");

    public Inventory(WebDriver driver) {
        super(driver);
    }

    public Inventory(WebDriver driver, boolean openPageByUrl) {
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

    public WebElement getAddToCartButton() {
        return driver.findElement(addToCartButtonLocator);
    }

    public WebElement getButtonIntoBucket() {
        return driver.findElement(buttonIntoBucketLocator);
    }

}
