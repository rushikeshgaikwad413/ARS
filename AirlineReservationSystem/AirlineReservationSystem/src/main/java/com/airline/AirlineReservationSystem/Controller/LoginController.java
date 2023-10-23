package com.airline.AirlineReservationSystem.Controller;

import com.airline.AirlineReservationSystem.Dto.LoginDto;
import com.airline.AirlineReservationSystem.Dto.UserDto;
import com.airline.AirlineReservationSystem.Entity.User;
import com.airline.AirlineReservationSystem.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/loginUser")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto){
        try{
            User user = loginService.loginUser(loginDto);
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid email and password");
        }
    }
}
