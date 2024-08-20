package com.example;

import io.qameta.allure.Feature;
import io.qameta.allure.testng.AllureTestNg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Listeners({AllureTestNg.class})
public class APITestClient {
    private String date;
    private static final Logger logger = LoggerFactory.getLogger(APITestClient.class);
    private HttpClient httpClient;

    @BeforeClass
    public void init(){
        date = DateTimeUtils.getNow();
        httpClient = new HttpClient();
    }

    @BeforeMethod
    public void setUp() {
        String id = String.valueOf(Thread.currentThread().getId());
        String name = date + getClass().getName() + '-' + id;
        MDC.put("threadName", name);
    }

    @Test
    @Feature("API Tests with the external client")
    public void testClient1() {
        logger.info("Start test API Client 1");
        httpClient.get("http://httpbin.org/get");
        logger.info("Completed test API Client 1");
    }

    @Test
    @Feature("API Tests with the external client")
    public void testClient2() {
        logger.info("Start test API Client 2");
        httpClient.getWithLoggingAll("http://httpbin.org/ip");
        logger.info("Completed test API Client 2");
    }

    @Test
    @Feature("API Tests with the external client")
    public void testClient3() {
        logger.info("Start test API Client 3");
        httpClient.get("http://httpbin.org/get3");
        logger.info("Completed test API Client 3");
    }


    @Test
    @Feature("API Tests with the external client")
    public void testClient4() {
        logger.info("Start test API Client 4");
        httpClient.get("http://httpbin.org/get4");
        logger.info("Completed test API Client 4");
    }


    @Test
    @Feature("API Tests with the external client")
    public void testClient5() {
        logger.info("Start test API Client 5");
        httpClient.get("http://httpbin.org/get5");
        logger.info("Completed test API Client 5");
    }


    @Test
    @Feature("API Tests with the external client")
    public void testClient6() {
        logger.info("Start test API Client 6");
        httpClient.get("http://httpbin.org/get6");
        logger.info("Completed test API Client 6");
    }


    @Test
    @Feature("API Tests with the external client")
    public void testClient7() {
        logger.info("Start test API Client 7");
        httpClient.get("http://httpbin.org/get7");
        logger.info("Completed test API Client 7");
    }


}

