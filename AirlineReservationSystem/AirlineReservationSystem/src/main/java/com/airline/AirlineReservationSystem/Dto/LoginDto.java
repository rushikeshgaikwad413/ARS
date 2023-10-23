package com.airline.AirlineReservationSystem.Dto;

import com.airline.AirlineReservationSystem.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

    private int id;

    private String email;
    private String password;

    public LoginDto(User user) {
        this.email= user.getEmail();
        this.password= user.getPassword();
        this.id= user.getId();
    }
}
