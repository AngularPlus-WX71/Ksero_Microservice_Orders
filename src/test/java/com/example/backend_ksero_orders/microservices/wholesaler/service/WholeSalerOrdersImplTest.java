package com.example.backend_ksero_orders.microservices.wholesaler.service;

import com.example.backend_ksero_orders.microservices.wholesaler.domain.model.entity.WholeSalerOrders;
import com.example.backend_ksero_orders.microservices.wholesaler.domain.persistence.WholeSalerOrdersRepository;
import com.example.backend_ksero_orders.microservices.wholesaler.domain.service.WholeSalerOrdersService;
import com.example.backend_ksero_orders.shared.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import javax.validation.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WholeSalerOrdersImplTest {

    Validator validator = mock(Validator.class);

    @Mock
    WholeSalerOrdersRepository wholeSalerOrdersRepository = mock(WholeSalerOrdersRepository.class);

    @InjectMocks
    WholeSalerOrdersService wholeSalerOrdersService = new WholeSalerOrdersImpl(
            wholeSalerOrdersRepository, validator);

    WholeSalerOrders generateWholesalerOrders(Long id){
        WholeSalerOrders order = new WholeSalerOrders(id, 100L);
        return order;
    }

    @Test
    void getAllOrderstListEmpty() {
        List<WholeSalerOrders> expectedOrders = new ArrayList<>();

        when(wholeSalerOrdersRepository.findAll()).thenReturn(expectedOrders);

        List<WholeSalerOrders> resultOrders = wholeSalerOrdersService.getAll();

        Assertions.assertEquals(expectedOrders, resultOrders);
    }

    @Test
    void getAllOrderstListWithContent() {
        List<WholeSalerOrders> expectedOrders = new ArrayList<>();
        WholeSalerOrders order1 = generateWholesalerOrders(1L);
        WholeSalerOrders order2 = generateWholesalerOrders(2L);
        WholeSalerOrders order3 = generateWholesalerOrders(3L);

        expectedOrders.add(order1);
        expectedOrders.add(order2);
        expectedOrders.add(order3);

        when(wholeSalerOrdersRepository.findAll()).thenReturn(expectedOrders);

        List<WholeSalerOrders> resultOrders = wholeSalerOrdersService.getAll();

        Assertions.assertEquals(expectedOrders, resultOrders);
    }

    @Test
    void getById() {
        WholeSalerOrders expectedOrders = generateWholesalerOrders(1L);

        when(wholeSalerOrdersRepository.findById(1L)).thenReturn(Optional.ofNullable(expectedOrders));

        WholeSalerOrders resultProduct = wholeSalerOrdersService.getById(1L);

        Assertions.assertEquals(expectedOrders, resultProduct);
    }

    @Test
    void getByIdWhenOrderNotExist() {
        WholeSalerOrders expectedOrder = generateWholesalerOrders(1L);

        when(wholeSalerOrdersRepository.findById(1L)).thenReturn(Optional.ofNullable(null));

        Assertions.assertThrows(ResourceNotFoundException.class, ()->{
            wholeSalerOrdersService.getById(1L);
        });
    }

    @Test
    void create() {

        WholeSalerOrders expectedOrder = generateWholesalerOrders(1L);

        when(wholeSalerOrdersRepository.save(expectedOrder)).thenReturn(expectedOrder);

        WholeSalerOrders resultOrder = wholeSalerOrdersService.create(expectedOrder);

        Assertions.assertEquals(expectedOrder, resultOrder);

    }

    @Test
    void updateIfOrderExist() {

        WholeSalerOrders expectedOrder = generateWholesalerOrders(1L);

        when(wholeSalerOrdersRepository.save(expectedOrder)).thenReturn(expectedOrder);
        when(wholeSalerOrdersRepository.findById(1L)).thenReturn(Optional.of(expectedOrder));
        when(wholeSalerOrdersRepository.existsById(1L)).thenReturn(true);

        WholeSalerOrders resultOrder = wholeSalerOrdersService.update(1L ,expectedOrder);

        Assertions.assertEquals(expectedOrder, resultOrder);

    }

    @Test
    void updateIfOrderNotExist() {

        WholeSalerOrders expectedOrder = generateWholesalerOrders(1L);

        when(wholeSalerOrdersRepository.save(expectedOrder)).thenReturn(expectedOrder);
        when(wholeSalerOrdersRepository.findById(1L)).thenReturn(Optional.ofNullable(null));
        when(wholeSalerOrdersRepository.existsById(1L)).thenReturn(false);

        Assertions.assertThrows(ResourceNotFoundException.class, ()->{
            wholeSalerOrdersService.update(1L ,expectedOrder);
        });
    }
}