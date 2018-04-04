package br.com.game.of.thrones.service.interfaces;

import br.com.game.of.thrones.model.Transfer;

import java.util.List;

public interface TransferService {

    void deposit(Transfer transfer);

    void reversal(Long idTransfer);

    Transfer read(Long id);

    List<Transfer> findAll();

}