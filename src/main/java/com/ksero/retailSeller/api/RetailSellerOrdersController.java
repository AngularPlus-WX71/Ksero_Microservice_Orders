package com.ksero.retailSeller.api;

import com.ksero.retailSeller.domain.service.RetailSellerOrderService;
import com.ksero.retailSeller.mapping.RetailSellerOrdersMapper;
import com.ksero.retailSeller.resources.createResource.CreateRetailSellerOrderResource;
import com.ksero.retailSeller.resources.resource.RetailSellerOrderResource;
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
@RequestMapping("/api/v1/retailSellerOrders")
public class RetailSellerOrdersController {

    @Autowired
    private RetailSellerOrderService service;

    @Autowired
    private RetailSellerOrdersMapper mapper;

    @GetMapping
    public List<RetailSellerOrderResource> getAll() {
        return mapper.modelListToResource(service.getAll());
    }

    @GetMapping("{Id}")
    public RetailSellerOrderResource getById(@PathVariable("Id") Long Id) {
        return mapper.toResource(service.getById(Id));
    }

    @PostMapping
    public RetailSellerOrderResource create(@RequestBody CreateRetailSellerOrderResource request) {
        return mapper.toResource(service.create(mapper.toModel(request)));
    }

    @PutMapping("{Id}")
    public RetailSellerOrderResource update(@PathVariable Long Id, @RequestBody CreateRetailSellerOrderResource request) {
        return mapper.toResource(service.update(Id, mapper.toModel(request)));
    }

    @DeleteMapping("{Id}")
    public ResponseEntity<?> delete(@PathVariable Long Id){
        return service.delete(Id);
    }
}
