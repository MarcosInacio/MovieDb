package com.movie.movieMIDb.model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_serie")
public class Serie extends ProgramTv {

    @OneToMany(mappedBy = "serie")
    private Set<Season> seasons;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Serie serie = (Serie) o;
        return Objects.equals(seasons, serie.seasons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), seasons);
    }

    public Set<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(Set<Season> seasons) {
        this.seasons = seasons;
    }
}
