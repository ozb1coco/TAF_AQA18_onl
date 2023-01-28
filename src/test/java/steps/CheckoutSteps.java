package steps;

import baseEntities.BaseStep;
import models.User;
import pages.CartPage;
import pages.OverviewPage;
import pages.InputDataPage;
import org.openqa.selenium.WebDriver;
import pages.ProductPage;

public class CheckoutSteps extends BaseStep {
    private CartPage checkProductAndPricePage;
    private OverviewPage dataCheckPage;
    private InputDataPage inputDataPage;
    private ProductPage addProductToCartPage;

    public CheckoutSteps(WebDriver driver) {
        super(driver);

        checkProductAndPricePage = new CartPage(driver);
        inputDataPage = new InputDataPage(driver);
        addProductToCartPage = new ProductPage(driver);
        dataCheckPage = new OverviewPage(driver);
    }

    public CheckoutSteps addToCartProduct() {
        addProductToCartPage.buttonAddToCart.click();
        return this;
    }

    public CheckoutSteps goToCartPage() {
        addProductToCartPage.cartButton.click();
        return this;
    }

    public CheckoutSteps clickButtonCheckOut() {
        checkProductAndPricePage.buttonCheckOut.click();
        return this;
    }

    public CheckoutSteps dataInputAndGoToOverview(User user) {
        inputDataPage.inputFirstName.sendKeys(user.getFirstName());
        inputDataPage.inputLastName.sendKeys(user.getLastName());
        inputDataPage.inputZIPCode.sendKeys(user.getZipCode());
        inputDataPage.buttonContinue.click();
        return this;
    }

    public OverviewPage clickFinish() {
        dataCheckPage.buttonFinish.click();
        return new OverviewPage(driver);
    }
}