package br.com.game.of.thrones.service.interfaces;

import br.com.game.of.thrones.model.AffilliateAccount;

import java.util.List;
import java.util.Optional;

public interface AffilliateAccountService {

    void create(AffilliateAccount affilliateAccount);

    Optional<AffilliateAccount> read(Long id);

    void update(AffilliateAccount affilliateAccount);

    void delete(AffilliateAccount affilliateAccount);

    List<AffilliateAccount> findAll();
}
