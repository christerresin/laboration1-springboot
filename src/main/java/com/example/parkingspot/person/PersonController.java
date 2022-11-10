package com.example.parkingspot.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person")
public class PersonController {
  private final PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @GetMapping("/{id}")
  public Person getPerson(@PathVariable(name = "id") Long personId) {
    return personService.getPersonById(personId);
  }

  @PostMapping
  public void addNewPerson(@RequestBody Person person) {
    personService.addNewPerson(person);
  }

}
