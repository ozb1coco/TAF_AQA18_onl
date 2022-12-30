package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage extends BasePage {
    private final By addToCartButtonLocator = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private final By buttonIntoBucketLocator = new By.ByClassName("shopping_cart_link");
    private final By inventoryPageLocator = By.xpath("//*[contains(text(), 'Products')]");

    public WebElement getAddToCartButton() {
        return driver.findElement(addToCartButtonLocator);
    }
    public WebElement getButtonIntoBucket() {
        return driver.findElement(buttonIntoBucketLocator);
    }
    public InventoryPage(WebDriver driver) {
        super(driver);
    }


    @Override
    protected By getPageIdentifier() {
        return inventoryPageLocator;
    }
}
