package br.com.game.of.thrones.service;

import br.com.game.of.thrones.model.*;
import br.com.game.of.thrones.service.interfaces.AccountService;
import br.com.game.of.thrones.service.interfaces.AffilliateAccountService;
import br.com.game.of.thrones.service.interfaces.TransferService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TransferServiceTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AffilliateAccountService affilliateAccountService;

    @Autowired
    private TransferService transferService;

    private Account createAccount() {
        Account account = new Account();
        account.setName("Account 01");
        account.setBalance(new BigDecimal(0));
        account.setStatus(AccountStatus.ACTIVE);
        return accountService.create(account);
    }


    private AffilliateAccount createAffilliateAccount(AffilliateAccount affilliateAccount) {
        return affilliateAccountService.create(affilliateAccount);
    }

    @Test
    public void depositTest() {
        AffilliateAccount origin = new AffilliateAccount("Affiliate Account 01", new BigDecimal(100), AccountStatus.ACTIVE, createAccount() );
        origin = createAffilliateAccount(origin);
        AffilliateAccount destiny = new AffilliateAccount("Affiliate Account 02", new BigDecimal(10), AccountStatus.ACTIVE, origin );
        destiny = createAffilliateAccount(destiny);
        Transfer transfer = new Transfer(null, origin, destiny, new BigDecimal(50),  LocalDateTime.now(), TransactionType.DEPOSIT, null);
        transferService.deposit(transfer);
        origin = affilliateAccountService.read(origin.getId());
        destiny = affilliateAccountService.read(destiny.getId());
        Assertions.assertNotNull(origin);
        Assertions.assertNotNull(destiny);
        Assertions.assertTrue(origin.getBalance().compareTo(new BigDecimal(50)) == 0);
        Assertions.assertTrue(destiny.getBalance().compareTo(new BigDecimal(60)) == 0);
    }

    @Test
    public void reversalTest() {
        Transfer transfer = transferService.findAll().get(0);
        AffilliateAccount origin = transfer.getOrigin();
        AffilliateAccount destiny = transfer.getDestiny();
        BigDecimal originBalanceExpected = origin.getBalance().add(transfer.getValue());
        BigDecimal destinyBalanceExpected = destiny.getBalance().subtract(transfer.getValue());
        transferService.reversal(transfer.getId());
        AffilliateAccount originAfterReversal = affilliateAccountService.read(origin.getId());
        AffilliateAccount destinyAfterReversal = affilliateAccountService.read(destiny.getId());
        Assertions.assertNotNull(originAfterReversal);
        Assertions.assertNotNull(destinyAfterReversal);
        Assertions.assertTrue(originAfterReversal.getBalance().compareTo(originBalanceExpected) == 0);
        Assertions.assertTrue(destinyAfterReversal.getBalance().compareTo(destinyBalanceExpected) == 0);
    }


}
