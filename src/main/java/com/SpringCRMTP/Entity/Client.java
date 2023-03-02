package com.SpringCRMTP.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Client {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id ;
	
	@Length(max = 64, min = 4, message = "max 64, min 4 chars")
	private String firstName;
	@Length(max = 64, min = 4, message = "max 64, min 4 chars")
	private String lastName;
	private String email;
	private int phone;
	private String address;
	private String zipCode;
	private String city;
	private String country;
	private int state;
	
	
	
	
}
