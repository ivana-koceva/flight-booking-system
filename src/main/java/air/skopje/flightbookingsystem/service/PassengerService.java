package air.skopje.flightbookingsystem.service;

import air.skopje.flightbookingsystem.model.Flight;
import air.skopje.flightbookingsystem.model.Passenger;

import java.util.List;
import java.util.Optional;

public interface PassengerService {
    List<Passenger> findAll();
    Optional<Passenger> findById(Long id);
    Optional<Passenger> create(String firstName, String lastName, String emailAddress, String phoneNumber);
    Optional<Passenger> update(Long id, String firstName, String lastName, String emailAddress, String phoneNumber);
    void deleteById(Long id);
}
