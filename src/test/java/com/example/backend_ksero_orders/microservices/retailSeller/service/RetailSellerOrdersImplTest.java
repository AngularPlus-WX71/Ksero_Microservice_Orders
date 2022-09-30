package com.example.backend_ksero_orders.microservices.retailSeller.service;

import com.example.backend_ksero_orders.microservices.retailSeller.domain.model.entity.RetailSellerOrders;
import com.example.backend_ksero_orders.microservices.retailSeller.domain.persistence.RetailSellerOrdersRepository;
import com.example.backend_ksero_orders.microservices.retailSeller.domain.service.RetailSellerOrderService;
import com.example.backend_ksero_orders.shared.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import javax.validation.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RetailSellerOrdersImplTest {


    Validator validator = mock(Validator.class);

    @Mock
    RetailSellerOrdersRepository retailSellerOrdersRepository = mock(RetailSellerOrdersRepository.class);

    @InjectMocks
    RetailSellerOrderService retailSellerOrderService = new RetailSellerOrdersImpl(
            retailSellerOrdersRepository, validator);

    RetailSellerOrders generateRetailSellerOrders(Long id){
        RetailSellerOrders order = new RetailSellerOrders(id, 100L);
        return order;
    }

    @Test
    void getAllOrderstListEmpty() {
        List<RetailSellerOrders> expectedOrders = new ArrayList<>();

        when(retailSellerOrdersRepository.findAll()).thenReturn(expectedOrders);

        List<RetailSellerOrders> resultOrders = retailSellerOrderService.getAll();

        Assertions.assertEquals(expectedOrders, resultOrders);
    }

    @Test
    void getAllOrderstListWithContent() {
        List<RetailSellerOrders> expectedOrders = new ArrayList<>();
        RetailSellerOrders order1 = generateRetailSellerOrders(1L);
        RetailSellerOrders order2 = generateRetailSellerOrders(2L);
        RetailSellerOrders order3 = generateRetailSellerOrders(3L);

        expectedOrders.add(order1);
        expectedOrders.add(order2);
        expectedOrders.add(order3);

        when(retailSellerOrdersRepository.findAll()).thenReturn(expectedOrders);

        List<RetailSellerOrders> resultOrders = retailSellerOrderService.getAll();

        Assertions.assertEquals(expectedOrders, resultOrders);
    }

    @Test
    void getById() {
        RetailSellerOrders expectedOrders = generateRetailSellerOrders(1L);

        when(retailSellerOrdersRepository.findById(1L)).thenReturn(Optional.ofNullable(expectedOrders));

        RetailSellerOrders resultProduct = retailSellerOrderService.getById(1L);

        Assertions.assertEquals(expectedOrders, resultProduct);
    }

    @Test
    void getByIdWhenOrderNotExist() {
        RetailSellerOrders expectedOrder = generateRetailSellerOrders(1L);

        when(retailSellerOrdersRepository.findById(1L)).thenReturn(Optional.ofNullable(null));

        Assertions.assertThrows(ResourceNotFoundException.class, ()->{
            retailSellerOrderService.getById(1L);
        });
    }

    @Test
    void create() {

        RetailSellerOrders expectedOrder = generateRetailSellerOrders(1L);

        when(retailSellerOrdersRepository.save(expectedOrder)).thenReturn(expectedOrder);

        RetailSellerOrders resultOrder = retailSellerOrderService.create(expectedOrder);

        Assertions.assertEquals(expectedOrder, resultOrder);

    }

    @Test
    void updateIfOrderExist() {

        RetailSellerOrders expectedOrder = generateRetailSellerOrders(1L);

        when(retailSellerOrdersRepository.save(expectedOrder)).thenReturn(expectedOrder);
        when(retailSellerOrdersRepository.findById(1L)).thenReturn(Optional.of(expectedOrder));
        when(retailSellerOrdersRepository.existsById(1L)).thenReturn(true);

        RetailSellerOrders resultOrder = retailSellerOrderService.update(1L ,expectedOrder);

        Assertions.assertEquals(expectedOrder, resultOrder);

    }

   @Test
    void updateIfOrderNotExist() {

       RetailSellerOrders expectedOrder = generateRetailSellerOrders(1L);

       when(retailSellerOrdersRepository.save(expectedOrder)).thenReturn(expectedOrder);
       when(retailSellerOrdersRepository.findById(1L)).thenReturn(Optional.ofNullable(null));
       when(retailSellerOrdersRepository.existsById(1L)).thenReturn(false);

        Assertions.assertThrows(ResourceNotFoundException.class, ()->{
            retailSellerOrderService.update(1L ,expectedOrder);
        });
    }
}