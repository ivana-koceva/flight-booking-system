package air.skopje.flightbookingsystem.web;

import air.skopje.flightbookingsystem.model.Flight;
import air.skopje.flightbookingsystem.model.dto.FlightDTO;
import air.skopje.flightbookingsystem.service.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/api/flights")
public class FlightRestController {

    private final FlightService flightService;

    public FlightRestController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<Flight> findAll() {
        return this.flightService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> findById(@PathVariable Long id) {
        return this.flightService.findById(id)
                .map(flight -> ResponseEntity.ok().body(flight))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Flight> save(@RequestBody FlightDTO flightDTO) {
        return this.flightService.create(flightDTO)
                .map(flight -> ResponseEntity.ok().body(flight))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Flight> save(@PathVariable Long id, @RequestBody FlightDTO flightDTO) {
        return this.flightService.update(id, flightDTO)
                .map(flight -> ResponseEntity.ok().body(flight))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Flight> deleteById(@PathVariable Long id) {
        if(this.flightService.findById(id).isEmpty()) return ResponseEntity.notFound().build();
        else {
            this.flightService.deleteById(id);
            return ResponseEntity.badRequest().build();
        }
    }

}
