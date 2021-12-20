package com.usa.ciclo4.reto5ciclo4.service;


import com.usa.ciclo4.reto5ciclo4.model.Supplements;
import com.usa.ciclo4.reto5ciclo4.repository.SupplementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplementsService {
    @Autowired
    private SupplementsRepository supplementsRepository;

    public List<Supplements> getAll() {
        return supplementsRepository.getAll();
    }

    public Optional<Supplements> getSupplements(int id) {
        return supplementsRepository.getSupplements( id);
    }

  public Supplements save (Supplements accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return supplementsRepository.save(accesory);
        }
    }
    public Supplements update(Supplements supplement) {

        if (supplement.getReference() != null) {
            Optional<Supplements> supplementDb = supplementsRepository.getSupplements(supplement.getId());
            if (!supplementDb.isEmpty()) {

                if (supplement.getBrand()!= null) {
                    supplementDb.get().setBrand(supplement.getBrand());
                }

                if (supplement.getCategory() != null) {
                    supplementDb.get().setCategory(supplement.getCategory());
                }

                if (supplement.getDescription() != null) {
                    supplementDb.get().setDescription(supplement.getDescription());
                }
                if (supplement.getPrice() != 0.0) {
                    supplementDb.get().setPrice(supplement.getPrice());
                }
                if (supplement.getQuantity() != 0) {
                    supplementDb.get().setQuantity(supplement.getQuantity());
                }
                if (supplement.getPhotography() != null) {
                    supplementDb.get().setPhotography(supplement.getPhotography());
                }
                supplementDb.get().setAvailability(supplement.isAvailability());

                if (supplement.getPrice()!= 0.0){
                    supplementDb.get().setPrice(supplement.getPrice());
                }
                if (supplement.getQuantity()!= 0){
                    supplementDb.get().setQuantity(supplement.getQuantity());
                }
                if (supplement.getPhotography()!= null){
                    supplementDb.get().setPhotography(supplement.getPhotography());
                }
                supplementsRepository.update(supplementDb.get());
                return supplementDb.get();
            } else {
                return supplement;
            }
        } else {
            return supplement;
        }
    }

    public boolean delete(int id){
        return getSupplements(id).map(supplement -> {
            supplementsRepository.delete(supplement);
            return true;
        }).orElse(false);
    }

    public List<Supplements> getByPrice(double price){
        return supplementsRepository.getByPrice(price);
    }

    public List<Supplements> getByDescriptionContains(String description){
        return supplementsRepository.getByDescriptionContains(description);
    }
}
