package api;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiContractTest {
    @Test
    public void getExampleJson_shouldHaveExpectedFields() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        given()
                .when().get("/posts/1")
                .then()
                .statusCode(200)
                .body("userId", greaterThan(0))
                .body("id", equalTo(1))
                .body("title", not(isEmptyOrNullString()));
    }
}