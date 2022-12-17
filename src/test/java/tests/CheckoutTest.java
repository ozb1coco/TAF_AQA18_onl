package tests;

import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends CartTest {

    @Test
    public void inputInfoAndContinuePressButtonTest(){
        Assert.assertTrue(
                checkoutSteps.inputInformation(ReadProperties.username(),ReadProperties.password())
                        .isPageOpened());
    }
}
