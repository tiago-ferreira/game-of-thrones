package br.com.game.of.thrones.service;

import br.com.game.of.thrones.model.LegalPerson;
import br.com.game.of.thrones.model.Person;
import br.com.game.of.thrones.service.interfaces.LegalPersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class LegalPersonServiceTest {

    @Autowired
    private LegalPersonService legalPersonService;

    @BeforeEach
    @Test
    public void createAndRead() {
        LegalPerson legalPerson = new LegalPerson();
        legalPerson.setCnpj("55331497000112");
        legalPerson.setFantasyName("Mio di Bao");
        legalPerson.setSocialReason("Mineiro e o mundo");
        legalPerson = legalPersonService.create(legalPerson);
        LegalPerson readLegalPerson = legalPersonService.read(legalPerson.getId());
        Assertions.assertEquals(readLegalPerson.getCnpj(), legalPerson.getCnpj());
    }

    @Test
    public void updateTest() {
        LegalPerson legalPerson = legalPersonService.findAll().get(0);
        legalPerson.setSocialReason("Mio di Bao Solutions");
        legalPerson.setFantasyName("Mio di Baum");
        legalPerson = legalPersonService.update(legalPerson);
        Assertions.assertEquals(legalPerson.getFantasyName(), "Mio di Baum");
        Assertions.assertEquals(legalPerson.getSocialReason(), "Mio di Bao Solutions");
    }

    @Test
    public void deleteTest() {
        List<LegalPerson> legalPeople = legalPersonService.findAll();
        Integer initialSize = legalPeople.size();
        legalPersonService.delete(legalPeople.get(0).getId());
        legalPeople = legalPersonService.findAll();
        Assertions.assertTrue(legalPeople.size() < initialSize);
    }
}
