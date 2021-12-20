package com.usa.ciclo4.reto5ciclo4.controller;

import com.usa.ciclo4.reto5ciclo4.model.Supplements;
import com.usa.ciclo4.reto5ciclo4.service.SupplementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clone")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class SupplementsController {
    @Autowired
    private SupplementsService supplementService;

    @GetMapping("/all")
    public List<Supplements> getAll() {
        return supplementService.getAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Supplements supplement){
        supplementService.save(supplement);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Supplements update(@RequestBody Supplements supplement) {
        return supplementService.update(supplement);
    }
    @GetMapping("/{id}")
    public Optional<Supplements> getSupplements(@PathVariable("id") int id){
        return supplementService.getSupplements(id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return supplementService.delete(id);
    }

    @GetMapping("/price/{price}")
    public List<Supplements>  getByPrice(@PathVariable("price") double price){
        return supplementService.getByPrice(price);
    }

    @GetMapping("/description/{description}")
    public List<Supplements> getByDescriptionContains(@PathVariable("description") String description){
        return supplementService.getByDescriptionContains(description);
    }

}