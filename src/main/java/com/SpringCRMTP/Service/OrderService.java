package com.SpringCRMTP.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringCRMTP.Entity.Order;
import com.SpringCRMTP.Repository.OrderRepository;


@Service
public class OrderService {

	@Autowired
	OrderRepository oRepo;
	
	public List<Order>getAllOrders()
	{
		return oRepo.findAll();
		
	}
	
	public Order getById(int id) {
		return oRepo.findById(id).orElse(null);
	}
	
	public void deleteOrder(Order o)
	{
		oRepo.delete(o);
	}
	
	public void updateOder(Order o)
	{
		oRepo.save(o);
	}
	
	public void addOrder(Order o)
	{
		oRepo.save(o);
	}

	public void update(int id, Order o) {
		// TODO Auto-generated method stub
		
	}
	

}
