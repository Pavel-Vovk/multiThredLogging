package com.example;

import io.qameta.allure.Feature;
import org.slf4j.MDC;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Listeners({AllureTestNg.class})
public class APITest {
    String date;
    private static final Logger logger = LoggerFactory.getLogger(APITest.class);

    @BeforeClass
    public void init(){
        date = DateTimeUtils.getNow();
    }

    @BeforeMethod
    public void setUp() {
        String id = String.valueOf(Thread.currentThread().getId());
        String name = date + getClass().getName() + '-' + id;
        MDC.put("threadName", name);
    }

    @Test
    @Feature("API Tests without the external client")
    public void testAPI1() {
        logger.info("Start test API 1");
        given().filter(new LoggingFilter()).
                when().
                get("http://httpbin.org/get").
                then().
                statusCode(200);

        logger.info("Completed test API 1");
    }

    @Test
    @Feature("API Tests without the external client")
    public void testAPI2() {
        logger.info("Start test API 2");
        given().filter(new LoggingFilter()).
                when().log().all().
                get("http://httpbin.org/ip").
                then().
                statusCode(200).log().all();
        logger.info("Completed test API 2");
    }

    @Test
    @Feature("API Tests without the external client")
    public void testAPI3() {
        logger.info("Start test API 3");
        given().filter(new LoggingFilter()).
                when().log().all().
                get("http://httpbin.org/ip3").
                then().
                statusCode(200).log().all();
        logger.info("Completed test API 3");
    }


    @Test
    @Feature("API Tests without the external client")
    public void testAPI4() {
        logger.info("Start test API 4");
        given().filter(new LoggingFilter()).
                when().log().all().
                get("http://httpbin.org/ip4").
                then().
                statusCode(200).log().all();
        logger.info("Completed test API 4");
    }


    @Test
    @Feature("API Tests without the external client")
    public void testAPI5() {
        logger.info("Start test API 5");
        given().filter(new LoggingFilter()).
                when().log().all().
                get("http://httpbin.org/ip5").
                then().
                statusCode(200).log().all();
        logger.info("Completed test API 5");
    }


    @Test
    @Feature("API Tests without the external client")
    public void testAPI6() {
        logger.info("Start test API 6");
        given().filter(new LoggingFilter()).
                when().log().all().
                get("http://httpbin.org/ip6").
                then().
                statusCode(200).log().all();
        logger.info("Completed test API 6");
    }


    @Test
    @Feature("API Tests without the external client")
    public void testAPI7() {
        logger.info("Start test API 7");
        given().filter(new LoggingFilter()).
                when().log().all().
                get("http://httpbin.org/ip7").
                then().
                statusCode(200).log().all();
        logger.info("Completed test API 7");
    }

}

