package com.example.backend_ksero_orders.microservices.security.events;

import com.example.backend_ksero_orders.microservices.kafka.events.Event;
import com.example.backend_ksero_orders.microservices.security.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserDeletedEvent extends Event<User> {
}
