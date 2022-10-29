package com.example.backend_ksero_orders.microservices.kafka.service;

import com.example.backend_ksero_orders.microservices.kafka.events.Event;
import com.example.backend_ksero_orders.microservices.kafka.events.EventType;
import com.example.backend_ksero_orders.microservices.retailSeller.domain.model.entity.RetailSellerOrders;
import com.example.backend_ksero_orders.microservices.retailSeller.domain.service.RetailSellerOrderService;
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
    private WholeSalerOrdersService wholeSalerOrdersService;
    private RetailSellerOrderService retailSellerOrderService;

    @KafkaListener(
            topics = "${topic.user.name:users}",
            containerFactory = "kafkaListenerContainerFactory",
            groupId = "grupo2")
    public void consumer(Event<?> event) {
        if (event.getClass().isAssignableFrom(UserDeletedEvent.class)) {
            UserDeletedEvent userDeletedEvent = (UserDeletedEvent) event;
            log.info("Received Customer deleted event .... with Id={}, data={}",
                    userDeletedEvent.getId(),
                    userDeletedEvent.getData().toString());

            if(userDeletedEvent.getType() == EventType.DELETED){
                wholeSalerOrdersService.deleteByUserId(userDeletedEvent.getData().getId());
                //retailSellerOrderService.deleteByUserId(userDeletedEvent.getData().getId());
                //TODO: Se debe colocar una condicional que llame al servicio correspondiente segun el rol del usuario
            }
        }
    }
}
