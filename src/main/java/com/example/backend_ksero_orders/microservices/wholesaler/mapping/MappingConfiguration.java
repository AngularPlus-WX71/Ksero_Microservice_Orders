package com.example.backend_ksero_orders.microservices.wholesaler.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("WholesalerConfiguration")
public class MappingConfiguration {
    @Bean
    public WholeSalerOrdersMapper wholesalerOrdersMapper(){return new WholeSalerOrdersMapper();}
}
