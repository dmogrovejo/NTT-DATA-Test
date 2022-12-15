package com.nttdata.test.model;

import java.math.BigDecimal;
import java.util.Date;

import com.nttdata.test.model.object.MovementType;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
/**
 * 
 * Entity that maps the movements table, which is used to manage the movements of the accounts
 * @author David Mogrovejo
 */
@Entity
@Getter
@Setter
public class Movement {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "MOVEMENT_ID")
	private String id;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_MOVEMENT")
	private Date dateMovement;

	@Column(name = "MOVEMENT_TYPE")
	@Enumerated(EnumType.STRING)
	private MovementType movementType;
	
	@Column
	private BigDecimal value =  BigDecimal.ZERO;
	
	@Column
	private BigDecimal balance =  BigDecimal.ZERO;

	@ManyToOne
	@JoinColumn(name = "ACCOUNT_ID")
	private Account account;
	
	@Column
	private String description;	
	
}
