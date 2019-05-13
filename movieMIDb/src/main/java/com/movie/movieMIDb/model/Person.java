package com.movie.movieMIDb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_person")
public class Person {

    @Id
    @Column(name = "per_cl_id", nullable = false)
    private int id;

    @Column(name = "per_cl_name", nullable = false)
    private String name;

    @Column(name = "per_cl_placeOfBirth")
    private String placeOfBirth;

    @Max(2)
    @Column(name = "per_cl_gender")
    private int gender;

    @Column(name = "per_cl_height")
    private String height;

    @Column(name = "per_cl_countryLive")
    private String countryLive;

    @JsonBackReference
    @ManyToMany(cascade = { CascadeType.MERGE , CascadeType.PERSIST})
    @JoinTable(name = "person_programTV",
            joinColumns = @JoinColumn(name = "person_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "programTV_id", nullable = false))
    private Set<ProgramTv> programTvs;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                gender == person.gender &&
                Objects.equals(name, person.name) &&
                Objects.equals(placeOfBirth, person.placeOfBirth) &&
                Objects.equals(height, person.height) &&
                Objects.equals(countryLive, person.countryLive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, placeOfBirth, gender, height, countryLive);
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

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getCountryLive() {
        return countryLive;
    }

    public void setCountryLive(String countryLive) {
        this.countryLive = countryLive;
    }
}