package br.com.game.of.thrones.controller;

import br.com.game.of.thrones.exceptions.ResourceNotFoundException;
import br.com.game.of.thrones.model.PhysicalPerson;
import br.com.game.of.thrones.service.interfaces.PhysicalPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person/physical")
public class PhysicalPersonController {

    @Autowired
    private PhysicalPersonService physicalPersonService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody PhysicalPerson physicalPerson) {
        physicalPersonService.create(physicalPerson);
    }

    @GetMapping(value = "/{id}")
    public PhysicalPerson read(@PathVariable("id") Long id) {
        return physicalPersonService.read(id).orElseThrow(() -> new ResourceNotFoundException("PhysicalPerson", "id", id));
    }

    @PutMapping
    public void update(@RequestBody PhysicalPerson physicalPerson) {
        physicalPersonService.update(physicalPerson);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        PhysicalPerson physicalPerson = physicalPersonService.read(id).orElseThrow(() -> new ResourceNotFoundException("PhysicalPerson", "id", id));
        physicalPersonService.delete(physicalPerson);
    }

    @GetMapping
    public List<PhysicalPerson> findAll() {
        return physicalPersonService.findAll();
    }
}
