package com.SpringCRMTP.repository;

import com.SpringCRMTP.entity.Client;
import com.SpringCRMTP.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer>{

    Client findByClient(int id);

}
