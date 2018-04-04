package br.com.game.of.thrones.service.impl;

import br.com.game.of.thrones.exceptions.ResourceNotFoundException;
import br.com.game.of.thrones.model.Account;
import br.com.game.of.thrones.model.AccountStatus;
import br.com.game.of.thrones.model.AffilliateAccount;
import br.com.game.of.thrones.repository.AccountRepository;
import br.com.game.of.thrones.repository.AffilliateAccountRepository;
import br.com.game.of.thrones.service.interfaces.AffilliateAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AffilliateAccountServiceImpl implements AffilliateAccountService {

    @Autowired
    private AffilliateAccountRepository affilliateAccountRepository;
    @Autowired
    private AccountRepository accountRepository;


    @Override
    public AffilliateAccount create(AffilliateAccount affilliateAccount) {
        Optional<Account> account = accountRepository.findById(affilliateAccount.getAccount().getId());
        if(!account.isPresent()) {
            throw new RuntimeException("The Parent account does not exist");
        }
        affilliateAccount.setAccount(account.get());
        affilliateAccount.setCreatedDate(LocalDateTime.now());
        affilliateAccount.setStatus(AccountStatus.ACTIVE);
        return affilliateAccountRepository.save(affilliateAccount);
    }

    @Override
    public Optional<AffilliateAccount> read(Long id) {
        return affilliateAccountRepository.findById(id);
    }

    @Override
    public AffilliateAccount update(AffilliateAccount affilliateAccount) {
        return affilliateAccountRepository.save(affilliateAccount);
    }

    @Override
    public void delete(AffilliateAccount affilliateAccount) {
        affilliateAccountRepository.delete(affilliateAccount);
    }

    @Override
    public List<AffilliateAccount> findAll() {
        return affilliateAccountRepository.findAll();
    }
}
