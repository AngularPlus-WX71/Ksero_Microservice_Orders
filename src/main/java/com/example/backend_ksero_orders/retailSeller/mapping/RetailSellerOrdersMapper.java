package com.example.backend_ksero_orders.retailSeller.mapping;

import com.example.backend_ksero_orders.retailSeller.domain.model.entity.RetailSellerOrders;
import com.example.backend_ksero_orders.retailSeller.resources.createResource.CreateRetailSellerOrderResource;
import com.example.backend_ksero_orders.retailSeller.resources.resource.RetailSellerOrderResource;
import com.example.backend_ksero_orders.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class RetailSellerOrdersMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public RetailSellerOrderResource toResource(RetailSellerOrders model) {
        return mapper.map(model, RetailSellerOrderResource.class);
    }

    public RetailSellerOrders toModel(CreateRetailSellerOrderResource resource) {
        return mapper.map(resource, RetailSellerOrders.class);
    }

    public List<RetailSellerOrderResource> modelListToResource(List<RetailSellerOrders> modelList) {
        return mapper.mapList(modelList, RetailSellerOrderResource.class);
    }
}