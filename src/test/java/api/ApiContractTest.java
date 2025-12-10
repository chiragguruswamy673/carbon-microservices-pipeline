package api;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiContractTest {
    @BeforeClass
    public void setup() {
        String base = System.getProperty("base.url", "http://localhost:8080");
        RestAssured.baseURI = base + "/api";
    }

    @Test
    public void healthEndpointReturnsOk() {
        given()
                .when().get("/health")
                .then()
                .statusCode(200)
                .body("status", equalTo("ok"));
    }
}