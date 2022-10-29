package com.example.backend_ksero_orders.microservices.kafka.events;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
public abstract class Event<T> {
    private String id;
    private Date date;
    private EventType type;
    private T data;
}
