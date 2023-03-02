package com.SpringCRMTP.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	
	private String typePresta;
	private String designation;
	@Positive
	private int nbDays;
	private String state;
    

	
}
