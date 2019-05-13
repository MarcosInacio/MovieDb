package com.movie.movieMIDb.controller;

import com.movie.movieMIDb.dto.PersonDTO;
import com.movie.movieMIDb.model.Person;
import com.movie.movieMIDb.service.PersonService;
import com.movie.movieMIDb.utils.PersonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonFactory personFactory;

    @GetMapping()
    public ResponseEntity<?> getAllPerson(){
        List<Person> personList = personService.getAllPerson();
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }

    @PostMapping
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> createPerson(@RequestBody PersonDTO personDTO) {
        Person person = personService.createPerson(personDTO);
        personFactory.getPeople().add(person);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable int id, @RequestBody Person person){
        for (int i = 0; i < personFactory.getPeople().size(); i++){
            if(id == personFactory.getPeople().get(i).getId()) {
                this.personFactory.getPeople().set(i, person);
                return new ResponseEntity<>(person, HttpStatus.OK);
            }
        }
        return new ResponseEntity<> ("Person-Id don't exist!", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable int id){

        for(Person person: personFactory.getPeople()){
            if (person.getId() == id){
                this.personFactory.getPeople().remove(person);
                return new ResponseEntity<>(person, HttpStatus.OK);
            }
        }

        return new ResponseEntity<> ("Person-Id don't exist!", HttpStatus.NOT_FOUND);
    }

}
