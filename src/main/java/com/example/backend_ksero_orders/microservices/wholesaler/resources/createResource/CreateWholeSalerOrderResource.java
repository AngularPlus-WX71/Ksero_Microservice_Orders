package com.example.backend_ksero_orders.microservices.wholesaler.resources.createResource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateWholeSalerOrderResource {

    @NotNull
    private Long quantity;

    @NotNull
    private Long userId;
}
