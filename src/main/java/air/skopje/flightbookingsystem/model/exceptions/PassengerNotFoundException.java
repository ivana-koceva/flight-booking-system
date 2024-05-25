package air.skopje.flightbookingsystem.model.exceptions;

public class PassengerNotFoundException extends RuntimeException {
    public PassengerNotFoundException(Long id) {
        super(String.format("Passenger with id: %d is not found", id));
    }
}
