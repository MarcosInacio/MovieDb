package com.movie.movieMIDb.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_season")
public class Season {

    @Column(name = "sea_cl_airDate", nullable = false)
    private String airDate;

    @Column(name = "sea_cl_episodeCount", nullable = false)
    private int episodeCount;

    @Id
    @Column(name = "sea_cl_id", nullable = false)
    private int id;

    @Column(name = "sea_cl_name", nullable = false)
    private String name;

    @Column(name = "sea_cl_overview", nullable = false)
    private String overview;

    @Column(name = "sea_cl_posterPath", nullable = false)
    private String posterPath;

    @Column(name = "sea_cl_seasonNumber", nullable = false)
    private int seasonNumber;

    @ManyToOne
    @JoinColumn(name = "serie_id")
    private Serie serie;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Season season = (Season) o;
        return episodeCount == season.episodeCount &&
                id == season.id &&
                seasonNumber == season.seasonNumber &&
                Objects.equals(airDate, season.airDate) &&
                Objects.equals(name, season.name) &&
                Objects.equals(overview, season.overview) &&
                Objects.equals(posterPath, season.posterPath) &&
                Objects.equals(serie, season.serie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airDate, episodeCount, id, name, overview, posterPath, seasonNumber, serie);
    }

    public String getAirDate() {
        return airDate;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public int getEpisodeCount() {
        return episodeCount;
    }

    public void setEpisodeCount(int episodeCount) {
        this.episodeCount = episodeCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }
}
