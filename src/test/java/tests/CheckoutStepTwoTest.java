package tests;

import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutStepTwoTest extends CheckoutTest {

    @Test
    public void PressFinishButtonTest() throws InterruptedException {
        Assert.assertTrue(
                checkoutStepTwoSteps.pressFinishButton(ReadProperties.username(), ReadProperties.password())
                        .isPageOpened());
        Thread.sleep(2000);
    }
}
