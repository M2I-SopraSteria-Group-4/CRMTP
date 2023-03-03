package com.SpringCRMTP.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

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
    @Length(max = 64, min = 1, message = "max 64, min 4 chars")
    private String typePresta;
    @Length(max = 64, min = 1, message = "max 64, min 4 chars")
    private String designation;
    @Positive
    private int nbDays;
    @Positive
    private int unitPrice;
    @Range(min = 0, max = 2, message = "Doit être entre 0 et 2")
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
