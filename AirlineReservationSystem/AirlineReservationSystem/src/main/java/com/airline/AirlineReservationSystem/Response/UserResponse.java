package com.airline.AirlineReservationSystem.Response;

import com.airline.AirlineReservationSystem.Entity.User;

import lombok.Data;

@Data
public class UserResponse {

    private String status;
    private User response;
    private String exception;

    public UserResponse(String status) {
        this.status = status;
    }
}
