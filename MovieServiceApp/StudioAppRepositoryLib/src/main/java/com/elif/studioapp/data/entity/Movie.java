package com.elif.studioapp.data.entity;

import java.time.LocalDate;

public class Movie {
    public long movieId;
    public String name;
    public LocalDate sceneDate;
    public int rating;
    public double cost;
    public float imdb;

    public Movie(long movieId, String name, LocalDate sceneDate, int rating, double cost, float imdb) {
        this.movieId = movieId;
        this.name = name;
        this.sceneDate = sceneDate;
        this.rating = rating;
        this.cost = cost;
        this.imdb = imdb;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getSceneDate() {
        return sceneDate;
    }

    public void setSceneDate(LocalDate sceneDate) {
        this.sceneDate = sceneDate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public float getImdb() {
        return imdb;
    }

    public void setImdb(float imdb) {
        this.imdb = imdb;
    }
}
