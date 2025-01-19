package com.student.crudtest;

import com.student.model.BookingPojo;
import com.student.model.Bookingdates;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BookingTestWithSteps {
    ValidatableResponse validatableResponse;
    String authToken;
    int id;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com"; // base URI
    }

    @Test // get all booking
    public void Test01(){
        given()
                .when()
                .get("/booking")
                .then()
                .statusCode(200);
    }

    @Test // create booking
    public void Test02(){

       /* String bodyDetail = "{\n" +
                "    \"firstname\": \"Bhavesh\",\n" +
                "    \"lastname\": \"Patel\",\n" +
                "    \"totalprice\": 1110,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2020-01-01\",\n" +
                "        \"checkout\": \"2023-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Breakfast\"\n" +
                "}";*/

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2023-04-16");
        bookingdates.setCheckout("2023-04-23");

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("bhavesh");
        bookingPojo.setLastname("patel");
        bookingPojo.setTotalprice(400);
        bookingPojo.setDepositpaid(true);
        bookingPojo.setBookingdates(bookingdates);
        bookingPojo.setAdditionalneeds("snacks");


        validatableResponse = given()
                .contentType(ContentType.JSON)
                .body(bookingPojo)
                .when()
                .post("/booking")
                .then()
                .log().all();

        id = validatableResponse.extract().path("bookingid"); // extracting id
    }



    public void Test03(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/booking/"+id)
                .then()
                .statusCode(200)
                .body("firstname", equalTo("Bhavesh"));

    }

    @Test // generate token
    public void Test04(){
        String AuthBody = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        validatableResponse =given()
                .header("Content-Type", "application/json")
                .when()
                .body(AuthBody)
                .post("/auth")
                .then();

        authToken=validatableResponse.extract().path("token");

    }

    @Test // updating booking
    public void Test05(){
      /*  String bodyDetail = "{\n" +
                "    \"firstname\": \"codebuster\",\n" +
                "    \"lastname\": \"Patel\",\n" +
                "    \"totalprice\": 1110,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2020-01-01\",\n" +
                "        \"checkout\": \"2023-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Breakfast\"\n" +
                "}";*/

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2023-04-16");
        bookingdates.setCheckout("2023-04-23");

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("codebuster");
        bookingPojo.setLastname("patel");
        bookingPojo.setTotalprice(400);
        bookingPojo.setDepositpaid(true);
        bookingPojo.setBookingdates(bookingdates);
        bookingPojo.setAdditionalneeds("snacks");

        validatableResponse = given()
                .log().all()
                .contentType(ContentType.JSON)
                .header("Cookie", "token="+authToken) //Cookie: token=abc123
                .body(bookingPojo)
                .when()
                .put("/booking/"+id)
                .then()
                .log().all()
                .body("firstname", equalTo("codebuster"));
    }

    @Test // delete by id
    public void Test06(){

        given()
                .contentType(ContentType.JSON)
                .header("Cookie", "token="+authToken) //Cookie: token=abc123
                .when()
                .delete("/booking/"+id)
                .then()
                .statusCode(201)
                .log().all();
    }

    @Test // get by id
    public void Test07(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/booking/"+id)
                .then()
                .statusCode(404);

    }
}
