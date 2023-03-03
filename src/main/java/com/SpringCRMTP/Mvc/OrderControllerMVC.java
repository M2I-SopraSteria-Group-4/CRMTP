/*package com.SpringCRMTP.Mvc;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.SpringCRMTP.Entity.Client;
import com.SpringCRMTP.Entity.Order;
import com.SpringCRMTP.Repository.OrderRepository;
import com.SpringCRMTP.Service.OrderService;
@Controller
public class OrderControllerMVC {

	@Autowired
	OrderService oService;
	
	@Autowired
	OrderRepository oRepo;
	
	
	
	@GetMapping("/createorder")
	public String createView(Order o)
	{
		return "createorder";
		
	}
	@PostMapping("/create")
	public String addOrder(Model m,@Valid Order o,BindingResult result)
	{
	   
		oService.addOrder(o);
	
	return"redirect:/client";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteClient(@PathVariable("id") int id)
	{
		System.out.println(id);
		Order o=oService.getById(id);
		oService.deleteOrder(o);
		return "redirect:/client";
	}
	
	@GetMapping("/update/{id}")
	public String updateClient(@PathVariable("id") int id,Order o)
	{
	 
	 oService.updateOder(o);
	 return "redirect:/client";
	}
	
}

*/
