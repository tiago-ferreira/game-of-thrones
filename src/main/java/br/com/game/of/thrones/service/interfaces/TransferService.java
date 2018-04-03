package br.com.game.of.thrones.service.interfaces;

import br.com.game.of.thrones.model.Transfer;

public interface TransferService {

    void deposit(Transfer transfer);
    void reversal(Transfer transfer);

}