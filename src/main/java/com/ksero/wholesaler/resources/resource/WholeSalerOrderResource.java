package com.ksero.wholesaler.resources.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class WholeSalerOrderResource {
    private Long id;
    private Long quantity;
    private Long productId;
    private Long retailSellerId;
    private Long wholesalerId;

}
