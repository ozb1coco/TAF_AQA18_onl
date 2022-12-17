package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutStepTwoPage extends BasePage {

    private final static String pagePath = "checkout-step-two.html";

    private final By headerTitleLabelLocator = By.xpath("//span[contains(text(),'Checkout: Overview')]");
    private final By finishButtonLocator = By.id("finish");

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutStepTwoPage(WebDriver driver, boolean openPageByUrl) {
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

    public WebElement getFinishButton() {
        return driver.findElement(finishButtonLocator);
    }

}
