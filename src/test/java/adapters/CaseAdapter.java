package adapters;

import io.restassured.mapper.ObjectMapperType;
import models.TestCase;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.sessionId;

public class CaseAdapter {

    public TestCase add(TestCase testCase, int sectionId) {
        return given()
                .pathParam("section_id", sectionId)
                .body(testCase, ObjectMapperType.GSON)
                .log().all()
                .when()
                .post(Endpoints.ADD_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(TestCase.class, ObjectMapperType.GSON);
    }

    public TestCase update(TestCase testCase, int caseId) {
        return given()
                .pathParam("case_id", caseId)
                .body(testCase, ObjectMapperType.GSON)
                .log().all()
                .when()
                .post(Endpoints.UPDATE_CASE)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().all()
                .extract().as(TestCase.class, ObjectMapperType.GSON);
    }

    public TestCase get(int caseId) {
        return given()
                .pathParam("case_id", caseId)
                .log().uri()
                .when()
                .get(Endpoints.GET_CASE)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().all()
                .extract().as(TestCase.class, ObjectMapperType.GSON);
    }

    public void getDeleted(int caseId) {
        given()
                .pathParam("case_id", caseId)
                .log().uri()
                .when()
                .get(Endpoints.GET_CASE)
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    public void moveToCase() {
        //Не понимаю как вывести на новый кейс
    }

    public void deleteCase(int caseId) {
        given()
                .pathParam("case_id", caseId)
                .log().uri()
                .when()
                .post(Endpoints.DELETE_CASE)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
