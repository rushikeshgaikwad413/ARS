package com.airline.AirlineReservationSystem.ServiceImpl;

import com.airline.AirlineReservationSystem.Dto.LoginDto;
import com.airline.AirlineReservationSystem.Dto.UserDto;
import com.airline.AirlineReservationSystem.Entity.User;
import com.airline.AirlineReservationSystem.Exception.somethingWentWrongException;
import com.airline.AirlineReservationSystem.Repository.UserRepo;
import com.airline.AirlineReservationSystem.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserRepo loginRepository;

    @Override
    public User loginUser(LoginDto loginDto) {
        User byEmail = loginRepository.findByEmail(loginDto.getEmail());
        if (byEmail != null && byEmail.getPassword().equals(loginDto.getPassword())) {
            return byEmail;
        } else {
            throw new somethingWentWrongException("Invalid email and password");
        }
    }

}

