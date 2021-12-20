package com.usa.ciclo4.reto5ciclo4.repository.crud;

import com.usa.ciclo4.reto5ciclo4.model.Supplements;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SupplementsCrudRepository extends MongoRepository<Supplements, Integer> {
    public List<Supplements> findByPrice (double price);
    public List<Supplements> findByDescriptionContainingIgnoreCase(String description);
}