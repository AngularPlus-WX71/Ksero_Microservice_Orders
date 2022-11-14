package com.ksero.retailSeller.service;

import com.ksero.retailSeller.domain.persistence.RetailSellerOrdersRepository;
import com.ksero.retailSeller.domain.service.RetailSellerOrderService;
import com.ksero.retailSeller.domain.model.entity.RetailSellerOrders;
import com.ksero.shared.exception.ResourceNotFoundException;
import com.ksero.shared.exception.ResourceValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class RetailSellerOrdersImpl implements RetailSellerOrderService {

    private static final String ENTITY = "retailSellerOrders";
    private final RetailSellerOrdersRepository repository;
    private final Validator validator;

    public RetailSellerOrdersImpl(RetailSellerOrdersRepository repository, Validator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    public List<RetailSellerOrders> getAll() {
        return repository.findAll();
    }

    @Override
    public RetailSellerOrders getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public RetailSellerOrders create(RetailSellerOrders request) {
        Set<ConstraintViolation<RetailSellerOrders>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return repository.save(request);
    }

    @Override
    public RetailSellerOrders update(Long id, RetailSellerOrders request) {
        Set<ConstraintViolation<RetailSellerOrders>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        if (!repository.existsById(id))
            throw new ResourceNotFoundException(ENTITY, id);

        return repository.findById(id).map(
                order -> repository.save(order
                        .withQuantity(request.getQuantity())
                )).orElseThrow(
                () -> new ResourceNotFoundException(ENTITY, id)
        );
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return repository.findById(id).map(
                        retailSellerOrders -> {
                            repository.delete(retailSellerOrders);
                            return ResponseEntity.ok().build();
                        })
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public ResponseEntity<?> deleteByRetailSellerId(Long userId) {

        if (repository.findByRetailSellerId(userId).isEmpty())
            return ResponseEntity.ok().build();

        repository.findByRetailSellerId(userId).forEach(order -> repository.delete(order));

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> deleteByWholesalerId(Long userId) {
        if (repository.findByWholesalerId(userId).isEmpty())
            return ResponseEntity.ok().build();

        repository.findByWholesalerId(userId).forEach(order -> repository.delete(order));

        return ResponseEntity.ok().build();
    }
}
