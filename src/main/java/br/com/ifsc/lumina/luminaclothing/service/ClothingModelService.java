package br.com.ifsc.lumina.luminaclothing.service;

import br.com.ifsc.lumina.luminaclothing.model.ClothingModel;
import br.com.ifsc.lumina.luminaclothing.repository.ClothingModelRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClothingModelService {

    private final ClothingModelRepository repository;

    public ClothingModelService(ClothingModelRepository repository) {
        this.repository = repository;
    }

    public ClothingModel create(ClothingModel model) {
        return repository.save(model);
    }

    public List<ClothingModel> findAll() {
        return repository.findAll();
    }

    public ClothingModel findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Modelo não encontrado"));
    }

    public ClothingModel update(String id, ClothingModel updatedModel) {
        ClothingModel existingModel = findById(id);

        existingModel.setName(updatedModel.getName());
        existingModel.setDescription(updatedModel.getDescription());
        existingModel.setFabricType(updatedModel.getFabricType());
        existingModel.setPoints(updatedModel.getPoints());

        return repository.save(existingModel);
    }

    public void delete(String id) {
        ClothingModel existingModel = findById(id);
        repository.delete(existingModel);
    }

    public ClothingModel duplicate(String id) {
        ClothingModel original = findById(id);

        ClothingModel copy = new ClothingModel();
        // Deixa o ID nulo para que o MongoDB gere um novo ao salvar
        copy.setId(null);
        copy.setName(original.getName() + " - Cópia");
        copy.setDescription(original.getDescription());
        copy.setFabricType(original.getFabricType());

        // Evita referências de memória mutáveis copiando a lista de pontos
        if (original.getPoints() != null) {
            copy.setPoints(new ArrayList<>(original.getPoints()));
        }

        return repository.save(copy);
    }
}
