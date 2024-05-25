package air.skopje.flightbookingsystem.service.impl;

import air.skopje.flightbookingsystem.model.Flight;
import air.skopje.flightbookingsystem.model.dto.FlightDTO;
import air.skopje.flightbookingsystem.model.exceptions.FlightNotFoundException;
import air.skopje.flightbookingsystem.model.exceptions.NoFlightsFromDepartureCityException;
import air.skopje.flightbookingsystem.model.exceptions.NoFlightsToArrivalCityException;
import air.skopje.flightbookingsystem.repository.FlightRepository;
import air.skopje.flightbookingsystem.service.FlightService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    public Optional<Flight> findById(Long id) {
        Flight f = flightRepository.findById(id).orElseThrow(() -> new FlightNotFoundException(id));
        return Optional.of(f);
    }

    @Override
    public Optional<Flight> findByDepartureCity(String departureCity) {
        Flight f = flightRepository.findByDepartureCity(departureCity).orElseThrow(() -> new NoFlightsFromDepartureCityException());
        return Optional.of(f);
    }

    @Override
    public Optional<Flight> findByArrivalCity(String arrivalCity) {
        Flight f = flightRepository.findByArrivalCity(arrivalCity).orElseThrow(() -> new NoFlightsToArrivalCityException());
        return Optional.of(f);
    }

    @Override
    public Optional<Flight> findByDepartureCityAndArrivalCityAndDepartureTime(String departureCity, String arrivalCity, LocalDateTime departureTime) {
        Flight f = flightRepository.findByDepartureCityAndArrivalCityAndDepartureTime(departureCity, arrivalCity, departureTime).orElseThrow(() -> new NoFlightsFromDepartureCityException());
        return Optional.of(f);
    }

    @Override
    public Optional<Flight> create(String companyName, String departureCity, LocalDateTime departureTime, String arrivalCity, LocalDateTime arrivalTime, double ticketPrice, int availableSeats) {
        Flight f = new Flight(companyName, departureCity, departureTime, arrivalCity, arrivalTime, ticketPrice, availableSeats);
        flightRepository.save(f);
        return Optional.of(f);
    }

    @Override
    public Optional<Flight> create(FlightDTO flightDTO) {
        Flight f = new Flight(flightDTO.getCompanyName(), flightDTO.getDepartureCity(), flightDTO.getDepartureTime(),
                flightDTO.getArrivalCity(), flightDTO.getArrivalTime(), flightDTO.getTicketPrice(), flightDTO.getAvailableSeats());
        flightRepository.save(f);
        return Optional.of(f);
    }

    @Override
    public Optional<Flight> update(Long id, String companyName, String departureCity, LocalDateTime departureTime, String arrivalCity, LocalDateTime arrivalTime, double ticketPrice, int availableSeats) {
        Flight f = flightRepository.findById(id).orElseThrow(() -> new FlightNotFoundException(id));
        f.setCompanyName(companyName);
        f.setDepartureCity(departureCity);
        f.setDepartureTime(departureTime);
        f.setArrivalCity(arrivalCity);
        f.setArrivalTime(arrivalTime);
        f.setTicketPrice(ticketPrice);
        f.setAvailableSeats(availableSeats);
        flightRepository.save(f);
        return Optional.of(f);
    }

    @Override
    public Optional<Flight> update(Long id, FlightDTO flightDTO) {
        Flight f = flightRepository.findById(id).orElseThrow(() -> new FlightNotFoundException(id));
        f.setCompanyName(flightDTO.getCompanyName());
        f.setDepartureCity(flightDTO.getDepartureCity());
        f.setDepartureTime(flightDTO.getDepartureTime());
        f.setArrivalCity(flightDTO.getArrivalCity());
        f.setArrivalTime(flightDTO.getArrivalTime());
        f.setTicketPrice(flightDTO.getTicketPrice());
        f.setAvailableSeats(flightDTO.getAvailableSeats());
        flightRepository.save(f);
        return Optional.of(f);
    }

    @Override
    public void deleteById(Long id) {
        flightRepository.deleteById(id);
    }

    @Override
    public void lowerAvailableSeats(Long id) {
        Flight f = flightRepository.findById(id).orElseThrow(() -> new FlightNotFoundException(id));
        f.setAvailableSeats(f.getAvailableSeats()-1);
        this.flightRepository.save(f);
    }
}
