package com.SpringCRMTP.RestController;

import com.SpringCRMTP.entity.Order;
import com.SpringCRMTP.repository.OrderRepository;
import com.SpringCRMTP.services.ClientService;
import com.SpringCRMTP.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/order")
public class OrderRestController {

    @Autowired
    OrderService oService;
    @Autowired
    ClientService cService;


    @Autowired
    OrderRepository oRepo;

    @GetMapping("/list")
    public List<Order> listOrders(){
        return oService.findAll();
    }

    @GetMapping("/{id}")
    public Order showOrder(@PathVariable int id){
        return oService.findById(id);
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



    @PostMapping("/create/{id}")
    public String createOrderById(@PathVariable("id") int id,@RequestBody Order o){

        oService.createByClientId(id,o);
        return "Order has been created!";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable("id") int id){
        oService.deleteOrder(id);
        return "Order has been deleted!";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable("id") int id, Model model){
        model.addAttribute("order", oService.findById(id));
        return "orders/update";
    }

    @PutMapping("/update/{id}")
    public String updateOrder(@PathVariable("id") int id, @RequestBody Order o){
        oService.updateRestOrder(id,o);
        return "Order has been updated!";
    }
}
