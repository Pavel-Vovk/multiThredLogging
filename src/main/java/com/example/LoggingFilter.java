package com.example;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
        logger.info("Request method: {}, Request URI: {}, Request parameters: {}, Headers: {}",
                requestSpec.getMethod(),
                requestSpec.getURI(),
                requestSpec.getRequestParams(),
                requestSpec.getHeaders());

        Response response = ctx.next(requestSpec, responseSpec);

        logger.info("Response status code: {}, Response body: {}", response.getStatusCode(), response.getBody().asString());

        return response;
    }
}