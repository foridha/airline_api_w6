package com.example.airline_api.services;

import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

// start
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

//   method 1

    public Passenger GetPassengerById(Long id){
        return passengerRepository.findById(id).orElse(null);
    }

//    method 2

    public List<Passenger> getAllPassengers(){
        return passengerRepository.findAll();
    }

//    method 3
   public Passenger createPassenger(Passenger passenger){
        return passengerRepository.save(passenger);
   }

} // end
