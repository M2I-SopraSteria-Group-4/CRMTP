package com.SpringCRMTP.services;

import com.SpringCRMTP.entity.Client;
import com.SpringCRMTP.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    public void deleteClient(int id){
        Client c = cRepo.findById(id).orElse(null);
        if(c!=null) cRepo.delete(c);
    }

    public void updateClient(Client c){
        cRepo.save(c);
    }


}
