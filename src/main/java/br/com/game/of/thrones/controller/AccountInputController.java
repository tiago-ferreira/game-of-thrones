package br.com.game.of.thrones.controller;

import br.com.game.of.thrones.model.AccountInput;
import br.com.game.of.thrones.service.interfaces.AccountInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/account/input")
public class AccountInputController {

    @Autowired
    private AccountInputService accountInputService;

    @PostMapping("/deposit")
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void deposit(@RequestBody AccountInput transfer) {
        accountInputService.deposit(transfer);
    }

    @GetMapping("/reversal/{code}")
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void reversal(@PathVariable("code") String code) {
        accountInputService.reversal(code);
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
