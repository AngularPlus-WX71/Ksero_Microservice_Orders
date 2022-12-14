package com.ksero.kafka.events;

import com.ksero.kafka.entity.RetailsellerDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RetailSellerDeletedEvent extends Event<RetailsellerDto> {
}
