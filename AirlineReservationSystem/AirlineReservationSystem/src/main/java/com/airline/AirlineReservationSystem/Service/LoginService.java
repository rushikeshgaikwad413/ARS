package com.airline.AirlineReservationSystem.Service;

import com.airline.AirlineReservationSystem.Dto.LoginDto;
import com.airline.AirlineReservationSystem.Dto.UserDto;
import com.airline.AirlineReservationSystem.Entity.User;

public interface LoginService {

    User loginUser(LoginDto loginDto);
}
