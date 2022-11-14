package com.ksero.wholesaler.resources.createResource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateWholeSalerOrderResource {

    private Long id;

    @NotNull
    private Long quantity;

    @NotNull
    private Long productId;

    @NotNull
    private Long retailSellerId;

    @NotNull
    private Long wholesalerId;
}
