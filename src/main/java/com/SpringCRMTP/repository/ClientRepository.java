package com.SpringCRMTP.repository;

import com.SpringCRMTP.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
