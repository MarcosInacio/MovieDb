package com.movie.movieMIDb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

    private List<MovieId> results;

    public List<MovieId> getResults() {
        return results;
    }

    public void setResults(List<MovieId> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Result{" +
                "results=" + results +
                '}';
    }
}
