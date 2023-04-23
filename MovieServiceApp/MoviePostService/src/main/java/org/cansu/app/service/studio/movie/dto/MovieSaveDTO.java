package org.cansu.app.service.studio.movie.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class MovieSaveDTO {
    public long movieId;
    public String name;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    public LocalDate sceneDate;
    public int rating;
    public double cost;
    public float imdb;
}
