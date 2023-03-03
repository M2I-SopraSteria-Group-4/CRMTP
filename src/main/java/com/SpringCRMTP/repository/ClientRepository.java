package com.SpringCRMTP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringCRMTP.entity.Client;


public interface ClientRepository extends JpaRepository<Client, Integer> {
}
