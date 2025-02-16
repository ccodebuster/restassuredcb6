package com.student.responsetime;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ResponseHeader {

    @Test
    public void verifyResponseHeader(){

        given()
                .when()
                .get("https://reqres.in/api/users/2")
                .then().log().all()
                .header("Content-Type", "application/json; charset=utf-8")
                .header("Content-Encoding", "gzip");
    }
}
