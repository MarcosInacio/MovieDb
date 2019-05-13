package com.movie.movieMIDb.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SerieDTO implements Serializable {

    private String name;
    private String overview;


    private String original_language;
    private String first_air_date;


    private List<GenreDTO> genres;
}
