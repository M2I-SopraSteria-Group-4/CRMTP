package com.SpringCRMTP.controller;

import com.SpringCRMTP.entity.Client;
import com.SpringCRMTP.entity.Order;
import com.SpringCRMTP.services.ClientService;
import com.SpringCRMTP.services.OrderService;
import com.github.javafaker.Faker;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/faker")
public class FakerController {

    @Autowired
    ClientService cService;

    @Autowired
    OrderService oService;

    @GetMapping("/client")
    public void fakeClients(){
        Faker f = new Faker();
        String firstName = f.name().firstName();
        String lastName =f.name().lastName();
        String email= f.internet().emailAddress();
        String phone = f.phoneNumber().phoneNumber();
        String address = f.address().streetAddress();
        String zipCode = f.address().zipCode();
        String city = f.address().city();
        String country = f.address().country();
        int state = f.number().numberBetween(0, 2);
        Client c = new Client(firstName, lastName, email, phone, address, zipCode, city, country, state);
        cService.save(c);

        //return "redirect:/client/list";
    }

    @GetMapping("/order")
    public void fakeOrders(){
        Faker f = new Faker();
        String typePresta = f.medical().medicineName();
        String designation = f.internet().domainWord();
        int nbDays = f.number().numberBetween(1, 30);
        int state = f.number().numberBetween(0, 3);
        Client c = cService.getRandomClient();

        Order o = new Order(typePresta, designation, nbDays, state, c );
        oService.addOrder(o);

        //return "redirect:/order/list";
    }



/*    @PostMapping("/fake")
    public List<Client> fakeUsers(){
        List<Author> authors = new ArrayList<>();
        Faker f = new Faker();
        Random r = new Random();


        for(int i = 0; i < 100; i++) {

            Author author = new Author(f);
            aRepo.save(author);

            for (int j = 0; j < r.nextInt(10); j++) {
                Book b = new Book(f);
                author.getBooks().add(b);
                bRepo.save(b);
            }
            authors.add(author);

        }

        return authors;
    }*/

}
