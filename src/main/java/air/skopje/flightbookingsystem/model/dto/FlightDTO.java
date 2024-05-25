package air.skopje.flightbookingsystem.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FlightDTO {

    private String companyName;
    private String departureCity;
    private LocalDateTime departureTime;
    private String arrivalCity;
    private LocalDateTime arrivalTime;
    private double ticketPrice;
    private int availableSeats;

    public FlightDTO() {
    }

    public FlightDTO(String companyName, String departureCity, LocalDateTime departureTime, String arrivalCity,
                     LocalDateTime arrivalTime, double ticketPrice, int availableSeats) {
        this.companyName = companyName;
        this.departureCity = departureCity;
        this.departureTime = departureTime;
        this.arrivalCity = arrivalCity;
        this.arrivalTime = arrivalTime;
        this.ticketPrice = ticketPrice;
        this.availableSeats = availableSeats;
    }
}
