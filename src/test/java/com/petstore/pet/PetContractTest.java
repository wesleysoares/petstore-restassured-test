package com.petstore.pet;

import com.petstore.BaseAPI;
import com.petstore.client.PetClient;
import com.petstore.factory.PetDataFactory;
import com.petstore.utils.DefaultRequestParams;
import org.junit.jupiter.api.*;

import static com.petstore.utils.TestTags.*;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class PetContractTest extends BaseAPI {

    @Test
    @Tag(PET)
    @Tag(CONTRACT)
    @DisplayName("Should validate the contract for POST Pet method")
    void createNewPetSuccessfully(){
        given().
            spec(DefaultRequestParams.headerParams()).
            body(PetDataFactory.validPet()).
        when().
            post("/pet").
        then().
            body(matchesJsonSchemaInClasspath("schemas/pet_v2_create_schema.json"));
    }

    @Test
    @Tag(PET)
    @Tag(CONTRACT)
    @DisplayName("Should validate the contract for GET Pet by ID method")
    void returnPetById(){
        //It is necessary to create a valid Pet registration to ensure consistency in test data
        var pet = new PetClient().createPetSuccessfullyFromApi(PetDataFactory.validPet());

        given().
            spec(DefaultRequestParams.headerParams()).
            pathParam("id", pet.getBody().path("id").toString()).
        when().
            get("/pet/{id}").
        then().
            body(matchesJsonSchemaInClasspath("schemas/pet_v2_get_schema.json"));
    }
}
