package com.example.backend_ksero_orders.microservices.retailSeller.domain.model.entity;

import com.example.backend_ksero_orders.shared.exception.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "retailSellerOrders")

public class RetailSellerOrders extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long quantity;
}
