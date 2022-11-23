package com.ksero.kafka.service;

import com.ksero.kafka.events.Event;
import com.ksero.kafka.events.EventType;
import com.ksero.kafka.events.WholesalerDeletedEvent;
import com.ksero.retailSeller.domain.service.RetailSellerOrderService;
import com.ksero.kafka.events.RetailSellerDeletedEvent;
import com.ksero.wholesaler.domain.service.WholeSalerOrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RetailsellerEventsService {
    @Autowired
    private RetailSellerOrderService retailSellerOrderService;

    @Autowired
    private WholeSalerOrdersService wholeSalerOrdersService;

    @KafkaListener(
            topics = "${topic.user.name:retailsellers}",
            containerFactory = "kafkaListenerContainerFactory",
            groupId = "retailSellerOrders")
    public void retailSellerEvent(Event<?> event) {

        if (event.getClass().isAssignableFrom(RetailSellerDeletedEvent.class)) {
            RetailSellerDeletedEvent retailsellerDeletedEvent = (RetailSellerDeletedEvent) event;
            log.info("Received RetailSeller deleted event .... with Id={}, data={}",
                    retailsellerDeletedEvent.getId(),
                    retailsellerDeletedEvent.getData().toString());

            if(retailsellerDeletedEvent.getType() == EventType.DELETED){
                retailSellerOrderService.deleteByRetailSellerId(retailsellerDeletedEvent.getData().getId());
                wholeSalerOrdersService.deleteByRetailSellerId(retailsellerDeletedEvent.getData().getId());
            }
        }
    }

    @KafkaListener(
            topics = "${topic.user.name:wholesalers}",
            containerFactory = "kafkaListenerContainerFactory",
            groupId = "wholesalerOrders")
    public void wholesalerEvent(Event<?> event) {

        if (event.getClass().isAssignableFrom(WholesalerDeletedEvent.class)) {
            WholesalerDeletedEvent wholesalerDeletedEvent = (WholesalerDeletedEvent) event;
            log.info("Received Wholesaler deleted event .... with Id={}, data={}",
                    wholesalerDeletedEvent.getId(),
                    wholesalerDeletedEvent.getData().toString());

            if(wholesalerDeletedEvent.getType() == EventType.DELETED){
                retailSellerOrderService.deleteByWholesalerId(wholesalerDeletedEvent.getData().getId());
                wholeSalerOrdersService.deleteByWholesalerId(wholesalerDeletedEvent.getData().getId());
            }
        }
    }
}
