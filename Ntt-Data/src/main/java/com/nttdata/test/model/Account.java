package com.nttdata.test.model;

import java.math.BigDecimal;



import com.nttdata.test.model.object.AccountType;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

/**
 * Entity that maps the Account table, which is used to manage the Accounts
 * @author David Mogrovejo
 */
@Entity
@Getter
@Setter
public class Account {
	@Id
	@Column(name = "ACCOUNT_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "ACCOUNT_ID")
	@TableGenerator(name = "ACCOUNT_ID", table = "ID_GEN",
	pkColumnName = "NAME_PK", valueColumnName = "VALUE_PK",
	pkColumnValue = "ACCOUNT_ID", allocationSize = 1, initialValue = 1)	
	private Long id;

	@Column(name = "ACCOUNT_NUMBER", unique = true, nullable = false)
	private String accountNumber;
		
	@Enumerated(EnumType.STRING)
	@Column(name = "ACCOUNT_TYPE")
	private AccountType accountType;
	
	@Column(name = "INICIAL_BALANCE")
	private BigDecimal inicialBalance;

	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	private Client client;

	@Column
	private boolean status =  true;
		
	@Override
	public String toString() {
		return "Account [id=" + id + ", accountNumber=" + accountNumber + ", accountType=" + accountType+"]";
	}
	
	
}
