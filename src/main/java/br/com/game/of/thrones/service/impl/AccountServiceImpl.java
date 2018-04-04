package br.com.game.of.thrones.service.impl;

import br.com.game.of.thrones.exceptions.ResourceNotFoundException;
import br.com.game.of.thrones.model.Account;
import br.com.game.of.thrones.model.AccountStatus;
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
    public Account create(Account account) {
        account.setCreatedDate(LocalDateTime.now());
        account.setStatus(AccountStatus.ACTIVE);
        return accountRepository.save(account);
    }

    @Override
    public Account read(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account", "id", id));
    }

    @Override
    public Account update(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void delete(Long id) {
        Account account = read(id);
        accountRepository.delete(account);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}