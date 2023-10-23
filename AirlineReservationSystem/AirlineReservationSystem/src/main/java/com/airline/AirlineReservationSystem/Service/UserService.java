package com.airline.AirlineReservationSystem.Service;

import com.airline.AirlineReservationSystem.Dto.UserDto;
import com.airline.AirlineReservationSystem.Entity.User;

public interface UserService {
    String registerUser(UserDto userDto);

    User findById(int id);

    String DeleteUserById(int id);
}
