package com.student.jsconschemavalidator;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

/*To log all request specification details including parameters, headers, and body of the request, log().all() needs to be added to post given() section.*/

public class JsonCompare {

    @Test
    public void test(){

        String endpoint = "https://reqres.in/api/";

        given().log().all()
                .queryParams("page", 3)
                .when()
                .get(endpoint + "users/")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("user.json"));

    }

}
