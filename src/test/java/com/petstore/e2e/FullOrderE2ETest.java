package com.petstore.e2e;

import com.petstore.BaseAPI;
import com.petstore.client.OrderClient;
import com.petstore.client.PetClient;
import com.petstore.factory.OrderDataFactory;
import com.petstore.factory.PetDataFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.petstore.utils.TestTags.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class FullOrderE2ETest extends BaseAPI {

    @Test
    @Tag(ORDER)
    @Tag(E2E)
    @DisplayName("It should validate the behavior of the order flow with a registered Pet.")
    void orderE2EWithPetAndStatusPlaced() {
        var pet = new PetClient().createPetSuccessfullyFromApi(PetDataFactory.validPet());
        assertThat(pet.getStatusCode(), equalTo(200));


        var order = new OrderClient().createOrderSuccessfullyFromApi(OrderDataFactory.validOrderWithPet(pet.getBody().path("id")));
        assertThat(order.getBody().path("petId"), equalTo(pet.getBody().path("id")));
    }
}
