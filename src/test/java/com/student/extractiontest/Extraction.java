package com.student.extractiontest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Extraction {

    public String endpoint = "https://restful-booker.herokuapp.com/booking/1";


    @Test  // as soon as one assertion fail programme terminate
    public void test002(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .get(endpoint)
                .then()
                .body("firstname", equalTo("Susan"))
                .body("lastname", equalTo("Brown"))
                .body( "totalprice", equalTo(238));
    }

    @Test  // through extraction
    public void test003(){
        Response response=given()
                .contentType(ContentType.JSON)
                .when()
                .get(endpoint);

        String firstname= response.then().extract().path("firstname");
        Assert.assertEquals(firstname, "Susan");
    }

    @Test  // through extraction
    public void test004(){
        ValidatableResponse validatableResponse=given()
                .contentType(ContentType.JSON)
                .when()
                .get(endpoint)
                .then();

        String firstname= validatableResponse.extract().path("firstname");
        Assert.assertEquals(firstname, "Susan");
    }
}
