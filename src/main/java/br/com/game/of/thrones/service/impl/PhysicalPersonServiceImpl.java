package br.com.game.of.thrones.service.impl;

import br.com.game.of.thrones.exceptions.ResourceNotFoundException;
import br.com.game.of.thrones.model.PhysicalPerson;
import br.com.game.of.thrones.repository.PhysicalPersonRepository;
import br.com.game.of.thrones.service.interfaces.PhysicalPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhysicalPersonServiceImpl implements PhysicalPersonService {

    @Autowired
    private PhysicalPersonRepository physicalPersonRepository;

    @Override
    public PhysicalPerson create(PhysicalPerson physicalPerson) {
        return physicalPersonRepository.save(physicalPerson);
    }

    @Override
    public PhysicalPerson read(Long id) {
        return physicalPersonRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PhysicalPerson", "id", id));
    }

    @Override
    public PhysicalPerson update(PhysicalPerson physicalPerson) {
        return physicalPersonRepository.save(physicalPerson);
    }

    @Override
    public void delete(Long id) {
        PhysicalPerson physicalPerson = read(id);
        physicalPersonRepository.delete(physicalPerson);
    }

    @Override
    public List<PhysicalPerson> findAll() {
        return physicalPersonRepository.findAll();
    }
}
