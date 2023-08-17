package com.dakr.PersonApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dakr.PersonApplication.entity.Person;
import com.dakr.PersonApplication.service.PersonService;
import com.dakr.PersonApplication.service.PersonServiceImple;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	
	@PostMapping("/Save")
	public String save(@RequestBody Person person) {
	
	Person person2=service.savePerson(person);
	
	if(person2!=null) {
		return "Data Saved Sucessfully";
	}
	return "Data Not Saved";
		
	}
	
	
	@DeleteMapping("/Delete/{id}")
	public void delete(@PathVariable Integer id) {
		service.deletePerson(id);
	}
	
	
	@GetMapping("/Get/{id}")
	public Person get(@PathVariable Integer id) {
		return service.getPerson(id);
		
	}
	
	
	@GetMapping("/GetAll")
	public List<Person> getAll() {
		return service.getAllPerson();
		
	}
	
	
	@PutMapping("/Update/{id}")
	public Person update(@RequestBody Person person,@PathVariable Integer id) {
		return service.updatePerson(person, id);
		
	}

}
