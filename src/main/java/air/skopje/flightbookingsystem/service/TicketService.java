package air.skopje.flightbookingsystem.service;

import air.skopje.flightbookingsystem.model.Ticket;
import air.skopje.flightbookingsystem.model.dto.TicketDTO;
import air.skopje.flightbookingsystem.model.enums.BagType;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    List<Ticket> findAll();
    Optional<Ticket> findById(Long id);
    Optional<Ticket> create(String chosenSeat, BagType bagType, Long flightId, Long passengerId);

    Optional<Ticket> create(TicketDTO ticketDTO);
    Optional<Ticket> update(Long id, String chosenSeat, BagType bagType, Long flightId, Long passengerId, Long paymentId);

    Optional<Ticket> update(Long id, TicketDTO ticketDTO);
    void deleteById(Long id);

}
