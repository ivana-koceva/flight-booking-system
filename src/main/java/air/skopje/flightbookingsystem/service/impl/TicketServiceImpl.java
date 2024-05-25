package air.skopje.flightbookingsystem.service.impl;

import air.skopje.flightbookingsystem.model.Flight;
import air.skopje.flightbookingsystem.model.Passenger;
import air.skopje.flightbookingsystem.model.Payment;
import air.skopje.flightbookingsystem.model.Ticket;
import air.skopje.flightbookingsystem.model.dto.TicketDTO;
import air.skopje.flightbookingsystem.model.enums.BagType;
import air.skopje.flightbookingsystem.model.exceptions.FlightNotFoundException;
import air.skopje.flightbookingsystem.model.exceptions.PassengerNotFoundException;
import air.skopje.flightbookingsystem.model.exceptions.PaymentNotFoundException;
import air.skopje.flightbookingsystem.model.exceptions.TicketNotFoundException;
import air.skopje.flightbookingsystem.repository.FlightRepository;
import air.skopje.flightbookingsystem.repository.PassengerRepository;
import air.skopje.flightbookingsystem.repository.PaymentRepository;
import air.skopje.flightbookingsystem.repository.TicketRepository;
import air.skopje.flightbookingsystem.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final PassengerRepository passengerRepository;
    private final FlightRepository flightRepository;
    private final PaymentRepository paymentRepository;

    public TicketServiceImpl(TicketRepository ticketRepository, PassengerRepository passengerRepository, FlightRepository flightRepository, PaymentRepository paymentRepository) {
        this.ticketRepository = ticketRepository;
        this.passengerRepository = passengerRepository;
        this.flightRepository = flightRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        Ticket r = ticketRepository.findById(id).orElseThrow(() -> new TicketNotFoundException(id));
        return Optional.of(r);
    }

    @Override
    public Optional<Ticket> create(String chosenSeat, BagType bagType, Long flightId, Long passengerId) {
        Flight f = flightRepository.findById(flightId).orElseThrow(() -> new FlightNotFoundException(flightId));
        Passenger p = passengerRepository.findById(passengerId).orElseThrow(() -> new PassengerNotFoundException(passengerId));
        Ticket r = new Ticket(chosenSeat, bagType, f, p);
        ticketRepository.save(r);
        return Optional.of(r);
    }

    @Override
    public Optional<Ticket> create(TicketDTO ticketDTO) {
        Ticket r = new Ticket(ticketDTO.getChosenSeat(), ticketDTO.getBagType(), ticketDTO.getFlight(), ticketDTO.getPassenger());
        ticketRepository.save(r);
        return Optional.of(r);
    }

    @Override
    public Optional<Ticket> update(Long id, String chosenSeat, BagType bagType, Long flightId, Long passengerId, Long paymentId) {
        Ticket r = ticketRepository.findById(id).orElseThrow(() -> new TicketNotFoundException(id));

        Flight f = flightRepository.findById(flightId).orElseThrow(() -> new FlightNotFoundException(flightId));
        Passenger p = passengerRepository.findById(passengerId).orElseThrow(() -> new PassengerNotFoundException(passengerId));
        Payment py = paymentRepository.findById(paymentId).orElseThrow(() -> new PaymentNotFoundException(paymentId));

        r.setChosenSeat(chosenSeat);
        r.setBagType(bagType);
        r.setFlight(f);
        r.setPassenger(p);
        r.setPayment(py);
        ticketRepository.save(r);
        return Optional.of(r);
    }

    @Override
    public Optional<Ticket> update(Long id, TicketDTO ticketDTO) {
        Ticket r = ticketRepository.findById(id).orElseThrow(() -> new TicketNotFoundException(id));
        r.setChosenSeat(ticketDTO.getChosenSeat());
        r.setBagType(ticketDTO.getBagType());
        r.setFlight(ticketDTO.getFlight());
        r.setPassenger(ticketDTO.getPassenger());
        r.setPayment(ticketDTO.getPayment());
        ticketRepository.save(r);
        return Optional.of(r);
    }

    @Override
    public void deleteById(Long id) {
        ticketRepository.deleteById(id);
    }

}
