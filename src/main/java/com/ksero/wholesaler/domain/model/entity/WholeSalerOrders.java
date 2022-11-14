package com.ksero.wholesaler.domain.model.entity;

import com.ksero.shared.exception.model.AuditModel;
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
    private Long productId;

    @NotNull
    private Long retailSellerId;

    @NotNull
    private Long wholesalerId;
}
