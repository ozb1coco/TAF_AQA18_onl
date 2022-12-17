package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;
import pages.CheckoutStepTwoPage;

public class CheckoutSteps extends BaseStep {
    CartSteps cartSteps = new CartSteps(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);

    public CheckoutSteps(WebDriver driver) {
        super(driver);
    }

    public CheckoutStepTwoPage inputInformation(String email, String psw) {
        cartSteps.goingToCheckout(email, psw);
        checkoutPage.getFirstNameCheckout().sendKeys("Andrei");
        checkoutPage.getLastNameCheckout().sendKeys("Petrovich");
        checkoutPage.getPostalCodeCheckout().sendKeys("12314");
        checkoutPage.getContinueCheckoutButton().click();
        return new CheckoutStepTwoPage(driver);
    }

}
