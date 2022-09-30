package com.example.backend_ksero_orders.wholesaler.domain.service;

import com.example.backend_ksero_orders.wholesaler.domain.model.entity.WholeSalerOrders;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WholeSalerOrdersService {
    List<WholeSalerOrders> getAll();
    WholeSalerOrders getById(Long id);
    WholeSalerOrders create(WholeSalerOrders request);
    WholeSalerOrders update(Long id, WholeSalerOrders request);
    ResponseEntity<?> delete(Long id);
}
