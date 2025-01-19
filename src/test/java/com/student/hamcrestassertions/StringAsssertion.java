package com.student.hamcrestassertions;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class StringAsssertion {

   public String endpoint = "https://restful-booker.herokuapp.com/booking/1";

   @Test
    public void numberAssertions(){
                given()
                        .contentType(ContentType.JSON)
                        .when()
                        .get(endpoint)
                        .then()
                        .body("firstname", equalTo("Mark"))
                        .body("firstname", equalToIgnoringCase("mark"))
                        .body("firstname", containsString("Mark"))
                        .body("firstname", startsWith("M"))
                        .body("firstname", endsWith("k"))
                        .body("firstname", equalToIgnoringWhiteSpace("   Mark   "));

}}
