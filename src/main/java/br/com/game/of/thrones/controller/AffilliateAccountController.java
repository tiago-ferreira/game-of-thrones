package br.com.game.of.thrones.controller;

import br.com.game.of.thrones.exceptions.ResourceNotFoundException;
import br.com.game.of.thrones.model.AffilliateAccount;
import br.com.game.of.thrones.service.interfaces.AffilliateAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/affilliate/account")
public class AffilliateAccountController {


    @Autowired
    private AffilliateAccountService affilliateAccountService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody AffilliateAccount account) {
        affilliateAccountService.create(account);
    }

    @GetMapping(value = "/{id}")
    public AffilliateAccount read(@PathVariable("id") Long id) {
        return affilliateAccountService.read(id).orElseThrow( () -> new ResourceNotFoundException("AffilliateAccount", "id", id));
    }

    @PutMapping
    public void update(@RequestBody AffilliateAccount account) {
        affilliateAccountService.update(account);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        AffilliateAccount account = affilliateAccountService.read(id).orElseThrow( () -> new ResourceNotFoundException("AffilliateAccount", "id", id));
        affilliateAccountService.delete(account);
    }

    @GetMapping
    public List<AffilliateAccount> findAll() {
        return affilliateAccountService.findAll();
    }
}
