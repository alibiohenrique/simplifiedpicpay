package com.simplifiedpicpay.domain.user;

import com.simplifiedpicpay.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "users") // That annotation basically tell to our database, this is Entity.
@Table(name = "users") // Name of the table of this entity is representing
@Getter // Getters
@Setter // Setters
@AllArgsConstructor // Create the constructor that has all the parameters
@NoArgsConstructor // Create the no args constructor
@EqualsAndHashCode(of = "id")  // Primary key of this table

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String document; //This document needs to be unique, so we add an annotation
    @Column(unique = true)
    private String email; // The same logic apply for the email. Cannot have a duplicated email on the database
    private String password;
    private BigDecimal balance;
    @Enumerated(EnumType.STRING)
    private UserType userType; //This annotation basically tells our attribute represents a value or another(common or merchant)

    public User(UserDTO data) {

        this.firstName = data.firstName();
        this.lastName = data.lastName();
        this.balance = data.balance();
        this.userType = data.userType();
        this.password = data.password();
        this.email = data.email();
        this.document = data.document();

    }

}
