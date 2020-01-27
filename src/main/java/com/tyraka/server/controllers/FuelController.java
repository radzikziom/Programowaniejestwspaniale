package com.tyraka.server.controllers;

import com.tyraka.server.entities.Fuel;
import com.tyraka.server.services.FuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@CrossOrigin(origins = "https://s434624.students.wmi.amu.edu.pl")
@RestController
@RequestMapping("/api")
public class FuelController {

    @Autowired
    private FuelService fuelService;

    @RequestMapping(value = "/fuels", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Fuel> list(Model model) { return fuelService.listAllFuels(); }

    @RequestMapping(value = "/fuels/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Fuel> show(@PathVariable Integer id, Model model) { return fuelService.getFuelById(id); }

    @RequestMapping(value = "/fuel", method = RequestMethod.POST)
    public ResponseEntity<Fuel> create(@RequestBody @Valid @NotNull Fuel fuel) {
        fuelService.saveFuel(fuel);
        return ResponseEntity.ok().body(fuel);
    }

    @RequestMapping(value = "/fuel/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id, Model model) {
        fuelService.deleteFuel(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
