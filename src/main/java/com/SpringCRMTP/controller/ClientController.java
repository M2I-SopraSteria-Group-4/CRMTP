package com.SpringCRMTP.controller;

import com.SpringCRMTP.entity.Client;
import com.SpringCRMTP.repository.ClientRepository;
import com.SpringCRMTP.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "client/list";
    }

    @GetMapping("/{id}")
    public String showClient(Model model, @PathVariable int id) {
        model.addAttribute("client", cService.findById(id));
        return "client/show";
    }

    @GetMapping("/create")
    public String showCreate(){
        return "client/create";
    }

    @PostMapping("/create")
    public String createClient(Client c, BindingResult result){
        if (result.hasErrors()) {
            return "client/create";
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
    public String updateView(@PathVariable("id") int id, Model model){
        model.addAttribute("client", cService.findById(id));
        return "update";
    }

    @PostMapping("/update/{id}")
    public String updateClient(@PathVariable("id") int id, @Valid Client c, BindingResult result){
        if(result.hasErrors()) {
            return "update";
        }
        cService.updateClient(c);
        return "redirect:/client/list";
    }




}
