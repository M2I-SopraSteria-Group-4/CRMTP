package com.SpringCRMTP.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.SpringCRMTP.entity.Client;
import com.SpringCRMTP.entity.Order;
import com.SpringCRMTP.repository.OrderRepository;
import com.SpringCRMTP.services.ClientService;
import com.SpringCRMTP.services.OrderService;
import com.github.javafaker.Faker;

@Controller
public class Pcontroller {
	@Autowired
    ClientService cService;

    @Autowired
    OrderService oService;
    
    @Autowired
    OrderRepository orepo;
    
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	@GetMapping("/showservices")
	public String showservices(Model model) {
		List<Client> listClient = cService.findAll();
		model.addAttribute("client",listClient);
		for(Client client : listClient) {
			List<Order> ordersList = orepo.findByClient(client);
			if(!ordersList.isEmpty()) {
				model.addAttribute("orders", ordersList);
			}
			
		}
		return "showservices";
	}
	@GetMapping("/showclients")
	public String showclient(Model model) {
		model.addAttribute("clients", cService.findAll());
		return "showclients";
	}
	@GetMapping("/client")
    public String fakeClients(){
    	for(int i=0;i<20;i++) {
        Faker f = new Faker();
        String firstName = f.name().firstName();
        String lastName =f.name().lastName();
        String email= f.internet().emailAddress();
        String phone = f.phoneNumber().phoneNumber();
        String address = f.address().streetAddress();
        String zipCode = f.address().zipCode();
        String city = f.address().city();
        String country = f.address().country();
        int state = f.number().numberBetween(0, 2);
        Client c = new Client(firstName, lastName, email, phone, address, zipCode, city, country, state);
        cService.save(c);}

        return "redirect:/home";
    }

    @GetMapping("/order")
    public String fakeOrders(){
    	for(int i=0;i<20;i++) {
        Faker f = new Faker();
        String typePresta = f.medical().medicineName();
        String designation = f.internet().domainWord();
        int nbDays = f.number().numberBetween(1, 30);
        int state = f.number().numberBetween(0, 3);
        Client c = cService.getRandomClient();

        Order o = new Order(typePresta, designation, nbDays, state, c );
        oService.addOrder(o);}

    	return "redirect:/home";
    }
    @GetMapping("/deleteclient/{id}")
    public String deleteclient(@PathVariable("id") int id){
    	Client client = cService.findById(id);
    	List<Order> l = orepo.findByClient(client);
    	for(Order order : l) {
    		orepo.delete(order);
    	}
        cService.deleteClient(id);
        return "redirect:/showclients";
    }
    @GetMapping("/deleteorder/{id}")
    public String deleteorder(@PathVariable("id") int id){
        oService.deleteOrder(id);
        return "redirect:/showservices";
    }
    @GetMapping("/updateclient/{id}")
    public String getupdateclient(@PathVariable("id") int id, Client c, Model model) {
    	model.addAttribute("client", cService.findById(id));
    	return "updateclient";
    }
    @PostMapping("update/{id}")
    public String postupdate(@PathVariable("id") int id,@Valid Client c, BindingResult bindingResult) {
    	if (bindingResult.hasErrors()) {
            return "updateclient";
        }
    	Client c1 = cService.findById(id);
    	c1.setAddress(c.getAddress());
    	c1.setEmail(c.getEmail());
    	c1.setFirstName(c.getFirstName());
    	c1.setPhone(c.getPhone());
    	c1.setState(c.getState());
    	cService.save(c1);
    	return "redirect:/showclients";
    }

}
