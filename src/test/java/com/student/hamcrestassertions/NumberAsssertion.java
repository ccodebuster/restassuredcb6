package com.student.hamcrestassertions;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class NumberAsssertion {

   public String endpoint = "https://restful-booker.herokuapp.com/booking/1";

   @Test
    public void numberAssertions(){
                given()
                        .contentType(ContentType.JSON)
                        .when()
                        .get(endpoint)
                        .then()
                        .body("totalprice", equalTo(538))
                        .body("totalprice", greaterThan(100))
                        .body("totalprice", greaterThanOrEqualTo(100))
                        .body("totalprice", lessThan(600))
                        .body("totalprice", lessThanOrEqualTo(538));
   }

    @Test
    public void numberAssertions1(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .get(endpoint)
                .then()
                .body("totalprice", equalTo(538),
                        "totalprice", greaterThan(100),
                        "totalprice", greaterThanOrEqualTo(100),
                        "totalprice", lessThan(600), "totalprice",
                        lessThanOrEqualTo(560));

    }
}
