package com.nttdata.test.model;

import com.nttdata.test.model.object.Gender;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
/**
 * Master class for people management
 * @author David Mogrovejo
 */

@MappedSuperclass
@Getter
@Setter
public abstract class Person {
	
	@Column(unique = true)
	private String name;	
	
	@Enumerated(EnumType.STRING)
	private Gender gender;	
	
	@Column
	private Integer age;
	
	@Column
	private String identification;
	
	@Column
	private String address;
	
	@Column
	private String phone;	
}
