package com.student.crudtest;

import com.student.model.Datum;
import com.student.model.Products;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ProductCrudTest {
          static int id;

    @BeforeClass
    public static void inIt() {

        RestAssured.baseURI = "http://localhost"; // base URI
        RestAssured.port = 3030;
        RestAssured.basePath = "/products";
    }

    @Test
    public void test001(){
       Products products = given()
                .when()
                .get().getBody().as(Products.class);
        System.out.println(products.getTotal());
        System.out.println(products.getLimit());
    }

    @Test //Post product and retrive id
    public void test002(){

        Datum pojo = new Datum();
        pojo.setName("bhav423");
        pojo.setType("kbhgvs");
        pojo.setPrice(1722);
        pojo.setShipping(23);
        pojo.setUpc("gdtht");
        pojo.setDescription("desp");
        pojo.setManufacturer("auvbdi");
        pojo.setModel("fordxf");
        pojo.setUrl("dbd");
        pojo.setImage("jhkjb");

       Response response= given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .body(pojo)
                .post();

      Datum datum = response.getBody().as(Datum.class);
        id= datum.getId();
        System.out.println(id);
    }

    @Test //update  product  by id
    public void test003(){

        Datum data = new Datum();
        data.setPrice(1589);
        data.setShipping(234);
        data.setManufacturer("audir");
        data.setModel("bm");

        Response response= given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", id)
                .when()
                .body(data)
                .patch("/{id}");
        response.then().log().all().statusCode(200);

    }

    @Test //delete  product  by id
    public void test004(){

        Response response= given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", id)
                .when()
                .delete("/{id}");
        response.then().log().all().statusCode(200);

    }

    @Test //get  product  by id
    public void test005(){

        Response response= given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", id)
                .when()
                .get("/{id}");
        response.then().log().all().statusCode(404);

    }

}
