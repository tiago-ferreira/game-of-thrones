package br.com.game.of.thrones.service;

import br.com.game.of.thrones.model.Account;
import br.com.game.of.thrones.model.AccountStatus;
import br.com.game.of.thrones.model.AffilliateAccount;
import br.com.game.of.thrones.service.interfaces.AccountService;
import br.com.game.of.thrones.service.interfaces.AffilliateAccountService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AffilliateAccountServiceTest {


    @Autowired
    private AccountService accountService;

    @Autowired
    private AffilliateAccountService affilliateAccountService;

    private static Long idControl = 2L;

    private Account createAccount() {
        Account account = new Account();
        account.setName("Account 01");
        account.setBalance(new BigDecimal(0));
        account.setStatus(AccountStatus.ACTIVE);
        return accountService.create(account);
    }

    @BeforeEach
    @Test
    public void createAndRead() {
        Account account = createAccount();
        AffilliateAccount affilliateAccount = new AffilliateAccount();
        affilliateAccount.setName("Affiliate Account 01");
        affilliateAccount.setBalance(new BigDecimal(0));
        affilliateAccount.setStatus(AccountStatus.ACTIVE);
        affilliateAccount.setAccount(account);
        affilliateAccount = affilliateAccountService.create(affilliateAccount);
        AffilliateAccount readAffilliateAccount = affilliateAccountService.read(affilliateAccount.getId()).get();
        Assertions.assertNotNull(readAffilliateAccount.getCreatedDate());
        Assertions.assertEquals(readAffilliateAccount.getName(), affilliateAccount.getName());
    }

    @Test
    public void update() {
        AffilliateAccount affilliateAccount = affilliateAccountService.findAll().get(0);
        BigDecimal balance = new BigDecimal(10);
        affilliateAccount.setBalance(balance);
        affilliateAccount.setStatus(AccountStatus.BLOQUED);
        affilliateAccount = affilliateAccountService.update(affilliateAccount);
        Assertions.assertNotNull(affilliateAccount.getCreatedDate());
        Assertions.assertEquals(affilliateAccount.getStatus(), AccountStatus.BLOQUED);
        Assertions.assertEquals(affilliateAccount.getBalance(), balance);
    }

    @Test
    public void delete() {
        List<AffilliateAccount> affilliateAccounts = affilliateAccountService.findAll();
        Integer initialSize = affilliateAccounts.size();
        Assertions.assertNotNull(affilliateAccounts);
        affilliateAccountService.delete(affilliateAccounts.get(0));
        affilliateAccounts = affilliateAccountService.findAll();
        Assertions.assertTrue(affilliateAccounts.size() < initialSize);

    }



}
