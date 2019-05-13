package com.movie.movieMIDb.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_country")
public class Country{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "cou_cl_iso-3166-1", nullable = false)
    private String iso_3166_1;

    @Column(name = "cou_cl_name", nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "country_programTV",
            joinColumns = @JoinColumn(name = "country_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "programTV_id", nullable = false))
    private Set<ProgramTv> programTVS;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(iso_3166_1, country.iso_3166_1) &&
                Objects.equals(name, country.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iso_3166_1, name);
    }

    public String getIso_3166_1() {
        return iso_3166_1;
    }

    public void setIso_3166_1(String iso_3166_1) {
        this.iso_3166_1 = iso_3166_1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "iso_3166_1='" + iso_3166_1 + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
