package air.skopje.flightbookingsystem.web;

import air.skopje.flightbookingsystem.model.Flight;
import air.skopje.flightbookingsystem.model.Ticket;
import air.skopje.flightbookingsystem.model.dto.FlightDTO;
import air.skopje.flightbookingsystem.model.dto.TicketDTO;
import air.skopje.flightbookingsystem.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/api/tickets")
public class TicketRestController {

    private final TicketService ticketService;

    public TicketRestController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<Ticket> findAll() {
        return this.ticketService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> findById(@PathVariable Long id) {
        return this.ticketService.findById(id)
                .map(ticket -> ResponseEntity.ok().body(ticket))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Ticket> save(@RequestBody TicketDTO ticketDTO) {
        return this.ticketService.create(ticketDTO)
                .map(ticket -> ResponseEntity.ok().body(ticket))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Ticket> save(@PathVariable Long id, @RequestBody TicketDTO ticketDTO) {
        return this.ticketService.update(id, ticketDTO)
                .map(ticket -> ResponseEntity.ok().body(ticket))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Ticket> deleteById(@PathVariable Long id) {
        if(this.ticketService.findById(id).isEmpty()) return ResponseEntity.notFound().build();
        else {
            this.ticketService.deleteById(id);
            return ResponseEntity.badRequest().build();
        }
    }
}
