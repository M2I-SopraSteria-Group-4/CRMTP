package com.SpringCRMTP.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "Phone number is required")
    private String phone;
    @NotEmpty
    private String address;
    @Length(max = 5, min = 5, message = "Zip must be 5 characters long")
    private String zipCode;
    @NotEmpty
    private String city;
    @NotEmpty
    private String country;
    @Range(min = 1, max = 2, message = "Doit être entre 1 et 2")
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
