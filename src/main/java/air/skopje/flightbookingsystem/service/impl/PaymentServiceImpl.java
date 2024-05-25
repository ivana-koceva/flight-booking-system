package air.skopje.flightbookingsystem.service.impl;

import air.skopje.flightbookingsystem.model.Payment;
import air.skopje.flightbookingsystem.model.exceptions.PaymentNotFoundException;
import air.skopje.flightbookingsystem.repository.PaymentRepository;
import air.skopje.flightbookingsystem.service.PaymentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> findById(Long id) {
        Payment p = paymentRepository.findById(id).orElseThrow(() -> new PaymentNotFoundException(id));
        return Optional.of(p);
    }

    @Override
    public Optional<Payment> create(double amount, LocalDateTime datePaid) {
        Payment p = new Payment(amount, datePaid);
        paymentRepository.save(p);
        return Optional.of(p);
    }

    @Override
    public Optional<Payment> update(Long id, double amount, LocalDateTime datePaid) {
        Payment p = paymentRepository.findById(id).orElseThrow(() -> new PaymentNotFoundException(id));
        p.setAmount(amount);
        p.setDatePaid(datePaid);
        paymentRepository.save(p);
        return Optional.of(p);
    }

    @Override
    public void deleteById(Long id) {
        paymentRepository.deleteById(id);
    }
}
