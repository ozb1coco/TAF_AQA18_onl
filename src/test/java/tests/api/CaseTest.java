package tests.api;

import adapters.CaseAdapter;
import baseEntities.BaseApiGsonTest;
import models.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class CaseTest extends BaseApiGsonTest {
    TestCase expectedCase;
    CaseAdapter caseAdapter = new CaseAdapter();
    int caseId;

    @Test
    public void addCase() {
        int sectionId = 1;
        expectedCase = new TestCase();
        expectedCase.setTitle("Test case 1");
        expectedCase.setSectionId(1);
        expectedCase.setTemplateId(1);
        expectedCase.setTypeId(1);
        expectedCase.setPriorityId(2);

        TestCase actualCase = caseAdapter.add(expectedCase, sectionId);
        caseId = actualCase.getId();

        Assert.assertEquals(actualCase, expectedCase);
    }

    @Test(dependsOnMethods = "addCase")
    public void get() {
        TestCase actualCase = caseAdapter.get(caseId);
        Assert.assertEquals(actualCase, expectedCase);
    }

    @Test(dependsOnMethods = "get")
    public void updateCase() {
        expectedCase.setPreconditions("New test case");
        expectedCase.setSteps("New steps");
        expectedCase.setExpectedResult("New result");

        TestCase actualCase = caseAdapter.update(expectedCase, caseId);
        Assert.assertEquals(actualCase, expectedCase);
    }


    @Test(dependsOnMethods = "updateCase")
    public void moveToSection() {
        //
    }

    @Test(dependsOnMethods = "moveToSection")
    public void deleteCase() {
        caseAdapter.deleteCase(caseId);
        caseAdapter.getDeleted(caseId);
    }
}