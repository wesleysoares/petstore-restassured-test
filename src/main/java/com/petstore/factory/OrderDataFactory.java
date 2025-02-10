package com.petstore.factory;

import com.petstore.model.store.Order;
import com.petstore.model.store.StatusOrder;

import java.time.LocalDateTime;
import java.util.Random;

public class OrderDataFactory {
    public static Order validOrderWithPet(Integer id){
        return newOrderWithPet(id);
    }

    public static Order validOrder(){
        return newOrder();
    }

    private static Order newOrder(){
        return
                Order.
                        builder().
                        id(new Random().nextInt(100)).
                        petId(new Random().nextInt(100)).
                        quantity(new Random().nextInt(10)).
                        shipDate(LocalDateTime.now()).
                        status(StatusOrder.PLACED).
                        complete(Boolean.TRUE).
                        build();
    }

    private static Order newOrderWithPet(Integer id){
        return
            Order.
                builder().
                    id(new Random().nextInt(100)).
                    petId(id).
                    quantity(new Random().nextInt(10)).
                    shipDate(LocalDateTime.now()).
                    status(StatusOrder.PLACED).
                    complete(Boolean.TRUE).
                build();
    }
}
