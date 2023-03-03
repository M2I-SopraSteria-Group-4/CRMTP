package com.SpringCRMTP.RestController;

import com.SpringCRMTP.entity.Client;
import com.SpringCRMTP.entity.Order;
import com.SpringCRMTP.repository.ClientRepository;
import com.SpringCRMTP.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/client")
public class ClientRestController {

    @Autowired
    ClientService cService;

    @Autowired
    ClientRepository cRepo;

    @GetMapping("/list")
    public List<Client> listClients() {
        return cService.findAll();
    }

    @GetMapping("/{id}")
    public Client showClient(@PathVariable int id) {
        List<Order> orders = cService.findById(id).getOrders();
        return cService.findById(id);
    }


    @PostMapping("/create")
    public String createClient(@RequestBody Client c){
        cRepo.save(c);
        return "Client has been created!"   ;
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") int id) {
        cService.deleteClient(id);
        return "Client has been deleted!";
    }


    @PutMapping("/update/{id}")
    public String updateClient(@PathVariable("id") int id, @RequestBody Client c){
        cService.updateRestClient(id,c);
        return "Client has been updated!";
    }




}
