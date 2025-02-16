package com.student.studentinfo;


import com.student.constants.EndPoints;
import com.student.model.ProductsPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;


/**
 * Created by bhavesh
 */
public class ProdtSteps {

    @Step("creating new product")
    public ValidatableResponse createProduct(String name, String type, int price, String upc, int shipping, String description, String manufacturer, String model, String setUrl) {

        ProductsPojo datum = new ProductsPojo();
        datum.setName(name);
        datum.setType(type);
        datum.setPrice(price);
        datum.setUpc(upc);
        datum.setShipping(shipping);
        datum.setDescription(description);
        datum.setManufacturer(manufacturer);
        datum.setModel(model);
        datum.setUrl(setUrl);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(datum)
                .when()
                .post()
                .then().log().all().statusCode(201);

    }

    @Step("update products")
    public ValidatableResponse updateProduct(int productID, String name, String type, int price, String upc, int shipping, String description, String manufacturer, String model, String setUrl) {
        ProductsPojo datum = new ProductsPojo();
        datum.setName(name);
        datum.setType(type);
        datum.setPrice(price);
        datum.setUpc(upc);
        datum.setShipping(shipping);
        datum.setDescription(description);
        datum.setManufacturer(manufacturer);
        datum.setModel(model);
        datum.setUrl(setUrl);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(datum)
                .pathParam("productID", productID)
                .when()
                .patch(EndPoints.UPDATE_PRODUCT_BY_ID)
                .then();

    }

    @Step("deleteing product")
    public ValidatableResponse deleteProductInfoByID(int productID) {
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("productID", productID)
                .when()
                .delete(EndPoints.DELETE_PRODUCT_BY_ID)
                .then().log().all().statusCode(200);

    }

    @Step("get product by ID")
    public ValidatableResponse getProductInfoById(int productID) {
        return SerenityRest.given().log().all()
                .pathParam("productID", productID)
                .when()
                .get(EndPoints.GET_SINGLE_PRODUCT_BY_ID)
                .then().log().all();
    }

    @Step("getting all products")
    public ValidatableResponse getAllProductInfo() {
        return SerenityRest.given()
                .when()
                .get()
                .then();
    }
}
