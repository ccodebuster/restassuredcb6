package com.student.hamcrestassertions;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MultipleAssertion {
    /*hasKey – It checks whether the extracted map has an expected key.*/
   public String endpoint = "https://restful-booker.herokuapp.com/booking/1";

   @Test
    public void test001(){
                given()
                        .contentType(ContentType.JSON)
                        .when()
                        .get(endpoint)
                        .then()
                        .body("firstname", equalTo("Eric"), "lastname", equalTo("Brown1"), "totalprice", equalTo(590));
   }

    @Test  // as soon as one assertion fail programme terminate
    public void test002(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .get(endpoint)
                .then()
                .body("firstname", equalTo("Eric"))
                .body("lastname", equalTo("Brown1"))
                .body( "totalprice", equalTo(590));
    }

    @Test
    public void verifySoftAssertion() {

        // Given
        given()

                // When
                .when()
                .get("https://reqres.in/api/users/2")

                // Then
                .then()

                // To verify the response body
                .body("data.email", equalTo("janet.weaver@reqres12.in"),
                        "data.first_name", equalTo("Janet1"),
                        "data.last_name", equalTo("Weaver"));

    }

    @Test
    public void verifyHardAssertion() {

        // Given
        given()

                // When
                .when()
                .get("https://reqres.in/api/users/2")

                // Then
                .then()

                // To verify the response body
                .body("data.email", equalTo("janet.weaver@reqres12.in"))
                .body("data.first_name", equalTo("Janet1"))
                .body("data.last_name", equalTo("Weaver"));

    }
}
