package com.usa.ciclo4.reto5ciclo4.repository;

import com.usa.ciclo4.reto5ciclo4.model.Supplements;
import com.usa.ciclo4.reto5ciclo4.repository.crud.SupplementsCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SupplementsRepository {
    @Autowired
    private SupplementsCrudRepository supplementsCrudRepository;

    public List<Supplements> getAll(){
        return supplementsCrudRepository.findAll();
    }

    public Optional<Supplements> getSupplements(int id){
        return supplementsCrudRepository.findById(id);
    }

    public Supplements save(Supplements supplement){
        return supplementsCrudRepository.save(supplement);
    }

    public void update(Supplements supplement){
        supplementsCrudRepository.save(supplement);
    }

    public void delete(Supplements supplement){
        supplementsCrudRepository.delete(supplement);
    }

    public List<Supplements> getByPrice(double price){
        return supplementsCrudRepository.findByPrice(price);
    }

    public List<Supplements> getByDescriptionContains(String description){
        return supplementsCrudRepository.findByDescriptionContainingIgnoreCase(description);
    }
}