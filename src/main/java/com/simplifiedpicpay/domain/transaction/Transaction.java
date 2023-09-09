package com.simplifiedpicpay.domain.transaction;

import com.simplifiedpicpay.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transactions")
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

//  These annotations are used indicate
//  that instances of this class can be stored in a database table called "transactions."
//  They also automatically generate getter and setter methods, a constructor with all args,
//  also a constructor with no args, and methods for comparing and hashing instances
//  based on their "id" field.

public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;
    private LocalDateTime timestamp;

}
