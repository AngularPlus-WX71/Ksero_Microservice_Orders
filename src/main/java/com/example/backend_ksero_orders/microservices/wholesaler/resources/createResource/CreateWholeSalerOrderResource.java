package com.example.backend_ksero_orders.microservices.wholesaler.resources.createResource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateWholeSalerOrderResource {

    @NotNull
    private Long quantity;
}
