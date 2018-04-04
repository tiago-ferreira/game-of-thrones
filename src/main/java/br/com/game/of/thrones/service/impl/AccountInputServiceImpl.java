package br.com.game.of.thrones.service.impl;

import br.com.game.of.thrones.exceptions.ResourceNotFoundException;
import br.com.game.of.thrones.model.Account;
import br.com.game.of.thrones.model.AccountInput;
import br.com.game.of.thrones.model.TransactionType;
import br.com.game.of.thrones.repository.AccountInputRepository;
import br.com.game.of.thrones.repository.AccountRepository;
import br.com.game.of.thrones.service.interfaces.AccountInputService;
import br.com.game.of.thrones.service.interfaces.AccountService;
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
    private AccountRepository accountRepository;

    @Override
    public void deposit(AccountInput accountInput) {
        Optional<Account> optionalAccount = accountRepository.findById(accountInput.getAccount().getId());
        if(!optionalAccount.isPresent()) {
            throw new ResourceNotFoundException("Account","id",accountInput.getAccount().getId());
        }
        Account account = optionalAccount.get();
        account.setBalance(sum(account.getBalance(), accountInput.getValue()));
        accountInput.setAccount(account);
        accountInput.setCreatedDate(LocalDateTime.now());
        accountInput.setTransactionType(TransactionType.DEPOSIT);
        accountRepository.save(account);
        accountInputRepository.save(accountInput);
    }

    @Override
    public void reversal(Long idAccountInput) {
        AccountInput accountInput = read(idAccountInput);
        Optional<Account> optionalAccount = accountRepository.findById(accountInput.getAccount().getId());
        if(!optionalAccount.isPresent()) {
            throw new ResourceNotFoundException("Account","id",accountInput.getAccount().getId());
        }
        Account account = optionalAccount.get();
        account.setBalance(subtract(account.getBalance(), accountInput.getValue()));
        accountRepository.save(account);
        AccountInput newAccountInput = new AccountInput(null, account, accountInput.getCode(), LocalDateTime.now(), accountInput.getValue(), TransactionType.REVERSAL, accountInput);
        accountInputRepository.save(newAccountInput);
    }

    @Override
    public AccountInput read(Long id) {
        return accountInputRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("AccountInput", "id", id));
    }

    @Override
    public List<AccountInput> findAll() {
        return accountInputRepository.findAll();
    }

    private BigDecimal sum(BigDecimal valueOne, BigDecimal valueTwo){
        return valueOne.add(valueTwo);
    }

    private BigDecimal subtract(BigDecimal valueOne, BigDecimal valueTwo) {
        return valueOne.subtract(valueTwo);
    }
}
