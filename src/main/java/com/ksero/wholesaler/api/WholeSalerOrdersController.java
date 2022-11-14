package com.ksero.wholesaler.api;

import com.ksero.wholesaler.domain.service.WholeSalerOrdersService;
import com.ksero.wholesaler.mapping.WholeSalerOrdersMapper;
import com.ksero.wholesaler.resources.createResource.CreateWholeSalerOrderResource;
import com.ksero.wholesaler.resources.resource.WholeSalerOrderResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE
})
@RestController
@RequestMapping("/api/v1/wholeSalerOrders")
public class WholeSalerOrdersController {
    @Autowired
    private WholeSalerOrdersService service;

    @Autowired
    private WholeSalerOrdersMapper mapper;

    @GetMapping
    public List<WholeSalerOrderResource> getAll() {
        return mapper.modelListToResource(service.getAll());
    }

    @GetMapping("{Id}")
    public WholeSalerOrderResource getById(@PathVariable("Id") Long Id) {
        return mapper.toResource(service.getById(Id));
    }

    @PostMapping
    public WholeSalerOrderResource create(@RequestBody CreateWholeSalerOrderResource request) {
        return mapper.toResource(service.create(mapper.toModel(request)));
    }

    @PutMapping("{Id}")
    public WholeSalerOrderResource update(@PathVariable Long Id, @RequestBody CreateWholeSalerOrderResource request) {
        return mapper.toResource(service.update(Id, mapper.toModel(request)));
    }

    @DeleteMapping("{Id}")
    public ResponseEntity<?> delete(@PathVariable Long Id){
        return service.delete(Id);
    }
}
