package air.skopje.flightbookingsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String departureCity;
    private LocalDateTime departureTime;
    private String arrivalCity;
    private LocalDateTime arrivalTime;
    private double ticketPrice;
    private int availableSeats;

    public Flight() {
    }

    public Flight(String companyName, String departureCity, LocalDateTime departureTime, String arrivalCity, LocalDateTime arrivalTime, double ticketPrice, int availableSeats) {
        this.companyName = companyName;
        this.departureCity = departureCity;
        this.departureTime = departureTime;
        this.arrivalCity = arrivalCity;
        this.arrivalTime = arrivalTime;
        this.ticketPrice = ticketPrice;
        this.availableSeats = availableSeats;
    }
}
