package com.SpringCRMTP.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

import com.github.javafaker.Faker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {


	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOrder ;
	
	private String typePresta;
	private String designation;
	@Positive
	private int nbDays;
	
	private int state;
    
	    @ManyToOne
	    @JoinColumn(name="id")
	    private Client client;

	

	public Order(Faker f) {
		
		this.typePresta =f.lorem().word() ;
		this.designation =f.lorem().paragraph() ;
		this.nbDays =f.number().randomDigit() ;
		this.state =f.number().numberBetween(0, 2) ;
		
	}

	
	
	
	
}
