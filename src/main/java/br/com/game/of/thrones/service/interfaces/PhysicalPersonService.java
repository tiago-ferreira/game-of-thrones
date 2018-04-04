package br.com.game.of.thrones.service.interfaces;

import br.com.game.of.thrones.model.PhysicalPerson;

import java.util.List;
import java.util.Optional;

public interface PhysicalPersonService {
    PhysicalPerson create(PhysicalPerson physicalPerson);

    PhysicalPerson read(Long id);

    PhysicalPerson update(PhysicalPerson physicalPerson);

    void delete(Long id);

    List<PhysicalPerson> findAll();
}
