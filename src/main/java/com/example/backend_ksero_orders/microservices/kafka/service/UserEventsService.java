package com.example.backend_ksero_orders.microservices.kafka.service;

import com.example.backend_ksero_orders.microservices.kafka.events.Event;
import com.example.backend_ksero_orders.microservices.kafka.events.EventType;
import com.example.backend_ksero_orders.microservices.security.events.UserDeletedEvent;
import com.example.backend_ksero_orders.microservices.wholesaler.domain.service.WholeSalerOrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserEventsService {
    @Autowired
    private WholeSalerOrdersService service;

    @KafkaListener(
            topics = "${topic.user.name:users}",
            containerFactory = "kafkaListenerContainerFactory",
            groupId = "grupo1")
    public void consumer(Event<?> event) {
        if (event.getClass().isAssignableFrom(UserDeletedEvent.class)) {
            UserDeletedEvent userDeletedEvent = (UserDeletedEvent) event;
            log.info("Received Customer deleted event .... with Id={}, data={}",
                    userDeletedEvent.getId(),
                    userDeletedEvent.getData().toString());

            if(userDeletedEvent.getType() == EventType.DELETED){
                service.deleteByUserId(userDeletedEvent.getData().getId());
            }
        }
    }
}
