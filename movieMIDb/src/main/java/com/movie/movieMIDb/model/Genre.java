package com.movie.movieMIDb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_genre")
public class Genre {

    @Id
    @Column(name = "gen_cl_id", nullable = false)
    private int id;

    @Column(name = "gen_cl_name", nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "genre_programTV",
            joinColumns = @JoinColumn(name = "genre_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "programTV_id", nullable = false))
    private Set<ProgramTv> programTVS;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return id == genre.id &&
                Objects.equals(name, genre.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
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

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
