package com.example.backend_ksero_orders.microservices.wholesaler.domain.model.entity;

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
@Table(name = "wholesalerOrders")
public class WholeSalerOrders extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long quantity;

    @NotNull
    private Long userId;
}
