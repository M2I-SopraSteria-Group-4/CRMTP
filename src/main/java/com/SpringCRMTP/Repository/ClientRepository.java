package com.SpringCRMTP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringCRMTP.Entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
