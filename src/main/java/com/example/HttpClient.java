package com.example;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class HttpClient {
    private RequestSpecification reqSpec;

    public HttpClient() {
        reqSpec = new RequestSpecBuilder()
                .addFilter(new LoggingFilter())
                .build();
    }

    public void get(String url) {
        given()
                .when()
                .get(url)
                .then()
                .statusCode(200);
    }

    public void getWithLoggingAll(String url) {
        given()
                .when()
                .get(url)
                .then()
                .statusCode(200).log().all();
    }
}
