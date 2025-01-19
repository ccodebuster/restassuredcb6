package com.student.hamcrestassertions;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.equalTo;

public class NullAsssertion {
    /*hasKey – It checks whether the extracted map has an expected key.*/
   public String endpoint = "https://restful-booker.herokuapp.com/booking/1";

   @Test
    public void collectionAssertions(){
                given()
                        .contentType(ContentType.JSON)
                        .when()
                        .get(endpoint)
                        .then()
                        .body("totalprice", equalTo(347))
                        .body("totalprice", is(nullValue()));

   }
}
