package com.SpringCRMTP.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;


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
public class Client {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id ;
	
	@Length(max = 64, min = 4, message = "max 64, min 4 chars")
	private String firstName;
	@Length(max = 64, min = 4, message = "max 64, min 4 chars")
	private String lastName;
	private String email;
	private String phone;
	private String address;
	private String zipCode;
	private String city;
	private String country;
	private int state;
	@OneToMany(targetEntity=Order.class,cascade=CascadeType.ALL)
    @JoinColumn(name="fk_client_id",referencedColumnName ="id" )
    private List<Order> Orders;
	

	public Client(Faker f) {
		super();
		this.firstName = f.name().firstName();
		this.lastName =f.name().lastName();
		this.email = f.internet().emailAddress();
		this.phone = f.phoneNumber().phoneNumber();
		this.address = f.address().cityName();
		this.zipCode =f.lorem().paragraph();
		this.city =f.address().city();
		this.country =f.address().country();
		this.state = f.number().numberBetween(0, 2);
	}


	public List<Client> getOrder() {
		// TODO Auto-generated method stub
		return null;
	}


	public void add(Client c) {
		// TODO Auto-generated method stub
		
	}
	
	
}
