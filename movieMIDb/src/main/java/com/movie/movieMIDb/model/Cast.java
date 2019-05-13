package com.movie.movieMIDb.model;

import com.movie.movieMIDb.infrastructure.IObjectPersistent;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_cast")
public class Cast{

    @Id
    @Column(name = "cas_cl_cast_id", nullable = false)
    private int cast_id;

    @Column(name = "cas_cl_character", nullable = false)
    private String character;

    @Column(name = "cas_cl_creditId", nullable = false)
    private String creditId;

    @Column(name = "cas_cl_gender")
    private int gender;

    @Column(name = "cas_cl_id", nullable = false)
    private int id;

    @Column(name = "cas_cl_name", nullable = false)
    private String name;

    @Column(name = "cas_cl_order", nullable = false)
    private int order;

    @Column(name = "cas_cl_profilePath")
    private String profilePath;

    @ManyToMany
    @JoinTable(name = "cast_programTV",
            joinColumns = @JoinColumn(name = "cast_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "programTV_id", nullable = false))
    private Set<ProgramTv> programTVS;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cast cast = (Cast) o;
        return gender == cast.gender &&
                id == cast.id &&
                order == cast.order &&
                Objects.equals(cast_id, cast.cast_id) &&
                Objects.equals(character, cast.character) &&
                Objects.equals(creditId, cast.creditId) &&
                Objects.equals(name, cast.name) &&
                Objects.equals(profilePath, cast.profilePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cast_id, character, creditId, gender, id, name, order, profilePath);
    }

    public int getCast_id() {
        return cast_id;
    }

    public void setCast_id(int cast_id) {
        this.cast_id = cast_id;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cast{" +
                "cast_id=" + cast_id +
                ", character='" + character + '\'' +
                ", creditId='" + creditId + '\'' +
                ", gender=" + gender +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", order=" + order +
                ", profilePath='" + profilePath + '\'' +
                '}';
    }
}
