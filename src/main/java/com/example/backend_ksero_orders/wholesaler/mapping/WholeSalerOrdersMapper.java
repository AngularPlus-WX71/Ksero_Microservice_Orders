package com.example.backend_ksero_orders.wholesaler.mapping;

import com.example.backend_ksero_orders.shared.mapping.EnhancedModelMapper;
import com.example.backend_ksero_orders.wholesaler.domain.model.entity.WholeSalerOrders;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class WholeSalerOrdersMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public WholeSalerOrderResource toResource(WholeSalerOrders model) {
        return mapper.map(model, WholeSalerOrderResource.class);
    }

    public WholeSalerOrders toModel(CreateWholeSalerOrderResource resource) {
        return mapper.map(resource, WholeSalerOrders.class);
    }

    public List<WholeSalerOrderResource> modelListToResource(List<WholeSalerOrders> modelList) {
        return mapper.mapList(modelList, WholeSalerOrderResource.class);
    }
}
