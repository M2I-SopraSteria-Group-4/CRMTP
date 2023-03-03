package com.SpringCRMTP.controller;

import com.SpringCRMTP.entity.Client;
import com.SpringCRMTP.entity.Order;
import com.SpringCRMTP.repository.OrderRepository;
import com.SpringCRMTP.services.ClientService;
import com.SpringCRMTP.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService oService;
    @Autowired
    ClientService cService;


    @Autowired
    OrderRepository oRepo;

    @GetMapping("/list")
    public String listOrders(Model model){
        model.addAttribute("orders", oService.findAll());
        return "orders/list";
    }

    @GetMapping("/{id}")
    public String showOrder(Model model, @PathVariable int id){
        model.addAttribute("order", oService.findById(id));
        return "orders/one";
    }

//    @GetMapping("/create")
//    public String showCreate(Order o){
//        return "orders/create";
//    }
/*    @PostMapping("/create")
    public String createOrder(@Valid Order o, BindingResult result){
        if (result.hasErrors()) {
            return "orders/create";
        }
        oService.addOrder(o);
        return "redirect:/order/list";
    }*/
    @GetMapping("/create/{id}")
    public String showCreate(Model m,Client c, Order o, @PathVariable("id") int id){
        Client client = cService.findById(id);
        m.addAttribute("client", client);
        return "orders/create";
    }


    @PostMapping("/create/{id}")
    public String createOrderById(@PathVariable("id") int id,@Valid Order o, Client c, BindingResult result){
        if (result.hasErrors()) {
            return "orders/create";
        }
        oService.createByClientId(id,o);
        return "redirect:/order/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable("id") int id){
        oService.deleteOrder(id);
        return "redirect:/order/list";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable("id") int id, Model model){
        Order o = oService.findById(id);
        Client c = o.getClient();
        int clientId = c.getId();
        model.addAttribute("order", o);
        model.addAttribute("client", c);
        return "orders/update";
    }

    @PostMapping("/update/{id}")
    public String updateOrder(@PathVariable("id") int id, @Valid Order o, BindingResult result){
        if (result.hasErrors()) {
            return "orders/update";
        }
        oService.updateOrder(o);
        return "redirect:/order/list";
    }
}
