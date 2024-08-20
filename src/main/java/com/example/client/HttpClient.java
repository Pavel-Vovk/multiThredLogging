package com.example.client;

import com.example.LoggingFilter;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

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

    public void get(String url, Map<String, String> headers, int expectedStatusCode) {
        RequestSpecification spec = reqSpec.headers(headers);
        spec.when()
                .get(url)
                .then()
                .statusCode(expectedStatusCode);
    }


    public void getWithLoggingAll(String url) {
        given()
                .when()
                .get(url)
                .then()
                .statusCode(200).log().all();
    }

    public void getWithLoggingAll(String url, Map<String, String> headers, int expectedStatusCode) {
        RequestSpecification spec = reqSpec.headers(headers);
        spec.when()
                .get(url)
                .then()
                .statusCode(expectedStatusCode)
                .log().all();
    }
}
