package com.SpringCRMTP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SpringCRMTP.entity.Client;
import com.SpringCRMTP.repository.ClientRepository;
import com.SpringCRMTP.services.ClientService;

import javax.validation.Valid;
@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService cService;

    @Autowired
    ClientRepository cRepo;

    @GetMapping("/list")
    public String listClients(Model model) {
        model.addAttribute("clients", cService.findAll());
        return "clients/list";
    }

    @GetMapping("/{id}")
    public String showClient(Model model, @PathVariable int id) {
        model.addAttribute("client", cService.findById(id));
        return "clients/one";
    }

    @GetMapping("/create")
    public String showCreate(Client c){
        return "clients/create";
    }

    @PostMapping("/create")
    public String createClient(@Valid Client c, BindingResult result){
        if (result.hasErrors()) {
            return "clients/create";
        }
        cRepo.save(c);
        return "redirect:/client/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") int id) {
        cService.deleteClient(id);
        return "redirect:/client/list";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable("id") int id, Client c, Model model){
        model.addAttribute("client", cService.findById(id));
        return "clients/update";
    }

    @PostMapping("/update/{id}")
    public String updateClient(@PathVariable("id") int id, @Valid Client c, BindingResult result){
        if(result.hasErrors()) {
            return "clients/update";
        }
        cService.updateClient(c);
        return "redirect:/client/list";
    }




}
