package tests.api;

import adapters.MilestoneAdapter;
import adapters.ProjectAdapter;
import baseEntities.BaseApiGsonTest;
import models.Milestone;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
public class MilestoneTest extends BaseApiGsonTest {

    int projectId;
    int milestoneId;
    Milestone expectedMilestone;
    ProjectAdapter projectAdapter = new ProjectAdapter();
    MilestoneAdapter milestoneAdapter = new MilestoneAdapter();

    @Test
    public void addProject() {

        Project expectedProject = new Project();
        expectedProject.setName("Project_01");
        expectedProject.setAnnouncement("Description of Project");
        expectedProject.setType(1);
        expectedProject.setShownAnnouncement(true);

        Project actualProject = projectAdapter.add(expectedProject);
        projectId = actualProject.getId();
        Assert.assertEquals(expectedProject, actualProject);
    }


    @Test(dependsOnMethods = "addProject")
    public void addMilestone() {
        expectedMilestone = new Milestone();
        expectedMilestone.setName("Milestone 1");
        expectedMilestone.setDescription("Description of milestone");
        expectedMilestone.setCompleted(false);

        Milestone actualMilestone = milestoneAdapter.addMilestone(expectedMilestone, projectId);

        milestoneId = actualMilestone.getId();
    }

    @Test(dependsOnMethods = "addMilestone")
    public void getMilestone() {
        Milestone actualMilestone = milestoneAdapter.getMilestone(milestoneId);
        Assert.assertEquals(actualMilestone, expectedMilestone);
    }

    @Test(dependsOnMethods = "getMilestone")
    public void updateMilestone() {
        expectedMilestone.setName("Updated milestone");
        expectedMilestone.setDescription("New Description");
        expectedMilestone.setCompleted(true);

        Milestone actualMilestone = milestoneAdapter.updateMilestone(milestoneId, expectedMilestone);
        Assert.assertEquals(actualMilestone, expectedMilestone);
    }

    @Test(dependsOnMethods = "updateMilestone")
    public void deleteMilestone() {
        milestoneAdapter.deleteMilestone(milestoneId);
        milestoneAdapter.getDeletedMilestone(milestoneId);
    }
}
