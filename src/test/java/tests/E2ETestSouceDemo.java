package tests;


import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import baseEntities.BaseTest;
import models.User;

public class E2ETestSouceDemo extends BaseTest {
    @Test
    public void successfulOrderTest() {
        User user = new User.Builder()
                .withUsername(ReadProperties.userName())
                .withPassword(ReadProperties.password())
                .withFirsName(ReadProperties.firstName())
                .withLastname(ReadProperties.lastName())
                .withZipCode(ReadProperties.zipCode())
                .build();

        Assert.assertTrue(userSteps.successfulLogin(user)
                .addToCartProduct()
                .goToCartPage()
                .clickButtonCheckOut()
                .dataInputAndGoToOverview(user)
                .clickFinish()
                .isPageOpened());
    }
}
