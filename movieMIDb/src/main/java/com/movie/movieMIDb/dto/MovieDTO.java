package com.movie.movieMIDb.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDTO implements Serializable {

    private int id;
    private String title;
    private String overview;
    private List<CastDTO> CastDTO;
    private List<CountryDTO> production_countries;
    private String original_language;
    private String release_date;
    private int runtime;
    private List<GenreDTO> genres;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<com.movie.movieMIDb.dto.CastDTO> getCastDTO() {
        return CastDTO;
    }

    public void setCastDTO(List<com.movie.movieMIDb.dto.CastDTO> castDTO) {
        CastDTO = castDTO;
    }

    public List<GenreDTO> getGenres() {
        return genres;
    }

    public void setGenres(List<GenreDTO> genres) {
        this.genres = genres;
    }

    public List<CountryDTO> getProduction_countries() {
        return production_countries;
    }

    public void setProduction_countries(List<CountryDTO> production_countries) {
        this.production_countries = production_countries;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date.substring(0,4);
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", CastDTO=" + CastDTO +
                ", production_countries=" + production_countries +
                ", original_language='" + original_language + '\'' +
                ", release_date='" + release_date + '\'' +
                ", runtime=" + runtime +
                ", genres=" + genres +
                '}';
    }
}
