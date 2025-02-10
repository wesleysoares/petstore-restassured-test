package com.petstore.pet;

import com.petstore.BaseAPI;
import com.petstore.client.PetClient;
import com.petstore.factory.PetDataFactory;
import com.petstore.utils.DefaultRequestParams;
import org.junit.jupiter.api.*;

import static com.petstore.utils.TestTags.CONTRACT;
import static com.petstore.utils.TestTags.PET;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class PetContractTest extends BaseAPI {

    @Test
    @Tag(PET)
    @Tag(CONTRACT)
    @DisplayName("Should validate the contract for POST Pet method")
    void createNewPetSuccessfully(){
        var petValid = PetDataFactory.validPet();

        given().
            spec(DefaultRequestParams.headerParams()).
            body(petValid).
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
        final var petValid = PetDataFactory.validPet();

        //It is necessary to create a valid Pet registration to ensure consistency in test data
        new PetClient().createPetSuccessfullyFromApi(petValid);

        given().
            spec(DefaultRequestParams.headerParams()).
            pathParam("id", petValid.getId()).
        when().
            get("/pet/{id}").
        then().
            body(matchesJsonSchemaInClasspath("schemas/pet_v2_get_schema.json"));;
    }
}
