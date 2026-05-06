package br.com.ifsc.lumina.luminaclothing.repository;

import br.com.ifsc.lumina.luminaclothing.model.Fabric;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricRepository extends MongoRepository<Fabric, String> {
}
