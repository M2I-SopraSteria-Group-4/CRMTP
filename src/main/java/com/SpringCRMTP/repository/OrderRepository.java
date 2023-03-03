package com.SpringCRMTP.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringCRMTP.entity.Client;
import com.SpringCRMTP.entity.Order;


public interface OrderRepository extends JpaRepository<Order, Integer>{
	List<Order> findByClient(Client c);
}
