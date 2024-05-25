package air.skopje.flightbookingsystem.repository;

import air.skopje.flightbookingsystem.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    Optional<Flight> findByDepartureCity(String departureCity);
    Optional<Flight> findByArrivalCity(String arrivalCity);

    Optional<Flight> findByDepartureCityAndArrivalCityAndDepartureTime(String departureCity, String arrivalCity, LocalDateTime departureTime);
}
