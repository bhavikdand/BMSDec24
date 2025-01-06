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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getColNum() {
        return colNum;
    }

    public void setColNum(int colNum) {
        this.colNum = colNum;
    }
}
