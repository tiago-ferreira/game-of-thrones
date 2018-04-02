package br.com.game.of.thrones.repository;

import br.com.game.of.thrones.model.AffilliateAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AffilliateAccountRepository extends JpaRepository<AffilliateAccount, Long> {
}
