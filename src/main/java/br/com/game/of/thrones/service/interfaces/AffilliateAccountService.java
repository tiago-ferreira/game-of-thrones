package br.com.game.of.thrones.service.interfaces;

import br.com.game.of.thrones.model.AffilliateAccount;

import java.util.List;
import java.util.Optional;

public interface AffilliateAccountService {

    AffilliateAccount create(AffilliateAccount affilliateAccount);

    AffilliateAccount read(Long id);

    AffilliateAccount update(AffilliateAccount affilliateAccount);

    void delete(Long id);

    List<AffilliateAccount> findAll();
}
