package com.example.backend_ksero_orders.retailSeller.domain.service;

import com.example.backend_ksero_orders.retailSeller.domain.model.entity.RetailSellerOrders;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RetailSellerOrderService {
    List<RetailSellerOrders> getAll();
    RetailSellerOrders getById(Long id);
    RetailSellerOrders create(RetailSellerOrders request);
    RetailSellerOrders update(Long id, RetailSellerOrders request);
    ResponseEntity<?> delete(Long id);
}
