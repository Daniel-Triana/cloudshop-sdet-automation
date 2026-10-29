package com.cloudshop.api.clients;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ProductClient {

    private final String baseUrl;

    public ProductClient(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Response getAllProducts() {
        return given()
                .baseUri(baseUrl)
                .header("Accept", "application/json")
                .when()
                .get("/products");
    }

    public Response getProductById(int productId) {
        return given()
                .baseUri(baseUrl)
                .pathParam("id", productId)
                .when()
                .get("/products/{id}");
    }
}