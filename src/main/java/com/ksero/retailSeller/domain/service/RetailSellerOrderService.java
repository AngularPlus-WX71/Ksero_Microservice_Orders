package com.ksero.retailSeller.domain.service;

import com.ksero.retailSeller.domain.model.entity.RetailSellerOrders;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RetailSellerOrderService {
    List<RetailSellerOrders> getAll();

    RetailSellerOrders getById(Long id);

    RetailSellerOrders create(RetailSellerOrders request);

    RetailSellerOrders update(Long id, RetailSellerOrders request);

    ResponseEntity<?> delete(Long id);

    ResponseEntity<?> deleteByRetailSellerId(Long userId);

    ResponseEntity<?> deleteByWholesalerId(Long userId);
}
