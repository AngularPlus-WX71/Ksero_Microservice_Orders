package com.example.backend_ksero_orders.retailSeller.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("Configuration")
public class MappingConfiguration {
    @Bean
    public RetailSellerOrdersMapper retailSellerOrdersMapper(){return new RetailSellerOrdersMapper();}
}
