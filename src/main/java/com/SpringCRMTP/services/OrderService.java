package com.SpringCRMTP.services;

import com.SpringCRMTP.entity.Order;
import com.SpringCRMTP.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository oRepo;

    public List<Order> findAll(){
        return oRepo.findAll();
    }

    public Order findById(int id){
        return oRepo.findById(id).orElse(null);
    }

    public void addOrder(Order o){
        oRepo.save(o);
    }

    public void deleteOrder(int id){
        Order o = oRepo.findById(id).orElse(null);
        if(o!=null) oRepo.delete(o);
    }

    public void updateOrder(Order o){
        oRepo.save(o);
    }
}
