package com.tyraka.server.controllers;

import com.tyraka.server.entities.Nozzle;
import com.tyraka.server.services.NozzleService;
import io.swagger.models.auth.In;
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
public class NozzleController {

    @Autowired
    private NozzleService nozzleService;

    @RequestMapping(value = "nozzles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Nozzle> list(Model model) { return nozzleService.listAllNozzles(); }

    @RequestMapping(value = "/nozzles/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Nozzle> show(@PathVariable Integer id, Model model) { return nozzleService.getNozzleById(id); }

    @RequestMapping(value = "nozzle", method = RequestMethod.POST)
    public ResponseEntity<Nozzle> create(@RequestBody @Valid @NotNull Nozzle nozzle) {
        nozzleService.saveNozzle(nozzle);
        return ResponseEntity.ok().body(nozzle);
    }

    @RequestMapping(value = "/nozzle/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id, Model model) {
        nozzleService.deleteNozzle(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
