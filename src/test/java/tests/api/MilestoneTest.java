package tests.api;

import baseEntities.BaseApiTest;
import models.Milestone;
import org.testng.annotations.Test;


public class MilestoneTest extends BaseApiTest {
    @Test
    public void addMilestone() {
        projectId = projectAdapter.addProject();

        expectedMilestone = Milestone.builder()
                .name("MilestoneTest")
                .description("TestNumber1546")
                .references("TestByTest")
                .completed(false)
                .build();

        milestoneId = milestoneAdapter.addMilestone(expectedMilestone, projectId);
    }

    @Test(dependsOnMethods = "addMilestone")
    public void getMilestone() {
        milestoneAdapter.getMilestone(expectedMilestone, milestoneId);
    }

    @Test(dependsOnMethods = "getMilestone")
    public void updateMilestone() {
        Milestone updateMilestone = Milestone.builder()
                .name("MilestoneUpdate")
                .description("New Update")
                .references("reference for milestone")
                .build();

        milestoneAdapter.updateMilestone(updateMilestone, milestoneId);
    }

    @Test(dependsOnMethods = "updateMilestone")
    public void deleteMilestone() {
        milestoneAdapter.deleteMilestone(milestoneId);
    }

    @Test(dependsOnMethods = "deleteMilestone")
    public void deleteProject() {
        projectAdapter.deleteProject(projectId);
    }
}
