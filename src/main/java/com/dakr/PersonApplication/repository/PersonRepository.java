package com.dakr.PersonApplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dakr.PersonApplication.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {

	

	Optional<Person> findByPersonEmail(String personEmail);

	

}
