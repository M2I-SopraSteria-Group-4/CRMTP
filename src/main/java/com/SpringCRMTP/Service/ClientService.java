package com.SpringCRMTP.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringCRMTP.Entity.Client;
import com.SpringCRMTP.Repository.ClientRepository;
@Service
public class ClientService {

	@Autowired
	ClientRepository cRepo;
	
	public List<Client>getAllClients()
	{
	 return  cRepo.findAll();
	
	}
	
	public Client getByIdClient(int id )
	{
		return cRepo.findById(id).orElse(null);
	}

	public void delete (Integer c)
	{
		cRepo.deleteById(c);
	}
	
	public void  updateClient(int id, Client c)
	   {Client clientInDB=cRepo.findById(id).orElse(c);
	if(c!=null)
	{
		clientInDB.setFirstName(c.getFirstName());
		clientInDB.setLastName(c.getLastName());
		clientInDB.setEmail(c.getEmail());
		clientInDB.setPhone(c.getPhone());
		clientInDB.setAddress(c.getAddress());
		clientInDB.setZipCode(c.getZipCode());
		clientInDB.setCity(c.getCity());
		clientInDB.setCountry(c.getCountry());
		clientInDB.setState(c.getState());
        cRepo.save(clientInDB);
	}
	   }
	
	public void createClient(Client c)
	{
		cRepo.save(c);
	}
	
	
	
}
