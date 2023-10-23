package com.airline.AirlineReservationSystem.Entity;

import com.airline.AirlineReservationSystem.Dto.UserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Flight No is required")
    private String flightNo;

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;


    public User() {
    }

    public User(UserDto userDto) {
        this.firstName= userDto.getFirstName();
        this.lastName= userDto.getLastName();
        this.flightNo= userDto.getFlightNo();
        this.email= userDto.getEmail();
        this.password= userDto.getPassword();
        this.id= userDto.getId();
    }


}
