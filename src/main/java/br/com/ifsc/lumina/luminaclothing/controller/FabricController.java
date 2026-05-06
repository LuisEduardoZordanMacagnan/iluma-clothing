package br.com.ifsc.lumina.luminaclothing.controller;

import br.com.ifsc.lumina.luminaclothing.model.Fabric;
import br.com.ifsc.lumina.luminaclothing.service.FabricService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fabrics")
public class FabricController {

    private final FabricService service;

    public FabricController(FabricService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fabric create(@RequestBody Fabric model) {
        return service.create(model);
    }

    @GetMapping
    public List<Fabric> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Fabric getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Fabric update(@PathVariable String id, @RequestBody Fabric model) {
        return service.update(id, model);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
