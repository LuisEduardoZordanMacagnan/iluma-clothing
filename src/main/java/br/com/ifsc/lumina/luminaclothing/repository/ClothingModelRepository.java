package br.com.ifsc.lumina.luminaclothing.repository;

import br.com.ifsc.lumina.luminaclothing.model.ClothingModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothingModelRepository extends MongoRepository<ClothingModel, String> {
}
