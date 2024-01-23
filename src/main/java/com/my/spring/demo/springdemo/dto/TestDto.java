package com.my.spring.demo.springdemo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestDto {

    private long id;

    @NotNull(message = "firstName must be required")
    private String firstName;

    @NotNull(message = "last name must required")
    private String lastName;

    @NotNull(message = "phone must required")
    private int phone;

    @NotNull(message = "Email must required")
    @Email(message = "It should be valid email address")
    private String email;
}
