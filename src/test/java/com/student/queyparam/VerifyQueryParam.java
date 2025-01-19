package com.student.queyparam;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class VerifyQueryParam {

    @Test
    public void test(){

        String endpoint = "https://reqres.in/api/";

        given().log().all()
                .queryParams("page", 2)
                .when()
                .get(endpoint + "users/")
                .then().log().all()
                .body("page", equalTo(2))
                .body("per_page", equalTo(6))
                .body("total_pages", equalTo(2));

    }
}
