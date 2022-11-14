package com.ksero.retailSeller.domain.persistence;

import com.ksero.retailSeller.domain.model.entity.RetailSellerOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RetailSellerOrdersRepository extends JpaRepository<RetailSellerOrders, Long> {
    List<RetailSellerOrders> findByRetailSellerId(Long userId);
    List<RetailSellerOrders> findByWholesalerId(Long userId);
}
