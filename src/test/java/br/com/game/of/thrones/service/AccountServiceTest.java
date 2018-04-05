package br.com.game.of.thrones.service;

import br.com.game.of.thrones.model.Account;
import br.com.game.of.thrones.model.AccountStatus;
import br.com.game.of.thrones.service.interfaces.AccountService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @BeforeEach
    @Test
    public void createAndReadTest() {
        Account account = new Account();
        account.setName("Account 01");
        account.setBalance(new BigDecimal(0));
        account.setStatus(AccountStatus.ACTIVE);
        account = accountService.create(account);
        Account readAccount = accountService.read(account.getId());
        Assertions.assertEquals(readAccount.getName(), account.getName());
        Assertions.assertNotNull(readAccount.getCreatedDate());

    }

    @Test
    public void updateTest() {
        Account account = accountService.findAll().get(0);
        account.setStatus(AccountStatus.BLOQUED);
        account = accountService.update(account);
        Assertions.assertNotNull(account.getCreatedDate());
        Assertions.assertEquals(account.getStatus(), AccountStatus.BLOQUED);
    }

    @Test
    public void delete() {
        List<Account> accounts = accountService.findAll();
        Assertions.assertNotNull(accounts);
        Integer initialSize = accounts.size();
        accountService.delete(accounts.get(initialSize -1).getId());
        accounts = accountService.findAll();
        Assertions.assertTrue(accounts.size() < initialSize);
    }

}