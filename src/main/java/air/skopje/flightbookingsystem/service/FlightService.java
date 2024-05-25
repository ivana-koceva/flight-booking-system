package air.skopje.flightbookingsystem.service;

import air.skopje.flightbookingsystem.model.Flight;
import air.skopje.flightbookingsystem.model.dto.FlightDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightService {

    List<Flight> findAll();
    Optional<Flight> findById(Long id);
    Optional<Flight> findByDepartureCity(String departureCity);
    Optional<Flight> findByArrivalCity(String arrivalCity);

    Optional<Flight> findByDepartureCityAndArrivalCityAndDepartureTime(String departureCity, String arrivalCity, LocalDateTime departureTime);
    Optional<Flight> create(String companyName, String departureCity, LocalDateTime departureTime, String arrivalCity, LocalDateTime arrivalTime, double ticketPrice, int availableSeats);
    Optional<Flight> create(FlightDTO flightDTO);
    Optional<Flight> update(Long id, String companyName, String departureCity, LocalDateTime departureTime, String arrivalCity, LocalDateTime arrivalTime, double ticketPrice, int availableSeats);
    Optional<Flight> update(Long id, FlightDTO flightDTO);
    void deleteById(Long id);
    void lowerAvailableSeats(Long id);
}
