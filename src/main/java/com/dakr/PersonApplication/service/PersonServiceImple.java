package com.dakr.PersonApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dakr.PersonApplication.entity.Person;
import com.dakr.PersonApplication.repository.PersonRepository;

@Service
public class PersonServiceImple implements PersonService {
	
	
	@Autowired
	private PersonRepository repository;

	@Override
	public Person savePerson(Person person1) {
		
		//compare a password and ConformPassword
		if(person1.getPersonPassword().equals(person1.getPersonConformPassword()))
		{
			return repository.save(person1);
		}
		// Here we not a storing duplicate records in database
		else if(repository.findByPersonEmail(person1.getPersonEmail())!=null) throw new RuntimeException("Record already exists");
			
		
		return null;
		
	}

	@Override
	public void deletePerson(Integer id) {

		repository.deleteById(id);
	}

	@Override
	public Person getPerson(Integer id) {

		Person person=repository.findById(id).get();
		
		
		return person;
	}

	@Override
	public List<Person> getAllPerson() {

		List<Person> list=repository.findAll();
		
		return list;
	}

	@Override
	public Person updatePerson(Person person, Integer id) {

		Person person2=repository.findById(id).get();
		
		person2.setPersonId(id);
		person2.setPersonName(person.getPersonName());
		person2.setPersonNo(person.getPersonNo());
		person2.setPersonEmail(person.getPersonEmail());
		person2.setPersonPassword(person.getPersonPassword());
		person2.setPersonConformPassword(person.getPersonConformPassword());
		
		
		return repository.save(person2);
	}

}
