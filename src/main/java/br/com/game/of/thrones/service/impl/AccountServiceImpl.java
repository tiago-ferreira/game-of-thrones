package br.com.game.of.thrones.service.impl;

import br.com.game.of.thrones.model.Account;
import br.com.game.of.thrones.repository.AccountRepository;
import br.com.game.of.thrones.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public void create(Account account) {
        account.setCreatedDate(LocalDateTime.now());
        accountRepository.save(account);
    }

    @Override
    public Optional<Account> read(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public void update(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void delete(Account account) {
        accountRepository.delete(account);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}