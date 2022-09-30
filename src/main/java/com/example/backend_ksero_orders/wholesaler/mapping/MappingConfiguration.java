package com.example.backend_ksero_orders.wholesaler.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("Configuration")
public class MappingConfiguration {
    @Bean
    public WholeSalerOrdersMapper retailSellerOrdersMapper(){return new WholeSalerOrdersMapper();}
}
