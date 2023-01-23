package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import elements.CheckBox;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.project.AddProjectPage;
import pages.project.AddTestCasePage;
import steps.NavigationSteps;

public class WrappersTests extends BaseTest {
    @Test
    public void checkBoxTest() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        new NavigationSteps(driver).navigateToAddProjectPage();
        CheckBox checkBox = new CheckBox(driver, By.name("show_announcement"));

        checkBox.setFlag();
        checkBox.removeFlag();
        checkBox.isSelected();
    }

    @Test
    public void radioButtonTest() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        AddProjectPage page = new NavigationSteps(driver).navigateToAddProjectPage();
        page.getType().selectByIndex(1);
        page.getType().selectByValue("3");
        page.getType().selectByText("Use a single repository for all cases (recommended)");
    }
    @Test
    public void dropDownMenuTest() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        projectSteps.openProjectOverview("PR-01");
        testCasesSteps.openTestCases();
        AddTestCasePage page = testCasesSteps.proceedToTestCaseCreate();

        page.getType().showDropDownElements();
        page.getType().search("ance");
        page.getType().showDropDownElements();
    }
}
