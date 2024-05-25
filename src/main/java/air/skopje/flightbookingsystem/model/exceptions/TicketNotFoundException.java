package air.skopje.flightbookingsystem.model.exceptions;

public class TicketNotFoundException extends RuntimeException {
    public TicketNotFoundException(Long id) {
        super(String.format("Reservation with id: %d is not found", id));
    }
}
