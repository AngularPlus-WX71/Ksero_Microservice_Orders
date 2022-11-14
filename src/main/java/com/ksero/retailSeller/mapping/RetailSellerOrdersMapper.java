package com.ksero.retailSeller.mapping;

import com.ksero.retailSeller.domain.model.entity.RetailSellerOrders;
import com.ksero.retailSeller.resources.createResource.CreateRetailSellerOrderResource;
import com.ksero.retailSeller.resources.resource.RetailSellerOrderResource;
import com.ksero.shared.mapping.EnhancedModelMapper;
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