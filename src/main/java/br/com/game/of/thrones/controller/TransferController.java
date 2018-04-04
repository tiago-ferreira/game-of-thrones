package br.com.game.of.thrones.controller;

import br.com.game.of.thrones.model.Transfer;
import br.com.game.of.thrones.service.interfaces.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @PostMapping("/deposit")
    @ResponseStatus(HttpStatus.CREATED)
    public void deposit(@RequestBody Transfer transfer) {
        transferService.deposit(transfer);
    }

    @GetMapping("/reversal/{id}")
    public void reversal(@PathVariable("id") Long id){
        transferService.reversal(id);
    }

    @GetMapping("/{id}")
    public Transfer read(@PathVariable("id") Long id) {
        return transferService.read(id);
    }

    @GetMapping
    public List<Transfer> findAll() {
        return transferService.findAll();
    }

}
