package com.example.backend_ksero_orders.microservices.retailSeller.resources.createResource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter

public class CreateRetailSellerOrderResource {

    private Long id;

    @NotNull
    @NotBlank
    private Long quantity;
}
