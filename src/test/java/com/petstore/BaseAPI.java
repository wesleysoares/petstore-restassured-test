package com.petstore;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public class BaseAPI {

    @BeforeAll
    public static void beforeAllTests(){
        baseURI = "https://petstore.swagger.io/v2";
    }

}
