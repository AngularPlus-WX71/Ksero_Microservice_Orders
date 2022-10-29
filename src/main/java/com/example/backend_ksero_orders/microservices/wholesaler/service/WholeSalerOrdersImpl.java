package com.example.backend_ksero_orders.microservices.wholesaler.service;

import com.example.backend_ksero_orders.microservices.wholesaler.domain.model.entity.WholeSalerOrders;
import com.example.backend_ksero_orders.microservices.wholesaler.domain.persistence.WholeSalerOrdersRepository;
import com.example.backend_ksero_orders.microservices.wholesaler.domain.service.WholeSalerOrdersService;
import com.example.backend_ksero_orders.shared.exception.ResourceNotFoundException;
import com.example.backend_ksero_orders.shared.exception.ResourceValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class WholeSalerOrdersImpl implements WholeSalerOrdersService {
    private static final String ENTITY = "wholesalerOrders";
    private final WholeSalerOrdersRepository repository;
    private final Validator validator;

    public WholeSalerOrdersImpl(WholeSalerOrdersRepository repository, Validator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    public List<WholeSalerOrders> getAll() {
        return repository.findAll();
    }

    @Override
    public WholeSalerOrders getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public WholeSalerOrders create(WholeSalerOrders request) {
        Set<ConstraintViolation<WholeSalerOrders>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return repository.save(request);
    }

    @Override
    public WholeSalerOrders update(Long id, WholeSalerOrders request) {
        Set<ConstraintViolation<WholeSalerOrders>> violations = validator.validate(request);

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
                        product -> {
                            repository.delete(product);
                            return ResponseEntity.ok().build();
                        })
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public ResponseEntity<?> deleteByUserId(Long userId) {

        if (repository.findByUserId(userId).isEmpty())
            return ResponseEntity.ok().build();

        repository.findByUserId(userId).forEach(product -> repository.delete(product));

        return ResponseEntity.ok().build();
    }
}
