package com.petstore.client;

import com.petstore.model.Pet;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class PetClient {

    public void createPetSuccessfullyFromApi(Pet pet) {
        given().
            contentType(ContentType.JSON).
            accept(ContentType.JSON).
            body(pet).
        when().
            post("/pet").
        then().
            statusCode(200).
            extract().
                response();
    }
}
