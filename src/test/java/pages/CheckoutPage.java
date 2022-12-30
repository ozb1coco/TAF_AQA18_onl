package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {

    private final static String pagePath = "checkout-step-one.html";

    private final By checkoutPageLocator = By.xpath("//span[contains(text(),'Checkout: Your Information')]");
    private final By firstNameCheckoutLocator = By.id("first-name");
    private final By lastNameCheckoutLocator = By.id("last-name");
    private final By postalCodeCheckoutLocator = By.id("postal-code");
    private final By continueCheckoutButtonLocator = By.id("continue");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return checkoutPageLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getFirstNameCheckout() {
        return driver.findElement(firstNameCheckoutLocator);
    }

    public WebElement getLastNameCheckout() {
        return driver.findElement(lastNameCheckoutLocator);
    }

    public WebElement getPostalCodeCheckout() {
        return driver.findElement(postalCodeCheckoutLocator);
    }

    public WebElement getContinueCheckoutButton() {
        return driver.findElement(continueCheckoutButtonLocator);
    }

}
