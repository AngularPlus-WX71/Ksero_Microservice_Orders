package com.example.backend_ksero_orders.microservices.wholesaler.mapping;

import com.example.backend_ksero_orders.microservices.wholesaler.domain.model.entity.WholeSalerOrders;
import com.example.backend_ksero_orders.microservices.wholesaler.resources.createResource.CreateWholeSalerOrderResource;
import com.example.backend_ksero_orders.microservices.wholesaler.resources.resource.WholeSalerOrderResource;
import com.example.backend_ksero_orders.shared.mapping.EnhancedModelMapper;
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