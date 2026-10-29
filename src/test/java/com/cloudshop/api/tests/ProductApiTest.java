package com.cloudshop.api.tests;

import com.cloudshop.api.clients.ProductClient;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class ProductApiTest {

    ProductClient productClient =
            new ProductClient(RestAssured.baseURI);

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "https://dummyjson.com";
    }

    @Test
    void shouldReturnProductsSuccessfully() {

        var response = productClient.getAllProducts();

        response.then()
                .statusCode(200)
                .contentType(containsString("application/json"))
                .body("products", not(empty()))
                .body("products[0].id", greaterThan(0))
                .body("products[0].title", not(emptyString()));
    }

    @Test
    void shouldReturnProductById() {

        var response = productClient.getProductById(1);

        response.then().statusCode(200);

        assertEquals(
                1,
                response.jsonPath().getInt("id")
        );
    }

    @Test
    void shouldHandleNonexistentProduct() {

        var response = productClient.getProductById(999999999);

        response
                .then()
                .statusCode(404);
    }


}
