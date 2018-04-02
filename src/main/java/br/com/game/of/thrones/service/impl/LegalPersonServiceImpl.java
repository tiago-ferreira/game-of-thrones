package br.com.game.of.thrones.service.impl;

import br.com.game.of.thrones.model.LegalPerson;
import br.com.game.of.thrones.repository.LegalPersonRepository;
import br.com.game.of.thrones.service.interfaces.LegalPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LegalPersonServiceImpl implements LegalPersonService {

    @Autowired
    private LegalPersonRepository legalPersonRepository;

    @Override
    public void create(LegalPerson legalPerson) {
        legalPersonRepository.save(legalPerson);
    }

    @Override
    public Optional<LegalPerson> read(Long id) {
        return legalPersonRepository.findById(id);
    }

    @Override
    public void update(LegalPerson legalPerson) {
        legalPersonRepository.save(legalPerson);
    }

    @Override
    public void delete(LegalPerson legalPerson) {
        legalPersonRepository.delete(legalPerson);
    }

    @Override
    public List<LegalPerson> findAll() {
        return legalPersonRepository.findAll();
    }
}
