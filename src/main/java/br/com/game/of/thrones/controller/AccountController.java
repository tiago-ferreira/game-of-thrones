package br.com.game.of.thrones.controller;

import br.com.game.of.thrones.exceptions.ResourceNotFoundException;
import br.com.game.of.thrones.model.Account;
import br.com.game.of.thrones.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Account account) {
        accountService.create(account);
    }

    @GetMapping(value = "/{id}")
    public Account read(@PathVariable("id") Long id) {
        return accountService.read(id);
    }

    @PutMapping
    public void update(@RequestBody Account account) {
        accountService.update(account);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        accountService.delete(id);
    }

    @GetMapping
    public List<Account> findAll() {
        return accountService.findAll();
    }

}