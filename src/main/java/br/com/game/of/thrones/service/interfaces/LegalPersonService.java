package br.com.game.of.thrones.service.interfaces;

import br.com.game.of.thrones.model.LegalPerson;

import java.util.List;
import java.util.Optional;

public interface LegalPersonService {
    LegalPerson create(LegalPerson legalPerson);

    LegalPerson read(Long id);

    LegalPerson update(LegalPerson legalPerson);

    void delete(Long id);

    List<LegalPerson> findAll();
}
