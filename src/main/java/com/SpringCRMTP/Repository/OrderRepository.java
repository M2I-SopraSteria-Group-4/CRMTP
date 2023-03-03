package com.SpringCRMTP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringCRMTP.Entity.Client;
import com.SpringCRMTP.Entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	void save(Client c);

}
