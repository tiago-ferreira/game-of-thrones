package br.com.game.of.thrones.repository;

import br.com.game.of.thrones.model.AccountInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountInputRepository extends JpaRepository<AccountInput, Long> {
}
