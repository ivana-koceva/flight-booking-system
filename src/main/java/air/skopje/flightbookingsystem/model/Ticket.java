package air.skopje.flightbookingsystem.model;

import air.skopje.flightbookingsystem.model.enums.BagType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String chosenSeat;

    @Enumerated(EnumType.STRING)
    private BagType bagType;

    @ManyToOne
    @JoinColumn(name = "flight_id", referencedColumnName = "id")
    private Flight flight;

    @ManyToOne
    private Passenger passenger;

    @OneToOne
    private Payment payment;

    public Ticket(String chosenSeat, BagType bagType, Flight flight, Passenger passenger) {
        this.chosenSeat = chosenSeat;
        this.bagType = bagType;
        this.flight = flight;
        this.passenger = passenger;
        this.payment = null;
    }

    public Ticket() {

    }
}
