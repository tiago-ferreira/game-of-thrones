package br.com.game.of.thrones.service.interfaces;

import br.com.game.of.thrones.model.AccountInput;

import java.util.List;

public interface AccountInputService {

    AccountInput deposit(AccountInput accountInput);

    AccountInput reversal(Long idAccountInput);

    AccountInput read(Long id);

    List<AccountInput> findAll();
}
