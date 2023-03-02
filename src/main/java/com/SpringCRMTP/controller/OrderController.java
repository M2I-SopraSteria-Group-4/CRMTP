package com.SpringCRMTP.controller;

import com.SpringCRMTP.entity.Order;
import com.SpringCRMTP.repository.OrderRepository;
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

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService oService;

    @Autowired
    OrderRepository oRepo;

    @GetMapping("/list")
    public String listOrders(Model model){
        model.addAttribute("orders", oService.findAll());
        return "order/list";
    }

    @GetMapping("/{id}")
    public String showOrder(Model model, @PathVariable int id){
        model.addAttribute("order", oService.findById(id));
        return "order/show";
    }

    @GetMapping("/create")
    public String showCreate(){
        return "order/create";
    }
    @PostMapping("/create")
    public String createOrder(@Valid Order o, BindingResult result){
        if (result.hasErrors()) {
            return "order/create";
        }
        oService.addOrder(o);
        return "redirect:/order/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable("id") int id){
        oService.deleteOrder(id);
        return "redirect:/order/list";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable("id") int id, Model model){
        model.addAttribute("order", oService.findById(id));
        return "order/update";
    }

    @PostMapping("/update/{id}")
    public String updateOrder(@PathVariable("id") int id, @Valid Order o, BindingResult result){
        if (result.hasErrors()) {
            return "order/update";
        }
        oService.updateOrder(o);
        return "redirect:/order/list";
    }
}
