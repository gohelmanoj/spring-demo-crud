package com.my.spring.demo.springdemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Test")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testId;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private int phone;

    @Column
    private String email;

}
