package com.neosoft.hibernatetemplate.controller;

import com.neosoft.hibernatetemplate.model.Person;
import com.neosoft.hibernatetemplate.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/persons")
@EnableTransactionManagement
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person createdPerson = personService.createPerson(person);
        return ResponseEntity.ok(createdPerson);
    }

    @GetMapping("/{personId}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long personId) {
        Person person = personService.getPersonById(personId);
        if (person != null) {
            return ResponseEntity.ok(person);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{personId}")

    public ResponseEntity<Person> updatePerson(@PathVariable Long personId, @RequestBody Person person) {
        Person existingPerson = personService.getPersonById(personId);
        if (existingPerson != null) {
            existingPerson.setPersonName(person.getPersonName());
            existingPerson.setEmail(person.getEmail());
            Person updatePerson = personService.updatePerson(existingPerson);

            return ResponseEntity.ok(updatePerson);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{personId}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long personId) {
        personService.deletePerson(personId);
        return ResponseEntity.noContent().build();

    }

}
