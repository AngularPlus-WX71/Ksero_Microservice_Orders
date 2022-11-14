package com.ksero.wholesaler.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("WholesalerConfiguration")
public class MappingConfiguration {
    @Bean
    public WholeSalerOrdersMapper wholesalerOrdersMapper(){return new WholeSalerOrdersMapper();}
}
