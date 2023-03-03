package com.SpringCRMTP.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.SpringCRMTP.Repository.ClientRepository;
import com.SpringCRMTP.Service.ClientService;
import com.github.javafaker.Faker;

@Controller
public class ClientController {
	@Autowired
	ClientRepository cRepo;
	
	@Autowired
	ClientService cService;
	

@GetMapping("/client")
	
	public String helloclient(Model m) {
		m.addAttribute("listClients", cService.getAllClients());
		
		
		return "show";
	}
@GetMapping("client/f/{number}")
public void fakeClient(@PathVariable("number")int number)
	    {
		
		Faker f=new Faker();
		for(int i=0 ;i<number ;i++) {
		Client c=new Client(f);
	
		this.cRepo.save(c);
	    }
	    }

@GetMapping("/create")
public String createView(Client c) {
	return "create";
}
@PostMapping("/create")
public String addAuthor(Model m,@Valid Client c,BindingResult result) {
	
	 if (result.hasErrors())
		{
		 return "create";
		}
	cService.createClient(c);
	return "redirect:/client";
}
@GetMapping ("/delete/{id}")
public String deleteProduct(@PathVariable("id") int id) {
	System.out.println(id);
	
	Client c= cService.getByIdClient(id);
	cService.delete(c);
	
	return "redirect:/client";
}

@GetMapping("/update/{id}")
public String updateView(@PathVariable("id") int id, Model m) {
	
	m.addAttribute("client", cService.getByIdClient(id) );
	
	return "update";
}
@PostMapping("/update/{id}")
public String updateAuthor(@PathVariable("id") int id, Client c) {
	c.setId(id);
	cService.update(c);
	
	return "redirect:/client";
}


	
	
	
	
}

