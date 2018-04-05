package br.com.game.of.thrones.service;

import br.com.game.of.thrones.model.Account;
import br.com.game.of.thrones.model.AccountInput;
import br.com.game.of.thrones.model.AccountStatus;
import br.com.game.of.thrones.model.TransactionType;
import br.com.game.of.thrones.service.interfaces.AccountInputService;
import br.com.game.of.thrones.service.interfaces.AccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AccountInputServiceTest {


    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountInputService accountInputService;

    private Account createAccount() {
        Account account = new Account();
        account.setName("Account 01");
        account.setBalance(new BigDecimal(0));
        account.setStatus(AccountStatus.ACTIVE);
        return accountService.create(account);
    }

    @Test
    public void depositTest() {
        Account account = createAccount();
        AccountInput accountInput = new AccountInput(null, account, "BRLKFsdf", LocalDateTime.now(), new BigDecimal(50), TransactionType.DEPOSIT, null);
        accountInputService.deposit(accountInput);
        Account accountAfterDeposit = accountService.read(account.getId());
        Assertions.assertNotNull(accountAfterDeposit);
        Assertions.assertTrue(accountAfterDeposit.getBalance().compareTo(account.getBalance().add(accountInput.getValue())) == 0);
    }

    @Test
    public void reversalTest() {
        AccountInput accountInput = accountInputService.findAll().get(0);
        Account account = accountInput.getAccount();
        accountInputService.reversal(accountInput.getCode());
        Account accountAfterReversal = accountService.read(account.getId());
        Assertions.assertNotNull(accountAfterReversal);
        Assertions.assertTrue(accountAfterReversal.getBalance().compareTo(account.getBalance().subtract(accountInput.getValue())) == 0);
    }

    @Test
    public void findByCodeTest() {
        Account account = createAccount();
        AccountInput accountInput = new AccountInput(null, account, "GJKMNO", LocalDateTime.now(), new BigDecimal(50), TransactionType.DEPOSIT, null);
        accountInputService.deposit(accountInput);
        AccountInput accountInputNew = accountInputService.findByCode(accountInput.getCode());
        Assertions.assertNotNull(accountInputNew);
    }

}
