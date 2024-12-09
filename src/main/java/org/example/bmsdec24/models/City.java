package org.example.bmsdec24.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;



@Entity
public class City extends BaseModel{
    private String name;
    @OneToMany
    private List<Theatre> theatres;
}
