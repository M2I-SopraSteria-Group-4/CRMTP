package com.SpringCRMTP.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@Entity
@Data
@Table(name = "orders")
@ToString(exclude = "client")
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id ;

    private String typePresta;
    private String designation;
    @Positive
    private int nbDays;
    private int state;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "client_id")
    private Client client;

    public Order(String typePresta, String designation, int nbDays, int state, Client client) {
        this.typePresta = typePresta;
        this.designation = designation;
        this.nbDays = nbDays;
        this.state = state;
        this.client = client;
    }
}