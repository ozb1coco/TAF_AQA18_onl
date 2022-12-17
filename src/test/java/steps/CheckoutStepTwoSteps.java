package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CheckoutCompletePage;
import pages.CheckoutStepTwoPage;

public class CheckoutStepTwoSteps extends BaseStep {
    CheckoutSteps checkoutSteps = new CheckoutSteps(driver);

    CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);

    public CheckoutStepTwoSteps(WebDriver driver) {
        super(driver);
    }

    public CheckoutCompletePage pressFinishButton(String email, String psw) {
        checkoutSteps.inputInformation(email, psw);
        checkoutStepTwoPage.getFinishButton().click();
        return new CheckoutCompletePage(driver);
    }
}
