package com.petstore.client;

import com.petstore.model.pet.Pet;
import com.petstore.utils.DefaultRequestParams;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PetClient {

    public Response createPetSuccessfullyFromApi(Pet pet) {
        return
            given().
                spec(DefaultRequestParams.headerParams()).
                body(pet).
            when().
                post("/pet").
            then().
                statusCode(200).
                extract().
                    response();
    }
}
