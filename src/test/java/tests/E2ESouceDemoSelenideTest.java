package tests;


import configuration.ReadProperties;

import org.testng.annotations.Test;
import baseEntities.BaseTest;
import models.User;
import static com.codeborne.selenide.Condition.visible;

public class E2ESouceDemoSelenideTest extends BaseTest {
    @Test
    public void successfulOrderTest() {
        User user = User.builder()
                .username(ReadProperties.userName())
                .password(ReadProperties.password())
                .firstname(ReadProperties.firstName())
                .lastname(ReadProperties.lastName())
                .zipCode(ReadProperties.zipCode())
                .build();

        userSteps.successfulLogin(user)
                .addToCartProduct()
                .goToCartPage()
                .clickButtonCheckOut()
                .dataInputAndGoToOverview(user)
                .clickFinish()
                .successfulOrderPage().should(visible);
    }
}
