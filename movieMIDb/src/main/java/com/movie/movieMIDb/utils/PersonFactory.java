package com.movie.movieMIDb.utils;

import com.movie.movieMIDb.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PersonFactory {

    private List<Person> people;

    public PersonFactory(List<Person> people) {
        this.people = new ArrayList<>(Arrays.asList());
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
}
