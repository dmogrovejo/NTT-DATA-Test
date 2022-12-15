package com.nttdata.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity that maps the Client table, which is used to manage clients
 * @author David Mogrovejo
 */

@Entity
@Getter
@Setter
public class Client extends Person{

	@Id
	@Column(name = "CLIENT_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "CLIENT_ID")
	@TableGenerator(name = "CLIENT_ID", table = "ID_GEN",
	pkColumnName = "NAME_PK", valueColumnName = "VALUE_PK",
	pkColumnValue = "CLIENT_ID", allocationSize = 1, initialValue = 1)
	private Long id;
	
	@Column
	private String password;
	
	@Column
	private boolean status =  true;
	
}
