package br.com.game.of.thrones.repository;

import br.com.game.of.thrones.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Long> {

}
