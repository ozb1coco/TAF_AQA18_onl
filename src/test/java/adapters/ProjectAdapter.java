package adapters;

import dbTables.ProjectTable;
import io.restassured.mapper.ObjectMapperType;
import models.Project;
import org.apache.http.HttpStatus;
import services.DataBaseService;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class ProjectAdapter {
    private Project expectedProject;
    private ProjectTable projectTable;
    private int projectId;

    public ProjectAdapter(DataBaseService dbService) {
        projectTable = new ProjectTable(dbService);
    }

    public int addProject() {
        expectedProject = Project.builder()
                .name("ProjectByTest123")
                .announcement("This is a description")
                .showAnnouncement(true)
                .type(1)
                .build();

        projectTable.addProject(expectedProject);

        return projectId = given()
                .body(expectedProject, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath()
                .getInt("id");
    }

    public void deleteProject(int projectId) {
        given()
                .pathParam("project_id", projectId)
                .when()
                .post(Endpoints.DELETE_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK);

        projectTable.deleteProjectById(projectId);
    }
}