package com.dakr.PersonApplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dakr.PersonApplication.entity.Person;

public interface PersonService {
	
	public Person savePerson(Person person);
	
	
	public void deletePerson(Integer id);
		
	
	public Person getPerson(Integer id);
	
	
	public List<Person> getAllPerson();
	
	
	public Person updatePerson(Person person,Integer id);
		
	
	

}
