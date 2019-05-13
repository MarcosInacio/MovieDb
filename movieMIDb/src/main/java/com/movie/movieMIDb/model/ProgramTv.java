package com.movie.movieMIDb.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.models.auth.In;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ProgramTv {

    @Id
    @Column (name = "pro_cl_id", nullable = false)
    private int id;

    @Column(name = "pro_cl_title", nullable = false)
    private String title;

    @Size(max = 2000)
    @Column(name = "pro_cl_overview")
    private String overview;

    @Column(name = "pro_cl_originalLanguage", nullable = false)
    private String originalLanguage;

    @Column(name = "pro_cl_releaseDate", nullable = false)
    private String releaseDate;

    @Column(name = "pro_cl_runtime")
    private int runtime;

    @ManyToMany(mappedBy = "programTVS")
    private Set<Genre> genreSet;

    @ManyToMany(mappedBy = "programTVS")
    private Set<Country> productionCountries;

    @ManyToMany(mappedBy = "programTVS")
    private Set<Cast> casts;

    //@ManyToMany(mappedBy = "programTvs")
    //private Set<Person> person;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgramTv programTv = (ProgramTv) o;
        return id == programTv.id &&
                runtime == programTv.runtime &&
                Objects.equals(title, programTv.title) &&
                Objects.equals(overview, programTv.overview) &&
                Objects.equals(originalLanguage, programTv.originalLanguage) &&
                Objects.equals(releaseDate, programTv.releaseDate) &&
                Objects.equals(genreSet, programTv.genreSet) &&
                Objects.equals(productionCountries, programTv.productionCountries) &&
                Objects.equals(casts, programTv.casts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, overview, originalLanguage, releaseDate, runtime, genreSet, productionCountries, casts);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public Set<Genre> getGenreSet() {
        return genreSet;
    }

    public void setGenreSet(Set<Genre> genreSet) {
        this.genreSet = genreSet;
    }

    public Set<Country> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(Set<Country> productionCountries) {
        this.productionCountries = productionCountries;
    }

    public Set<Cast> getCasts() {
        return casts;
    }

    public void setCasts(Set<Cast> casts) {
        this.casts = casts;
    }

    @Override
    public String toString() {
        return "ProgramTv{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", originalLanguage='" + originalLanguage + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", runtime=" + runtime +
                ", genreSet=" + genreSet +
                ", productionCountries=" + productionCountries +
                ", casts=" + casts +
                '}';
    }
}
