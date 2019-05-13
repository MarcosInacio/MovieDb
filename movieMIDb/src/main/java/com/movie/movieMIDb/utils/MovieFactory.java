package com.movie.movieMIDb.utils;

import com.movie.movieMIDb.model.Movie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MovieFactory {

    private List<Movie> movie;

    public MovieFactory(){
        this.movie = new ArrayList<>(Arrays.asList());
    }

    public void setMovie(List<Movie> movie) {
        this.movie = movie;
    }

    public List<Movie> getMovie() {
        return movie;
    }
}
