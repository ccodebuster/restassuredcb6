package com.student.studentinfo;

import com.student.constants.Path;
import com.student.utils.TestUtils;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.containsString;

/**
 * Created by bhavesh
 */

@RunWith(SerenityRunner.class)
public class ProductCURDTestWithSteps {

    static String name = "Energizer" + TestUtils.getRandomValue();
    static String type = "hardgood";
    static int price = 499;
    static String upc = "499" + TestUtils.getRandomValue();
    static int shipping = 0;
    static String description = "4-pack AA alkaline batteries; battery tester included";
    static String manufacturer = "any";
    static String model = "model D";
    static String setUrl = "http://www.bestbuy.com/site/energizer-max-batteries-aa-4-pack/150115.p?id=1051384046217&skuId=150115&cmp=RMXCC";
    static int idNumber;
    ValidatableResponse response;

    @Steps
    ProdtSteps prodtSteps;

    @Before
    public void init() {

        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = Path.PRODUCTS;
    }

    @Title("This will create a new product")
    @Test
    public void test001() {

        response = prodtSteps.createProduct(name, type, price, upc, shipping, description, manufacturer, model, setUrl);
        response.statusCode(201);
        idNumber = response.extract().path("id");
        System.out.println(idNumber);

    }

    @Title("verify if product is created")
    @Test
    public void test002() {
       response=prodtSteps.getProductInfoById(idNumber);
       response.statusCode(200);
       response.body("name", containsString(name));
    }

    @Title("update the product information")
    @Test
    public void test003() {

        name = name + "xyz";
        response = prodtSteps.updateProduct(idNumber, name, type, price, upc, shipping, description, manufacturer, model, setUrl);
        response.body("name",containsString(name));
    }

    @Title("Delete student info by StudentID and verify its deleted")
    @Test
    public void test004() {
        prodtSteps.deleteProductInfoByID(idNumber).statusCode(200);
        prodtSteps.getProductInfoById(idNumber).statusCode(404);

    }

}
