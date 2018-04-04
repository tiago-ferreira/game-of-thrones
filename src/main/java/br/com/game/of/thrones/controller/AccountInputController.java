package br.com.game.of.thrones.controller;

import br.com.game.of.thrones.model.AccountInput;
import br.com.game.of.thrones.service.interfaces.AccountInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account/input")
public class AccountInputController {

    @Autowired
    private AccountInputService accountInputService;

    @PostMapping("/deposit")
    @ResponseStatus(HttpStatus.CREATED)
    public void deposit(@RequestBody AccountInput transfer) {
        accountInputService.deposit(transfer);
    }

    @GetMapping("/reversal/{id}")
    public void reversal(@PathVariable("id") Long id) {
        accountInputService.reversal(id);
    }

    @GetMapping("/{id}")
    public AccountInput read(@PathVariable("id") Long id) {
        return accountInputService.read(id);
    }

    @GetMapping
    public List<AccountInput> findAll() {
        return accountInputService.findAll();
    }

}
