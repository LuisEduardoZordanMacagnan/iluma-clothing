package br.com.ifsc.lumina.luminaclothing.controller;

import br.com.ifsc.lumina.luminaclothing.model.ClothingModel;
import br.com.ifsc.lumina.luminaclothing.service.ClothingModelService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
public class ClothingModelController {

    private final ClothingModelService service;

    public ClothingModelController(ClothingModelService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClothingModel create(@RequestBody ClothingModel model) {
        return service.create(model);
    }

    @GetMapping
    public List<ClothingModel> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ClothingModel getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public ClothingModel update(@PathVariable String id, @RequestBody ClothingModel model) {
        return service.update(id, model);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @PostMapping("/{id}/copy")
    @ResponseStatus(HttpStatus.CREATED)
    public ClothingModel duplicate(@PathVariable String id) {
        return service.duplicate(id);
    }
}
