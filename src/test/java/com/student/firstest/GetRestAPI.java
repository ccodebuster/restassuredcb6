package com.student.firstest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRestAPI {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void getAllBooking(){
        given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking")
                .then()
                .statusCode(200);
    }

    @Test
    public void verifyStatusCode(){

        // validate response for the assertion of status and status line of the response
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking";

        // create request specification
        requestSpecification = RestAssured.given();

        //call get method
      response  = requestSpecification.get();

      //let's print response
       String res= response.prettyPrint();
        System.out.println(res);

       validatableResponse = response.then();
       validatableResponse.statusCode(200);

       validatableResponse.statusLine("HTTP/1.1 200 OK");

         int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);

    }

    @Test
    public void verifyBody(){

        given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking/37")
                .then()
                .log().all()
                .statusCode(200)
                .body("firstname", equalTo("Sally"))
                .body("lastname", equalTo("Brown"))
                .body("bookingdates.checkin", equalTo("2013-02-23"));

    }
}
