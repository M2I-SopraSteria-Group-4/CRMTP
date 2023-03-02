package com.SpringCRMTP.services;

import com.SpringCRMTP.entity.Client;
import com.SpringCRMTP.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientService {

    @Autowired
    ClientRepository cRepo;

    public List<Client> findAll(){
        return cRepo.findAll();
    }

    public Client findById(int id){
        return cRepo.findById(id).orElse(null);
    }

    public void save(Client c){
        cRepo.save(c);
    }

    public Client getRandomClient(){
        return cRepo.findAll().get((int)(Math.random() * cRepo.count()));
    }

    public void deleteClient(int id){
        Client c = cRepo.findById(id).orElse(null);
        if(c!=null) cRepo.delete(c);
    }

    public void updateClient(Client c){
        cRepo.save(c);
    }




}
