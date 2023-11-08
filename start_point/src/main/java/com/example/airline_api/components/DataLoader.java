package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class DataLoader implements ApplicationRunner {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    Flight flight;

    @Autowired
    Passenger passenger;
    private Object List;

    public DataLoader(){

    }

    //  ?
    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Add sample flights
        Flight flight1 = new Flight("New York", 200, "2023, 11, 10", "10_00");
        Flight flight2 = new Flight("Thailand", 200, "2023, 11, 10", "10_50");
        Flight flight3 = new Flight("Birmingham", 200, "2023, 12, 10", "12_00");
        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);

        // Add sample passengers
        Passenger passenger1 = new Passenger("John Doe", "johndoe@gmail.com");
        Passenger passenger2 = new Passenger("Jane Smith", "jane@example.com");
        passengerRepository.save(passenger1);
        passengerRepository.save(passenger2);

        // Book passengers on flights
        flight1.addPassenger(passenger1);
        flight2.addPassenger(passenger2);
        flightRepository.save(flight1);
        flightRepository.save(flight2);
    }
}

