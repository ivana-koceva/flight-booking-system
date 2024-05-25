package air.skopje.flightbookingsystem.model.dto;

import air.skopje.flightbookingsystem.model.Flight;
import air.skopje.flightbookingsystem.model.Passenger;
import air.skopje.flightbookingsystem.model.Payment;
import air.skopje.flightbookingsystem.model.enums.BagType;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class TicketDTO {

    private String chosenSeat;
    @Enumerated(EnumType.STRING)
    private BagType bagType;
    private Flight flight;
    private Passenger passenger;
    private Payment payment;

    public TicketDTO(String chosenSeat, BagType bagType, Flight flight, Passenger passenger) {
        this.chosenSeat = chosenSeat;
        this.bagType = bagType;
        this.flight = flight;
        this.passenger = passenger;
        this.payment = null;
    }
}
