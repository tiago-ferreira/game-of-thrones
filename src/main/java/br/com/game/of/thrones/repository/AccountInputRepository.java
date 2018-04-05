package br.com.game.of.thrones.repository;

import br.com.game.of.thrones.model.AccountInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountInputRepository extends JpaRepository<AccountInput, Long> {

    Optional<AccountInput> findByCode(String code);
}
