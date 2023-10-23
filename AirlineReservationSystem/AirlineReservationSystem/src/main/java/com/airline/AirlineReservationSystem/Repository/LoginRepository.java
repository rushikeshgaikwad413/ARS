package com.airline.AirlineReservationSystem.Repository;

import com.airline.AirlineReservationSystem.Entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository {

    User findByEmail(String email);
}
