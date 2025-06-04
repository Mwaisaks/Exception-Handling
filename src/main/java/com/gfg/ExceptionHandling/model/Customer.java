package com.gfg.ExceptionHandling.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.Contract;

@Entity
@Table(name = "customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String email;

}
