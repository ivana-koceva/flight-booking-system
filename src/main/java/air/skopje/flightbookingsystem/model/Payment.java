package air.skopje.flightbookingsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;
    private LocalDateTime datePaid;

    public Payment(double amount, LocalDateTime datePaid) {
        this.amount = amount;
        this.datePaid = datePaid;
    }

    public Payment() {

    }
}
