package steps;

import baseEntities.BaseStep;
import models.User;
import pages.CartPage;
import pages.OverviewPage;
import pages.InputDataPage;
import org.openqa.selenium.WebDriver;
import pages.ProductPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheckoutSteps extends BaseStep {
    private CartPage cartPage;
    private OverviewPage overviewPage;
    private InputDataPage inputDataPage;
    private ProductPage productPage;
    Logger logger = LogManager.getLogger();

    public CheckoutSteps(WebDriver driver) {
        super(driver);
        cartPage = new CartPage(driver);
        inputDataPage = new InputDataPage(driver);
        productPage = new ProductPage(driver);
        overviewPage = new OverviewPage(driver);
    }

    public CheckoutSteps addToCartProduct() {
        productPage.buttonAddToCart.click();
        return this;
    }

    public CheckoutSteps goToCartPage() {
        productPage.cartButton.click();
        return this;
    }

    public CheckoutSteps clickButtonCheckOut() {
        cartPage.buttonCheckOut.click();
        return this;
    }

    public CheckoutSteps dataInputAndGoToOverview(User user) {
        logger.info("In checkoutStep user object contains next details: " + user);
        inputDataPage.inputFirstName.sendKeys(user.getFirstName());
        inputDataPage.inputLastName.sendKeys(user.getLastName());
        inputDataPage.inputZIPCode.sendKeys(user.getZipCode());
        inputDataPage.buttonContinue.click();
        return this;
    }

    public OverviewPage clickFinish() {
        overviewPage.buttonFinish.click();
        return new OverviewPage(driver);
    }
}