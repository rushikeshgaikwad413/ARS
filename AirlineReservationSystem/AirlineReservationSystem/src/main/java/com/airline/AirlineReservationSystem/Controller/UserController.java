package com.airline.AirlineReservationSystem.Controller;

import com.airline.AirlineReservationSystem.Dto.UserDto;
import com.airline.AirlineReservationSystem.Entity.User;
import com.airline.AirlineReservationSystem.Exception.UserAlreadyExistException;
import com.airline.AirlineReservationSystem.Exception.UserNotFoundException;
import com.airline.AirlineReservationSystem.Response.UserDeleteResponse;
import com.airline.AirlineReservationSystem.Response.UserResponse;
import com.airline.AirlineReservationSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;



    @GetMapping("/")
    public String mainPage() {
        return "/AddUser";
    }


    @PostMapping("/AddUser")
    public ResponseEntity<String> addUser (@RequestBody UserDto userDto){
        try {
            String string = userService.registerUser(userDto);
            return ResponseEntity.status(HttpStatus.OK).body(string);
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/GetuserById")
    public ResponseEntity<?> getuserById (@RequestParam int id){
        try {
            UserResponse UserResponse = new UserResponse("Successfull");
            UserResponse.setResponse(userService.findById(id));
            return ResponseEntity.status(HttpStatus.OK).body(UserResponse);
        } catch (UserNotFoundException e) {
            UserResponse UserResponse = new UserResponse("Unsuccessfull");
            UserResponse.setException(String.valueOf(e));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(UserResponse);
        }
    }

    @DeleteMapping("/DeleteUser")
    public ResponseEntity<?> DeleteUser(@RequestParam int id){
        try {
            String string = userService.DeleteUserById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new UserDeleteResponse("Successfull",string));
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new UserDeleteResponse("Unsuccessfull","User Not Found"));
        }
    }


}
