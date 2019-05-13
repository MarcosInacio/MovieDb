package com.movie.movieMIDb.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.movie.movieMIDb.dto.CastDTO;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditsDTO {

    private List<CastDTO> cast;

    public List<CastDTO> getCast() {
        return cast;
    }

    public void setCast(List<CastDTO> cast) {
        this.cast = cast;
    }

    @Override
    public String toString() {
        return "" + cast;
    }
}
