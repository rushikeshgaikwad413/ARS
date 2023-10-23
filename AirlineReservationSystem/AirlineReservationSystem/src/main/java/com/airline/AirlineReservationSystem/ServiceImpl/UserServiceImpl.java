package com.airline.AirlineReservationSystem.ServiceImpl;

import com.airline.AirlineReservationSystem.Dto.UserDto;
import com.airline.AirlineReservationSystem.Entity.User;
import com.airline.AirlineReservationSystem.Exception.UserAlreadyExistException;
import com.airline.AirlineReservationSystem.Exception.UserNotFoundException;
import com.airline.AirlineReservationSystem.Repository.UserRepo;
import com.airline.AirlineReservationSystem.Response.UserResponse;
import com.airline.AirlineReservationSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepository;


    @Override
    public String registerUser(UserDto userDto) {
        User byEmail = userRepository.findByEmail(userDto.getEmail());
        if (byEmail == null){
            User user = new User(userDto);
            userRepository.save(user);
            return "User Added Susseccfully";
        }else {
            throw new UserAlreadyExistException("User Already Exist");
        }
    }

    @Override
    public User findById(int id) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isEmpty()){
            throw new UserNotFoundException("User Not Found");
        }return byId.get();
    }

    @Override
    public String DeleteUserById(int id) {
        Optional<User> byId = userRepository.findById(id);
        if (byId == null){
            throw new UserNotFoundException("user Not Found");
        }
        userRepository.deleteById(id);
        return "user Deleted Successfully" + id;
    }


}
