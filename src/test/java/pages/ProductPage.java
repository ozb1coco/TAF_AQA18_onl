package pages;


import baseEntities.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductPage extends BasePage {
    private Logger logger = LogManager.getLogger();
    @FindBy(name = "add-to-cart-sauce-labs-bike-light")
    public WebElement buttonAddToCart;
    @FindBy(className = "shopping_cart_link")
    public WebElement cartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        logger.info("PageFactory pattern is implemented in ProductPage class");
    }

    @Override
    protected WebElement getPageIdentifier() {
        return cartButton;
    }
}