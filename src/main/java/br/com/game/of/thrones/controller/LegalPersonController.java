package br.com.game.of.thrones.controller;

import br.com.game.of.thrones.exceptions.ResourceNotFoundException;
import br.com.game.of.thrones.model.LegalPerson;
import br.com.game.of.thrones.service.interfaces.LegalPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person/legal")
public class LegalPersonController {


    @Autowired
    private LegalPersonService legalPersonService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody LegalPerson legalPerson) {
        legalPersonService.create(legalPerson);
    }

    @GetMapping(value = "/{id}")
    public LegalPerson read(@PathVariable("id") Long id) {
        return legalPersonService.read(id);
    }

    @PutMapping
    public void update(@RequestBody LegalPerson legalPerson) {
        legalPersonService.update(legalPerson);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        legalPersonService.delete(id);
    }

    @GetMapping
    public List<LegalPerson> findAll() {
        return legalPersonService.findAll();
    }
}
