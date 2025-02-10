package com.petstore.factory;

import com.petstore.model.Category;
import com.petstore.model.Pet;
import com.petstore.model.Tags;
import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public final class PetDataFactory {

    private static final Faker faker = new Faker();

    public static Pet validPet(){
        return newPet();
    }

    private static Pet newPet() {
        var category =
                Category.
                    builder().
                        id(1).
                        name(faker.animal().species()).
                    build();

        var tags =
                Tags.
                    builder().
                        id(1).
                        name(faker.animal().scientificName()).
                    build();

        return
                Pet.
                    builder().
                        id(1).
                        category(category).
                        name(faker.animal().name()).
                        photoUrls(new ArrayList<>(List.of(""))).
                        tags(new ArrayList<>(List.of(tags))).
                        status("available").
                    build();
    }
}
