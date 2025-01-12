package com.student.firstest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostApi {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    @Test
    public void postBooking(){
       given()
               .contentType(ContentType.JSON)
               .body("{\n" +
                       "    \"firstname\": \"Jimi\",\n" +
                       "    \"lastname\": \"yellow\",\n" +
                       "    \"totalprice\": 1110,\n" +
                       "    \"depositpaid\": true,\n" +
                       "    \"bookingdates\": {\n" +
                       "        \"checkin\": \"2020-01-01\",\n" +
                       "        \"checkout\": \"2023-01-01\"\n" +
                       "    },\n" +
                       "    \"additionalneeds\": \"Breakfast\"\n" +
                       "}")
               .when()
               .post("https://restful-booker.herokuapp.com/booking")
               .then()
               .statusCode(200)
               .log().all();

    }

    @Test
    public void postBooking2(){

        String bodyDetail = "{\n" +
                "    \"firstname\": \"bahvesh\",\n" +
                "    \"lastname\": \"yellow\",\n" +
                "    \"totalprice\": 1110,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2020-01-01\",\n" +
                "        \"checkout\": \"2023-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Breakfast\"\n" +
                "}";
        given()
                .contentType(ContentType.JSON)
                .body(bodyDetail)
                .when()
                .post("https://restful-booker.herokuapp.com/booking")
                .then()
                .statusCode(200)
                .log().all()
                .body("booking.firstname", equalTo("bahvesh"));

    }

    @Test
    public void verifyStatusCode() {
        //Below is the example of testing a POST request in Non-BDD format,
        // where I have used ValidatableResponse for the assertion of status and status line and body of the Response.

        String bodyDetail = "{\n" +
                "    \"firstname\": \"bahvesh\",\n" +
                "    \"lastname\": \"yellow\",\n" +
                "    \"totalprice\": 1110,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2020-01-01\",\n" +
                "        \"checkout\": \"2023-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Breakfast\"\n" +
                "}";

        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/create";

        // Create a request specification
        requestSpecification = given();

        // Setting content type to specify format in which request payload will be sent.
        requestSpecification.contentType(ContentType.JSON);

        // Adding body as string
        requestSpecification.body(bodyDetail);

        // Calling POST method
        response = requestSpecification.post();

        // Let's print response body.
        String responseString = response.prettyPrint();

        /*
         * To perform validation on response, we need to get ValidatableResponse type of
         * response
         */
        validatableResponse = response.then();

        // Check status code
        validatableResponse.statusCode(200);

        // It will check if status line is as expected
        validatableResponse.statusLine("HTTP/1.1 200 OK");

        // Check response body - name attribute
        validatableResponse.body("booking.firstname", equalTo("bahvesh"));

    }
}
