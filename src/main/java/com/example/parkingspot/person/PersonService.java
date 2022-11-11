package com.example.parkingspot.person;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
  private final PersonRepository personRepository;

  @Autowired
  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  public Person getPersonById(Long personId) {
    Optional<Person> personOptional = personRepository.findById(personId);
    if (personOptional.isPresent()) {
      return personOptional.get();
    }
    return null;
    // return personRepository.findById(personId).orElseThrow(() -> new
    // RuntimeException("Person not found"));
  }

  public List<Person> getAllPersons() {
    return personRepository.findAll();
  }

  public void addNewPerson(Person person) {
    personRepository.save(person);
  }

}
