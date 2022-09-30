package com.example.backend_ksero_orders.microservices.retailSeller.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("RetailSellerConfiguration")
public class MappingConfiguration {
    @Bean
    public RetailSellerOrdersMapper retailSellerOrdersMapper() {return new RetailSellerOrdersMapper();}
}
