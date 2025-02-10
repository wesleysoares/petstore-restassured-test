package com.petstore.pet;

import com.petstore.BaseAPI;
import com.petstore.client.PetClient;
import com.petstore.factory.PetDataFactory;
import com.petstore.utils.DefaultRequestParams;
import org.junit.jupiter.api.*;

import java.util.Random;

import static com.petstore.utils.TestTags.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PetFunctionalTest extends BaseAPI {

    @Test
    @Tag(PET)
    @Tag(FUNCTIONAL)
    @DisplayName("Should create a new pet")
    void createNewPetSuccessfully(){
        given().
            spec(DefaultRequestParams.headerParams()).
            body(PetDataFactory.validPet()).
        when().
            post("/pet").
        then().
            statusCode(200);
    }

    @Test
    @Tag(PET)
    @Tag(FUNCTIONAL)
    @DisplayName("Should find a pet filtered by Id")
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
            statusCode(200).
            body(
                "id", equalTo(petValid.getId()),
                "category.id", equalTo(petValid.getCategory().getId()),
                "category.name", equalTo(petValid.getCategory().getName()),
                "name", equalTo(petValid.getName()),
                "photoUrls[0]", equalTo(petValid.getPhotoUrls().get(0)),
                "tags[0].id", equalTo(petValid.getTags().get(0).getId()),
                "tags[0].name", equalTo(petValid.getTags().get(0).getName()),
                "status", equalTo(petValid.getStatus())
            );
    }

    @Test
    @Tag(PET)
    @Tag(FUNCTIONAL)
    @DisplayName("Should find a pet filtered by Id")
    void notFoundPetById(){
        given().
            spec(DefaultRequestParams.headerParams()).
            pathParam("id", new Random().nextLong()).
        when().
            get("/pet/{id}").
        then().
            statusCode(404).
            body("message", equalTo("Pet not found"));

    }

    @Test
    @Tag(PET)
    @Tag(FUNCTIONAL)
    @DisplayName("Should delete a pet by Id")
    void deletePetById(){
        //It is necessary to create a valid Pet registration to ensure consistency in test data
        var pet = new PetClient().createPetSuccessfullyFromApi(PetDataFactory.validPet());

        given().
            spec(DefaultRequestParams.headerParams()).
            pathParam("id", pet.getBody().path("id").toString()).
        when().
            delete("/pet/{id}").
        then().
            statusCode(200).
            body("message", equalTo(pet.getBody().path("id").toString()));
    }

    @Test
    @Tag(PET)
    @Tag(FUNCTIONAL)
    @DisplayName("Should validate the return when the id of a non-existing pet is provided")
    void notFoundDeletePetById(){
        given().
            spec(DefaultRequestParams.headerParams()).
            pathParam("id", new Random().nextLong()).
        when().
            delete("/pet/{id}").
        then().
            statusCode(404);
    }

}
