package com.petstore.client;

import com.petstore.model.store.Order;
import com.petstore.utils.DefaultRequestParams;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class OrderClient {

    public Response createOrderSuccessfullyFromApi(Order order) {
        return
            given().
                spec(DefaultRequestParams.headerParams()).
                body(order).
            when().
                post("store/order").
            then().
                statusCode(200).
                extract().
                    response();
    }
}
