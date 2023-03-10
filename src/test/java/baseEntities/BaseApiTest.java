package baseEntities;

import adapters.MilestoneAdapter;
import adapters.ProjectAdapter;
import configuration.ReadProperties;
import dbTables.MilestoneTable;
import dbTables.ProjectTable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.Milestone;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import services.DataBaseService;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    protected DataBaseService dbService;
    protected ProjectTable projectTable;
    protected MilestoneTable milestoneTable;
    protected MilestoneAdapter milestoneAdapter;
    protected ProjectAdapter projectAdapter;
    protected Milestone expectedMilestone;
    protected int milestoneId;
    protected int projectId;

    @BeforeTest
    public void setUpApi() {
        RestAssured.baseURI = ReadProperties.getUrl();

        RestAssured.requestSpecification = given()
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);

        dbService = new DataBaseService();
        projectTable = new ProjectTable(dbService);
        milestoneTable = new MilestoneTable(dbService);
        milestoneAdapter = new MilestoneAdapter(dbService);
        projectAdapter = new ProjectAdapter(dbService);

        projectTable.dropTable();
        milestoneTable.dropTable();
        projectTable.createTable();
        milestoneTable.createTable();
    }

    @AfterTest
    public void tearDown() {
        dbService.closeConnection();
    }
}
