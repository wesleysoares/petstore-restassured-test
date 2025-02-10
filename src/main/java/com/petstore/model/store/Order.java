package com.petstore.model.store;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Integer id;
    private Integer petId;
    private Integer quantity;
    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime shipDate;
    private StatusOrder status;
    private Boolean complete;
}
