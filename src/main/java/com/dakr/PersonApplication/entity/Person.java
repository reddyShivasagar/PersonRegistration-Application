package com.dakr.PersonApplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="PersonTable")
public class Person {

	
	
	@Id
	@Column(name="PersonId")
	private int personId;
	private String personName;
	private long personNo;
	//@Column(unique=true)
	private String personEmail;
	private String personPassword;
	private String personConformPassword;
}
