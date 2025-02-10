package com.petstore.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    private Integer id;
    Category category;
    private String name;
    ArrayList<String> photoUrls = new ArrayList<>();
    ArrayList<Tags> tags = new ArrayList<>();
    private String status;

}
