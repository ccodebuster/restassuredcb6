package com.student.gorest;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GorestExtraction {
    static ValidatableResponse response;

    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        RestAssured.basePath = "users";
    }

    @Test // get all list
    public void test001(){
       response = given()
                .queryParams("page", 1)
                .queryParams("per_page", 20)
                .get().then().log().all().statusCode(200);
       response.body("[5].name", equalTo("Vaishvi Mukhopadhyay"));
       response.body("find{it.id==7642200}.name", equalTo("Dhanalakshmi Devar"));
      // response.body("name", hasItems("Dhanalakshmi Devar", "Aasa Bhattathiri", "Gobinda Pothuvaal")); // add all name from response

    }

    @Test // verify if total number is 20
    public void test002(){
    // response.log().all().body("size", equalTo(20));

    }


}
