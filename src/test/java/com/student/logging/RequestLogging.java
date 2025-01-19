package com.student.logging;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/*To log all request specification details including parameters, headers, and body of the request, log().all() needs to be added to post given() section.*/

public class RequestLogging {

    @Test
    public void test(){

        String endpoint = "https://reqres.in/api/";

        given().log().all()
                .queryParams("page", 2)
                .when()
                .get(endpoint + "users/")
                .then()
                .body("page", equalTo(2))
                .body("per_page", equalTo(6))
                .body("total_pages", equalTo(2));

    }

        /*Other different request logging options are:-
 1. given().log().params(). .. // Log only the parameters of the request
 2. given().log().body(). .. // Log only the request body
 3. given().log().headers(). .. // Log only the request headers
 4. given().log().cookies(). .. // Log only the request cookies
 5. given().log().method(). .. // Log only the request method
 6. given().log().path(). .. // Log only the request path*/
}
