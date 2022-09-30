package com.example.backend_ksero_orders.wholesaler.resources.createResource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateWholeSalerOrderResource {
    private Long id;

    @NotNull
    @NotBlank
    private Long quantity;
}
