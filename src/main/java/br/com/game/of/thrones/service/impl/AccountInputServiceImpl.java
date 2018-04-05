package br.com.game.of.thrones.service.impl;

import br.com.game.of.thrones.exceptions.ResourceNotFoundException;
import br.com.game.of.thrones.model.Account;
import br.com.game.of.thrones.model.AccountInput;
import br.com.game.of.thrones.model.TransactionType;
import br.com.game.of.thrones.repository.AccountInputRepository;
import br.com.game.of.thrones.repository.AccountRepository;
import br.com.game.of.thrones.service.interfaces.AccountInputService;
import br.com.game.of.thrones.service.interfaces.AccountService;
import br.com.game.of.thrones.util.Calc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AccountInputServiceImpl implements AccountInputService {

    @Autowired
    private AccountInputRepository accountInputRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private Calc calc;

    @Override
    public AccountInput deposit(AccountInput accountInput) {
        Account account = accountService.read(accountInput.getAccount().getId());
        account.setBalance(calc.sum(account.getBalance(), accountInput.getValue()));
        accountInput.setAccount(account);
        accountInput.setCreatedDate(LocalDateTime.now());
        accountInput.setTransactionType(TransactionType.DEPOSIT);
        accountService.update(account);
        return accountInputRepository.save(accountInput);
    }

    @Override
    public AccountInput reversal(Long idAccountInput) {
        AccountInput accountInput = read(idAccountInput);
        Account account = accountService.read(accountInput.getAccount().getId());
        account.setBalance(calc.subtract(account.getBalance(), accountInput.getValue()));
        accountService.update(account);
        AccountInput newAccountInput = new AccountInput(null, account, accountInput.getCode(), LocalDateTime.now(), accountInput.getValue(), TransactionType.REVERSAL, accountInput);
        return accountInputRepository.save(newAccountInput);
    }

    @Override
    public AccountInput read(Long id) {
        return accountInputRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("AccountInput", "id", id));
    }

    @Override
    public List<AccountInput> findAll() {
        return accountInputRepository.findAll();
    }

}
