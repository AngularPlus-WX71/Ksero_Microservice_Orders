package com.example.backend_ksero_orders.wholesaler.domain.persistence;

import com.example.backend_ksero_orders.wholesaler.domain.model.entity.WholeSalerOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WholeSalerOrdersRepository extends JpaRepository<WholeSalerOrders, Long> {
}
