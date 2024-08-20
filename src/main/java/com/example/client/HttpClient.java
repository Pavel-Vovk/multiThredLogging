package com.example.client;

import com.example.LoggingFilter;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class HttpClient {
    private RequestSpecification reqSpec;

    public HttpClient() {
        reqSpec = new RequestSpecBuilder()
                .addFilter(new LoggingFilter())
                .build();
        if (reqSpec == null) {
            throw new IllegalStateException("RequestSpecification could not be initialized");
        }
    }

    public void get(String url) {
        given()
                .when()
                .get(url)
                .then()
                .statusCode(200);
    }

    public void get(String url, Map<String, String> headers, int expectedStatusCode, Logger logger) {
        if (headers == null) {
            throw new IllegalArgumentException("Headers cannot be null");
        }
        try {
            RequestSpecification spec = reqSpec.headers(headers);
            given().spec(spec)
                    .when()
                    .get(url)
                    .then()
                    .statusCode(expectedStatusCode);
        } catch (Exception e) {
            logger.error("Error during GET request to URL: {}", url, e);
        }

    }


    public void getWithLoggingAll(String url) {
        given()
                .when()
                .get(url)
                .then()
                .statusCode(200);
    }

    public void getWithLoggingAll(String url, Map<String, String> headers, int expectedStatusCode, Logger logger) {
        if (headers == null) {
            throw new IllegalArgumentException("Headers cannot be null");
        }
        try {
            reqSpec.headers(headers);
            given()
                    .when()
                    .get(url)
                    .then()
                    .statusCode(expectedStatusCode);
        }catch (Exception e) {
            logger.error("Error during GET request to URL: {}", url, e);
        }
    }
}
