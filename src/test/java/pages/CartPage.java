package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    private final static String pagePath = "cart.html";

    private final By headerTitleLabelLocator = By.xpath("//span[contains(text(),'Your Cart')]");
    private final By cartQuantityLocator = By.className("cart_quantity");
    private final By priceValueLocator = new By.ByClassName("inventory_item_price");
    private final By checkoutButtonLocator = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage(WebDriver driver, boolean openPageByUrl) {
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

    public WebElement getCartQuantity() {
        return driver.findElement(cartQuantityLocator);
    }

    public WebElement getPriceValue() {
        return driver.findElement(priceValueLocator);
    }

    public WebElement getCheckoutButton() {
        return driver.findElement(checkoutButtonLocator);
    }

}
