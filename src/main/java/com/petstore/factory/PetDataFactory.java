package com.petstore.factory;

import com.petstore.model.pet.Category;
import com.petstore.model.pet.Pet;
import com.petstore.model.pet.Tags;
import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class PetDataFactory {

    private static final Faker faker = new Faker();

    public static Pet validPet(){
        return newPet();
    }

    private static Pet newPet() {
        var category =
                Category.
                    builder().
                        id(new Random().nextInt(10)).
                        name(faker.animal().species()).
                    build();

        var tags =
                Tags.
                    builder().
                        id(new Random().nextInt(10)).
                        name(faker.animal().scientificName()).
                    build();

        return
                Pet.
                    builder().
                        id(new Random().nextInt(100)).
                        category(category).
                        name(faker.animal().name()).
                        photoUrls(new ArrayList<>(List.of(""))).
                        tags(new ArrayList<>(List.of(tags))).
                        status("available").
                    build();
    }
}
