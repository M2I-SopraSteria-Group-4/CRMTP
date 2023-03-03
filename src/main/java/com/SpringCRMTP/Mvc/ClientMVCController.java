package com.SpringCRMTP.Mvc;

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
import com.SpringCRMTP.Repository.ClientRepository;
import com.SpringCRMTP.Repository.OrderRepository;
import com.SpringCRMTP.Service.ClientService;
import com.SpringCRMTP.Service.OrderService;

import com.github.javafaker.Faker;

@Controller
public class ClientMVCController {

	@Autowired
	ClientRepository cRepo;
	
	@Autowired
	ClientService cService;
	@Autowired
	OrderRepository oRepo;
	
	@GetMapping("/client")
	public String prestation(Model model)
	{
		model.addAttribute("listClients",cService.getAllClients());
		return "show";
	}


	
	@GetMapping("/create")
	public String createView(Client c )
	{
		return "create";
		
	}
	@PostMapping("/create")
	public String addClient(Model m,@Valid Client c,BindingResult result)
	{
	   
		cService.createClient(c);
	
	return"redirect:/client";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteClient(@PathVariable("id") int id)
	{
		System.out.println(id);
		Client c=cService.getByIdClient(id);
		cService.delete(c);
		return "redirect:/client";
	}
	
	
	

	
	
	
}
