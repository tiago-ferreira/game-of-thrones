package br.com.game.of.thrones.service.interfaces;

import br.com.game.of.thrones.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    Account create(Account account);

    Account read(Long id);

    Account update(Account account);

    void delete(Long id);

    List<Account> findAll();
}
