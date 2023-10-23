package com.airline.AirlineReservationSystem.Response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserDeleteResponse {

    private String status;
    private String message;

    public UserDeleteResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
