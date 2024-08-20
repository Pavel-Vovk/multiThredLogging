package com.example;

import com.example.client.HttpClient;
import io.qameta.allure.Feature;
import io.qameta.allure.testng.AllureTestNg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.example.client.HeaderManager;

import java.util.Map;

@Listeners({AllureTestNg.class})
public class APITestClientWithHeadersAndStatusCode {
    private String date;
    private static final Logger logger = LoggerFactory.getLogger(APITestClientWithHeadersAndStatusCode.class);
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
    @Feature("API Tests with the external client with Headers and expected Code")
    public void testClient1() {
        logger.info("Start test API Client 1");
        Map<String, String> headers = HeaderManager.getDefaultHeaders();
        httpClient.get("http://httpbin.org/get", headers, 200, logger);
        logger.info("Completed test API Client Headers and expected Code 1");
    }

    @Test
    @Feature("API Tests with the external client with Headers and expected Code")
    public void testClient2() {
        logger.info("Start test API Client 2");
        Map<String, String> headers = HeaderManager.getDefaultHeaders();
        httpClient.getWithLoggingAll("http://httpbin.org/ip", headers, 200, logger);
        logger.info("Completed test API Client Headers and expected Code 2");
    }
}

