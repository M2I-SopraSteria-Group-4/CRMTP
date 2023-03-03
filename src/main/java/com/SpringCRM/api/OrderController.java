package com.SpringCRM.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringCRMTP.Entity.Client;
import com.SpringCRMTP.Entity.Order;
import com.SpringCRMTP.Repository.ClientRepository;
import com.SpringCRMTP.Repository.OrderRepository;
import com.SpringCRMTP.Service.ClientService;
import com.SpringCRMTP.Service.OrderService;
import com.github.javafaker.Faker;


@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService oService;
	@Autowired
	OrderRepository oRepo;
	@Autowired
	ClientRepository cRepo;
	@Autowired
	ClientService cService;
	
	@GetMapping("/{id}")
	public Order getOrder(@PathVariable("id")int id)
	{
		return oService.getById(id); 
	}
	
	
	@GetMapping
	public List<Order> getAll()
	{
		return oService.getAllOrders();
	}

	
	@PostMapping("/fordre/{number}")
	public void fakeOrder(@PathVariable("number")int number)
	{
		 {
				
				Faker f=new Faker();
				for(int i=0 ;i<number ;i++) {
				Order o =new Order(f);

				for(int j = 0;j<6;j++) {
					Client c=new Client(f);
					o.getClient().add(c);
					cRepo.save(c);
				}
		
		oRepo.save(o);
	}
		 }
	}
	@DeleteMapping
	public void deleteOrder(@RequestBody Order o)
	{
		oService.deleteOrder(o);
	}
	
	@PutMapping("/{id}")
	public void putOrder(@PathVariable("id") int id,@RequestBody Order o) {
		oService.update(id, o);
	}
	
	
}
