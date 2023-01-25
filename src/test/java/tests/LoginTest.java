package tests;
import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.qameta.allure.*;
import models.Project;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.NavigationSteps;

public class LoginTest extends BaseTest {

    @Test (description = "Description")
    @Issue("AQA18-12")
    @TmsLink("TC-001")
    @Description("Description1")
    @Link("https://onliner.by")
    @Link(name = "catalog", type = "mylink", url = "https://onliner.by")
    @Severity(SeverityLevel.BLOCKER)
    public void loginSuccessfulTest() {
        User user = new User.Builder().withEmail(ReadProperties.username())
                        .withPasssword(ReadProperties.password())
                                .build();
        Assert.assertTrue(
                userStep.loginSuccessful(user)
                        .isPageOpened()
        );
    }
}
