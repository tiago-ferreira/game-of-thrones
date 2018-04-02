package br.com.game.of.thrones.repository;

import br.com.game.of.thrones.model.PhysicalPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhysicalPersonRepository extends JpaRepository<PhysicalPerson, Long> {
}
