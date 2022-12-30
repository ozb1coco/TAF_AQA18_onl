package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class SauceDemoPaymentTests extends BaseTest {

    @Test
    public void fullSauceDemoSuccessfulPaymentTest() {
            Assert.assertTrue(userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password())
                    .isPageOpened());
            Assert.assertTrue(userStep.inventorySuccessful()
                    .isPageOpened());
            Assert.assertTrue(userStep.CartPageSuccessful()
                    .isPageOpened());
            Assert.assertTrue(userStep.goingIntoOverviewPageSuccessful(ReadProperties.firstname(), ReadProperties.lastname(), ReadProperties.postalCode())
                    .isPageOpened());
            Assert.assertTrue(userStep.finishOverviewIsSuccessful()
                    .isPageOpened());
            Assert.assertTrue(userStep.backHome());
    }
}
