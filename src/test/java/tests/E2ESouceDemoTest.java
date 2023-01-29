package tests;


import configuration.ReadProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import baseEntities.BaseTest;
import models.User;

public class E2ESouceDemoTest extends BaseTest {
    Logger logger = LogManager.getLogger();
    @Test
    public void successfulOrderTest() {
        logger.info("The Builder pattern was implemented in E2ETestSouceDemo");
        User user = User.builder()
                .username(ReadProperties.userName())
                .password(ReadProperties.password())
                .firstName(ReadProperties.firstName())
                .lastName(ReadProperties.lastName())
                .zipCode(ReadProperties.zipCode())
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
