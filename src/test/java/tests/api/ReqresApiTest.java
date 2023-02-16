package tests.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ReqresApiTest {
    @Test
    public void simpleStepByStepApiTest(){
        // Setup restAssured
        RestAssured.baseURI = "https://reqres.in/";

        // Setup endpoint
        int userID = 2;
        String endpoint = "/api/users/" + userID;

        //Setup request object
        RequestSpecification httpRequest = given();

        //Setup response Object
        Response response = httpRequest.request(Method.GET, endpoint);

        System.out.println(response.body());

        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode,200);
        Assert.assertEquals(statusCode, HttpStatus.SC_OK);

        //get response body
        System.out.println(response.getBody().asPrettyString());
    }

    @Test
    public void shortApiTest(){
        // Setup restAssured
        RestAssured.baseURI = "https://reqres.in/";

        // Setup endpoint
        int userID = 2;
        String endpoint = "/api/users/" + userID;

        given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }
}
