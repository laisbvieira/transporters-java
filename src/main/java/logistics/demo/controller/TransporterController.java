package logistics.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import logistics.demo.model.Transporter;
import logistics.demo.service.TransporterService;

//indica que os métodos nela serão responsáveis por lidar com requisições HTTP
@RestController
@RequestMapping("/transportadores")
public class TransporterController {
    
    private final TransporterService transporterService;

    public TransporterController(TransporterService transporterService) {
        this.transporterService = transporterService;
    }

    //GET all
    @GetMapping
    public List<Transporter> getAllTransporters() {
        return transporterService.getAllTransporters();
    }

    //GET by id
    @GetMapping("/{id}")
    public ResponseEntity<Transporter> getTransporterById(@PathVariable Long id) {
        Transporter transporter = transporterService.getTransporterById(id);
        return ResponseEntity.ok(transporter);
    }

    //POST
    @PostMapping
    public ResponseEntity<Transporter> createTransporter(@RequestBody Transporter transporter) {
        Transporter savedTransporter = transporterService.createTransporter(transporter);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTransporter);
    }

    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Transporter> updateTranspoter(@PathVariable Long id, @RequestBody Transporter transporter) {
        Transporter updatedTransporter = transporterService.updateTransporter(id, transporter);
        return ResponseEntity.ok(updatedTransporter);

    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransporter(@PathVariable Long id) {
       transporterService.deleteTransporter(id);
        return ResponseEntity.noContent().build();
    }

}


