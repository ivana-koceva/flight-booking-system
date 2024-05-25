package air.skopje.flightbookingsystem.service.impl;

import air.skopje.flightbookingsystem.model.Passenger;
import air.skopje.flightbookingsystem.model.exceptions.PassengerNotFoundException;
import air.skopje.flightbookingsystem.repository.PassengerRepository;
import air.skopje.flightbookingsystem.service.PassengerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepository;

    public PassengerServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public List<Passenger> findAll() {
        return passengerRepository.findAll();
    }

    @Override
    public Optional<Passenger> findById(Long id) {
        Passenger p = passengerRepository.findById(id).orElseThrow(() -> new PassengerNotFoundException(id));
        return Optional.of(p);
    }

    @Override
    public Optional<Passenger> create(String firstName, String lastName, String emailAddress, String phoneNumber) {
        Passenger p = new Passenger(firstName, lastName, emailAddress, phoneNumber);
        passengerRepository.save(p);
        return Optional.of(p);
    }

    @Override
    public Optional<Passenger> update(Long id, String firstName, String lastName, String emailAddress, String phoneNumber) {
        Passenger p = passengerRepository.findById(id).orElseThrow(() -> new PassengerNotFoundException(id));
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setEmailAddress(emailAddress);
        p.setPhoneNumber(phoneNumber);
        passengerRepository.save(p);
        return Optional.of(p);
    }

    @Override
    public void deleteById(Long id) {
        passengerRepository.deleteById(id);
    }
}
