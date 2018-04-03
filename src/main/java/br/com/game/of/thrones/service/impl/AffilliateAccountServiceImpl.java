package br.com.game.of.thrones.service.impl;

import br.com.game.of.thrones.model.AffilliateAccount;
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


    @Override
    public AffilliateAccount create(AffilliateAccount affilliateAccount) {
        affilliateAccount.setCreatedDate(LocalDateTime.now());
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
