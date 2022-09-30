package com.example.backend_ksero_orders.microservices.retailSeller.domain.persistence;

import com.example.backend_ksero_orders.microservices.retailSeller.domain.model.entity.RetailSellerOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetailSellerOrdersRepository extends JpaRepository<RetailSellerOrders, Long> {

}
