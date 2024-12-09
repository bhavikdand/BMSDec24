package org.example.bmsdec24.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;


@Entity
public class Seat extends BaseModel{

    private String name;
    @Enumerated(value = EnumType.ORDINAL)
    private SeatType seatType;
    private int rowNum;
    private int colNum;
}
