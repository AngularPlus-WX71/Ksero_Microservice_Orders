package com.ksero.wholesaler.domain.persistence;

import com.ksero.retailSeller.domain.model.entity.RetailSellerOrders;
import com.ksero.wholesaler.domain.model.entity.WholeSalerOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WholeSalerOrdersRepository extends JpaRepository<WholeSalerOrders, Long> {
    List<WholeSalerOrders> findByRetailSellerId(Long userId);
    List<WholeSalerOrders> findByWholesalerId(Long userId);
}
