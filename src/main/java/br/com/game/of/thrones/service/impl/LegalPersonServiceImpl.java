package br.com.game.of.thrones.service.impl;

import br.com.game.of.thrones.exceptions.ResourceNotFoundException;
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
    public LegalPerson create(LegalPerson legalPerson) {
        return legalPersonRepository.save(legalPerson);
    }

    @Override
    public LegalPerson read(Long id) {
        return legalPersonRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("LegalPerson", "id", id));
    }

    @Override
    public LegalPerson update(LegalPerson legalPerson) {
        return legalPersonRepository.save(legalPerson);
    }

    @Override
    public void delete(Long id) {
        LegalPerson legalPerson = read(id);
        legalPersonRepository.delete(legalPerson);
    }

    @Override
    public List<LegalPerson> findAll() {
        return legalPersonRepository.findAll();
    }
}
