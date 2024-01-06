package org.kalbeka;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AppTest {

    @Test
    public void testGetRequest() {
        RestAssured.baseURI = "https://postman-echo.com";

        given()
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .extract().response()

                .then().body("url", equalTo("https://postman-echo.com/get"));
    }


    @Test
    public void testPostRequest() {
        RestAssured.baseURI = "https://postman-echo.com";

        given()
                .contentType(ContentType.JSON)
                .body("{\"key1\": \"value1\", \"key2\": \"value2\"}")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .extract().response()

                .then()
                .body("json.key1", equalTo("value1"))
                .body("json.key2", equalTo("value2"));

    }

    @Test
    public void testPutRequest() {
        RestAssured.baseURI = "https://postman-echo.com";

        given()
                .contentType(ContentType.JSON)
                .body("{\"key1\": \"updatedValue1\", \"key2\": \"updatedValue2\"}")
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .extract().response()

                .then()
                .body("json.key1", equalTo("updatedValue1"))
                .body("json.key2", equalTo("updatedValue2"));

    }

    @Test
    public void testPatchRequest() {
        RestAssured.baseURI = "https://postman-echo.com";

        given()
                .contentType(ContentType.JSON)
                .body("{\"key1\": \"updatedValue1\", \"key2\": \"updatedValue2\"}")
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .extract().response()

                .then().body("json.key1", equalTo("updatedValue1"));
    }


    @Test
    public void testDeleteRequest() {
        RestAssured.baseURI = "https://postman-echo.com";

        given()
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .extract().response();
    }
}
