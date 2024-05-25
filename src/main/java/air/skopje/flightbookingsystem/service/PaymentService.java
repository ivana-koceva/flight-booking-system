package air.skopje.flightbookingsystem.service;

import air.skopje.flightbookingsystem.model.Payment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PaymentService {
    List<Payment> findAll();
    Optional<Payment> findById(Long id);
    Optional<Payment> create(double amount, LocalDateTime datePaid);
    Optional<Payment> update(Long id, double amount, LocalDateTime datePaid);
    void deleteById(Long id);
}
