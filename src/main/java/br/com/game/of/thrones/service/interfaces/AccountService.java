package br.com.game.of.thrones.service.interfaces;

import br.com.game.of.thrones.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    void create(Account account);
    Optional<Account> read(Long id);
    void update(Account account);
    void delete(Account account);
    List<Account> findAll();
}
