package com.usa.ciclo4.reto5ciclo4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "supplements")
public class Supplements {

    @Id
    private String reference;
    private String brand;
    private String category;
    private String objetivo;
    private String description;
    private boolean availability = true;
    private double price;
    private int quantity;
    private String photography;
    private int id;

}
