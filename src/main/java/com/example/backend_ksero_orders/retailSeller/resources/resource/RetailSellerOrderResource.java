package com.example.backend_ksero_orders.retailSeller.resources.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RetailSellerOrderResource {
    private Long id;
    private Long quantity;
}
