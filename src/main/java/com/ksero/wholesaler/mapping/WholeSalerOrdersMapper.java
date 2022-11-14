package com.ksero.wholesaler.mapping;

import com.ksero.wholesaler.domain.model.entity.WholeSalerOrders;
import com.ksero.wholesaler.resources.createResource.CreateWholeSalerOrderResource;
import com.ksero.wholesaler.resources.resource.WholeSalerOrderResource;
import com.ksero.shared.mapping.EnhancedModelMapper;
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
