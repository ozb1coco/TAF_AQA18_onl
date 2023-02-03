package steps;

import models.User;
import pages.CartPage;
import pages.OverviewPage;
import pages.InputDataPage;
import org.openqa.selenium.WebDriver;
import pages.ProductPage;


public class CheckoutSteps  {
    private CartPage cartPage;
    private OverviewPage overviewPage;
    private InputDataPage inputDataPage;
    private ProductPage productPage;

    public CheckoutSteps() {
        cartPage = new CartPage();
        inputDataPage = new InputDataPage();
        productPage = new ProductPage();
        overviewPage = new OverviewPage();
    }

    public CheckoutSteps addToCartProduct() {
        productPage.getAddToCartStuffButtonLocator().click();
        return this;
    }

    public CheckoutSteps goToCartPage() {
        productPage.getCartButtonLocator().click();
        return this;
    }

    public CheckoutSteps clickButtonCheckOut() {
        cartPage.getCheckoutButton().click();
        return this;
    }

    public CheckoutSteps dataInputAndGoToOverview(User user) {
        inputDataPage.getFirstNameInput().sendKeys(user.getFirstname());
        inputDataPage.getLastNameInput().sendKeys(user.getLastname());
        inputDataPage.getZipCodeInput().sendKeys(user.getZipCode());
        inputDataPage.getContinueButton().click();
        return this;
    }

    public OverviewPage clickFinish() {
        overviewPage.getButtonFinishLocator().click();
        return overviewPage;
    }
}