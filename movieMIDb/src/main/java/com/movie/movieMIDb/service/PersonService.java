package com.movie.movieMIDb.service;

import com.movie.movieMIDb.dto.PersonDTO;
import com.movie.movieMIDb.model.Person;
import com.movie.movieMIDb.utils.PersonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonFactory personFactory;

    public List<Person> getAllPerson(){

        return this.personFactory.getPeople();
    }

    public void savePerson(List<PersonDTO> personDTOS){

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < personDTOS.size(); i++) {
            Person person = new Person();
            person.setId(personDTOS.get(i).getId());
            person.setName(personDTOS.get(i).getName());
            person.setHeight(personDTOS.get(i).getHeight());
            person.setPlaceOfBirth(personDTOS.get(i).getPlace_of_birth());
            person.setCountryLive(personDTOS.get(i).getCountryLive());
            person.setGender(personDTOS.get(i).getGender());
            people.add(person);
        }
        this.personFactory.setPeople(people);

    }

    public Person createPerson(PersonDTO personDTO){

        Person person = new Person();
        person.setId(personDTO.getId());
        person.setName(personDTO.getName());
        person.setHeight(personDTO.getHeight());
        person.setPlaceOfBirth(personDTO.getPlace_of_birth());
        person.setCountryLive(personDTO.getCountryLive());
        person.setGender(personDTO.getGender());

        return person;

    }
}
