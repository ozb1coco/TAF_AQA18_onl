package tests.gui;
import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.qameta.allure.*;
import models.Project;
import models.User_GUI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailInput().sendKeys(ReadProperties.username());
        loginPage.getPassword().sendKeys(ReadProperties.password());
        loginPage.getLogInButton().click();

        Assert.assertTrue(new DashboardPage(driver).isPageOpened());
    }

    @Test(description = "Description")
    @Issue("AQA18-12")
    @TmsLink("TC-001")
    @Description("Description1")
    @Link("https://onliner.by")
    @Link(name = "catalog", type = "mylink", url = "https://onliner.by")
    @Severity(SeverityLevel.BLOCKER)
    public void loginSuccessfulTest() {
        User_GUI user = new User_GUI.Builder()
                .withEmail(ReadProperties.username())
                .withPassword(ReadProperties.password())
                .build();

        Assert.assertTrue(
                userStep.loginSuccessful(user)
                        .isPageOpened()
        );
    }

    @Test
    public void loginIncorrectTest() {
        Assert.assertEquals(
                userStep.loginIncorrect(ReadProperties.username(), "sdfsdfsdf")
                        .getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again."
        );
    }

    @Test
    public void addProjectTest() {
        Project project = new Project();
        project.setName("WP_01");
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        projectSteps.addProject(project);

        Assert.assertEquals(driver.findElement(By.className("page_title")).getText(),
                project.getName());
    }
}
