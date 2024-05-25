package air.skopje.flightbookingsystem.model.exceptions;

public class FlightNotFoundException extends RuntimeException {
    public FlightNotFoundException(Long id) {
        super(String.format("Flight with id: %d is not found", id));
    }
}
