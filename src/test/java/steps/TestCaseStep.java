package steps;
import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.project.AddTestCasePage;
import pages.project.ProjectOverviewPage;
import pages.project.TestCasePage;


public class TestCaseStep extends BaseStep {
    private TestCasePage testCasesPage;

    public TestCaseStep(WebDriver driver) {
        super(driver);

        testCasesPage = new TestCasePage(driver);
    }

    public TestCasePage openTestCases() {
        new ProjectOverviewPage(driver).getTestCasesElement().click();

        return testCasesPage;
    }

    public AddTestCasePage proceedToTestCaseCreate() {
        testCasesPage.getAddTestCaseElement().click();

        return new AddTestCasePage(driver);
    }
}
