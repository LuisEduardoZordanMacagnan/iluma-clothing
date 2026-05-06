package br.com.ifsc.lumina.luminaclothing.service;

import br.com.ifsc.lumina.luminaclothing.model.Fabric;
import br.com.ifsc.lumina.luminaclothing.repository.FabricRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FabricService {

    private final FabricRepository repository;

    public FabricService(FabricRepository repository) {
        this.repository = repository;
    }

    public Fabric create(Fabric model) {
        return repository.save(model);
    }

    public List<Fabric> findAll() {
        return repository.findAll();
    }

    public Fabric findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tecido não encontrado"));
    }

    public Fabric update(String id, Fabric updatedModel) {
        Fabric existingModel = findById(id);

        existingModel.setName(updatedModel.getName());

        return repository.save(existingModel);
    }

    public void delete(String id) {
        Fabric existingModel = findById(id);
        repository.delete(existingModel);
    }
}
