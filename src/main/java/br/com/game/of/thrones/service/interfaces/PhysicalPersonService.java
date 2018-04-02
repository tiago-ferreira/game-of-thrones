package br.com.game.of.thrones.service.interfaces;

import br.com.game.of.thrones.model.PhysicalPerson;

import java.util.List;
import java.util.Optional;

public interface PhysicalPersonService {
    void create(PhysicalPerson physicalPerson);

    Optional<PhysicalPerson> read(Long id);

    void update(PhysicalPerson physicalPerson);

    void delete(PhysicalPerson physicalPerson);

    List<PhysicalPerson> findAll();
}
