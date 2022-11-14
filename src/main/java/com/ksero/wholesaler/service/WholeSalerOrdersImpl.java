package com.ksero.wholesaler.service;

import com.ksero.wholesaler.domain.model.entity.WholeSalerOrders;
import com.ksero.wholesaler.domain.persistence.WholeSalerOrdersRepository;
import com.ksero.wholesaler.domain.service.WholeSalerOrdersService;
import com.ksero.shared.exception.ResourceNotFoundException;
import com.ksero.shared.exception.ResourceValidationException;
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
