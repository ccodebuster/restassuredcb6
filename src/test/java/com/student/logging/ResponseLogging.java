package com.student.logging;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/*If you want to print the response body regardless of the status code, you can do
get("your endpoint ").then().log().body()..*/

public class ResponseLogging {

    @Test
    public void test(){

        String endpoint = "https://reqres.in/api/";

        given()
                .queryParams("page", 2)
                .when()
                .get(endpoint + "users/")
                .then()
                .log().all()
                .body("page", equalTo(2))
                .body("per_page", equalTo(6))
                .body("total_pages", equalTo(2));

    }
}
