package adapters;

import dbTables.MilestoneTable;
import io.restassured.mapper.ObjectMapperType;
import models.Milestone;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.DataBaseService;
import utils.Endpoints;

import java.sql.ResultSet;
import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MilestoneAdapter {
    private Milestone expectedMilestone;
    private MilestoneTable milestoneTable;

    Logger logger = LogManager.getLogger(MilestoneAdapter.class);

    public MilestoneAdapter(DataBaseService dbService) {
        milestoneTable = new MilestoneTable(dbService);
    }

    public int addMilestone(Milestone milestone, int projectId) {
        expectedMilestone = Milestone.builder()
                .name("MilestoneTest")
                .description("TestNumber1546")
                .references("TestByTest")
                .completed(true)
                .build();

        milestoneTable.addMilestone(expectedMilestone);

        return given()
                .pathParam("project_id", projectId)
                .body(milestone, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.ADD_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("name", equalTo(milestone.getName()))
                .body("description", equalTo(milestone.getDescription()))
                .extract()
                .jsonPath()
                .getInt("id");
    }

    public void getMilestone(Milestone milestone,int milestoneId) {
        ResultSet rs = milestoneTable.getMilestoneById(milestoneId);

        given()
                .pathParam("milestone_id", milestoneId)
                .when()
                .get(Endpoints.GET_MILESTONE)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("name", equalTo(expectedMilestone.getName()))
                .body("description", equalTo(expectedMilestone.getDescription()));

        try {
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String refs = rs.getString("refs");
                boolean is_completed = rs.getBoolean("is_completed");

                logger.info("MilestoneID: " +rs.getString("id"));
                logger.info("Name: " +rs.getString("name"));
                logger.info("Description: " +rs.getString("description"));
                logger.info("Refs: " +rs.getString("refs"));
                logger.info("Is_completed: " +rs.getString("is_completed"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateMilestone(Milestone milestone, int milestoneId) {
        given()
                .pathParam("milestone_id", milestoneId)
                .body(milestone, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.UPDATE_MILESTONE)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("name", equalTo(milestone.getName()))
                .body("description", equalTo(milestone.getDescription()));

        milestoneTable.updateMilestone(milestone);
    }

    public void deleteMilestone(int milestoneId) {
        given()
                .pathParam("milestone_id", milestoneId)
                .when()
                .post(Endpoints.DELETE_MILESTONE)
                .then()
                .statusCode(HttpStatus.SC_OK);

        milestoneTable.deleteMilestone(milestoneId);
    }
}