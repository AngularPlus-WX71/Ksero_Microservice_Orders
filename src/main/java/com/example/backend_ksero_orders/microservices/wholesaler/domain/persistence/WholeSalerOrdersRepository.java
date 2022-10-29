package com.example.backend_ksero_orders.microservices.wholesaler.domain.persistence;

import com.example.backend_ksero_orders.microservices.wholesaler.domain.model.entity.WholeSalerOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WholeSalerOrdersRepository extends JpaRepository<WholeSalerOrders, Long> {
    List<WholeSalerOrders> findByUserId(Long userId);
}
