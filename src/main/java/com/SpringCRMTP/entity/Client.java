package com.SpringCRMTP.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Table(name = "clients")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Length(max = 64, min = 4, message = "max 64, min 4 chars")
    private String firstName;
    @Length(max = 64, min = 4, message = "max 64, min 4 chars")
    private String lastName;
    @Email(message = "email not valid")
    private String email;
    private String phone;
    private String address;
    private String zipCode;
    private String city;
    private String country;
    private int state;

    @OneToMany(targetEntity = Order.class, mappedBy = "client")
    @JsonManagedReference
    private List<Order> orders;

    public Client(String firstName, String lastName, String email, String phone,
                  String address, String zipCode, String city, String country, int state) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
        this.state = state;
    }
}
