package com.petstore.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class DefaultRequestParams {
    public static RequestSpecification headerParams() {
        return new RequestSpecBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("accept", "application/json")
                .build();
    }
}
