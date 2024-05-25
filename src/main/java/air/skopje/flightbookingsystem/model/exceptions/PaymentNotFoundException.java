package air.skopje.flightbookingsystem.model.exceptions;

public class PaymentNotFoundException extends RuntimeException {
    public PaymentNotFoundException(Long id) {
        super(String.format("Payment with id: %d is not found", id));
    }
}
