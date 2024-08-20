# API Test Documentation

## Overview

This document outlines the setup and execution process for API testing within environment. The tests utilize a combination of technologies including TestNG for test management, Logback for logging, Allure for reporting, and RestAssured for interacting with APIs.

### Technologies Used

- **Test Run:** TestNG - A testing framework designed to simplify a broad range of testing needs.
- **Logging:** Logback coupled with MultiThreading - Provides robust logging capabilities.
- **Reporting:** TestNG and Allure - Ensures comprehensive report generation.
- **API Approach:** RestAssured - Facilitates testing of REST APIs.

## Setup

Ensure that the environment is set up with all necessary dependencies for TestNG, Logback, Allure, and RestAssured. This includes configuring the build scripts (e.g., `build.gradle` for Gradle projects) and setting up the proper configurations for each component.

### Requirements

- Java JDK 8
- Gradle
- TestNG
- Logback
- Allure
- RestAssured

## Running Tests

To execute the tests, use the following commands in your terminal:

### Executing Tests with Gradle

```bash
./gradlew test
```
then
```bash
./gradlew allureReport
```

