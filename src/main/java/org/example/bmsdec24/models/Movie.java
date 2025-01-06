package org.example.bmsdec24.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "movies")
public class Movie extends BaseModel{
    private String name;
    private Genre genre;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
