package org.example.bmsdec24.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
public class Screen extends BaseModel{
    private String name;
    @OneToMany
    private List<Seat> seats;
    @Enumerated(value = EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}
