package com.SpringCRMTP.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringCRMTP.Entity.Client;
import com.SpringCRMTP.Repository.ClientRepository;
import com.SpringCRMTP.Repository.OrderRepository;
import com.SpringCRMTP.Service.ClientService;
import com.github.javafaker.Faker;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	ClientService cService;
	
	@Autowired
	ClientRepository cRepo;
	@Autowired
	OrderRepository oRepo;
	
	@GetMapping("/{id}")
	public Client getClientById(@PathVariable("id")int id)
	{
		return cService.getByIdClient(id);
	}
	
	@PostMapping("/f/{number}")
	  public void fakeClient(@PathVariable("number")int number)
	    {
		
		Faker f=new Faker();
		for(int i=0 ;i<number ;i++) {
		Client c =new Client(f);

		
		
		cRepo.save(c);
	    }
	    }	
	
	@GetMapping
	public List<Client> getAll()
	{
		return cService.getAllClients();
	}
	
	@PostMapping
	public void postClient()
	{
	   Client c =new Client();	
	   c.setFirstName(c.getFirstName());
	   c.setLastName(c.getLastName());
	   c.setEmail(c.getEmail());
	   c.setPhone(c.getPhone());
	   c.setAddress(c.getAddress());
	   c.setZipCode(c.getZipCode());
	   c.setCity(c.getCity());
	   c.setCountry(c.getCountry());
	   c.setState(c.getState());
	   
	   cService.createClient(c);
	}
	
	@PutMapping("/{id}")
	public void putClient(@PathVariable("id") int id ,@RequestBody Client c)
	{
        cService.updateClient(id, c);		
	}
	
	@DeleteMapping("/{id}")
	public void deleteClient(@PathVariable("id") Client id )
	{
		cService.delete(id);
	}
}
