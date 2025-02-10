package com.petstore.store;

import com.petstore.BaseAPI;
import com.petstore.factory.OrderDataFactory;
import com.petstore.utils.DefaultRequestParams;
import org.junit.jupiter.api.*;

import static com.petstore.utils.TestTags.*;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class OrderContractTest extends BaseAPI {

    @Test
    @Tag(ORDER)
    @Tag(CONTRACT)
    @DisplayName("Should validate the contract for POST Order method")
    void createNewOrderSuccessfully(){
        given().
            spec(DefaultRequestParams.headerParams()).
            body(OrderDataFactory.validOrder()).
        when().
            post("store/order").
        then().
            body(matchesJsonSchemaInClasspath("schemas/order_v2_post_schema.json"));
    }

}