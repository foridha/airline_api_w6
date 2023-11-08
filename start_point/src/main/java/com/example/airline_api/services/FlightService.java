package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

// start
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;
//  method 1

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

//    method 2

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

//    method 3

    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    //    method 4
    public void cancelFlight(Long id) {
        flightRepository.deleteById(id);
    }

    // method 5
    public Flight addPassengerToFlight(Long flightId, Long passengerId) {
        Flight flight = flightRepository.findById(flightId).get();
       Passenger passenger1 = passengerRepository.findById(passengerId).get();
       flight.addPassenger(passenger1);
        return flightRepository.save(flight);


    }


}