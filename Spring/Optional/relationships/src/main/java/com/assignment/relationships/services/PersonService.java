package com.assignment.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.assignment.relationships.models.Person;
import com.assignment.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}
	
	public Person findPerson(Long id) {
		Optional<Person> person = personRepository.findById(id);
		if(person.isPresent()) {
			return person.get();
		} else {
			return null;
		}
	}
	
	public Person addPerson(Person person) {
		return personRepository.save(person);
	}
	
	public Person updatePerson(Long id, Person person) {
		Optional<Person> personToUpdate = personRepository.findById(id);
		if(personToUpdate.isPresent()) {
			person.setFirstName(person.getFirstName());
			person.setLastName(person.getLastName());
			person.setLicense(person.getLicense());
			return personRepository.save(person);
		} else {
			return null;
		}
	}
	
	public Person removePerson(Long id) {
		personRepository.deleteById(id);
		return null;
	}
}
