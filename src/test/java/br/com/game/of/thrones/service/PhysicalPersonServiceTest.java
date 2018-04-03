package br.com.game.of.thrones.service;

import br.com.game.of.thrones.model.PhysicalPerson;
import br.com.game.of.thrones.service.interfaces.PhysicalPersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PhysicalPersonServiceTest {

    @Autowired
    private PhysicalPersonService physicalPersonService;

    @Test
    @BeforeEach
    public void createAndReadTest() {
        PhysicalPerson physicalPerson = new PhysicalPerson();
        physicalPerson.setCpf("47336288383");
        physicalPerson.setFullName("Jon Snow");
        physicalPerson.setBirthdate(LocalDate.now().minusYears(50));
        physicalPerson = physicalPersonService.create(physicalPerson);
        Assertions.assertNotNull(physicalPerson.getId());
        PhysicalPerson readPhysicalPerson = physicalPersonService.read(physicalPerson.getId()).get();
        Assertions.assertEquals(physicalPerson.getFullName(), readPhysicalPerson.getFullName());
        Assertions.assertEquals(physicalPerson.getBirthdate(), readPhysicalPerson.getBirthdate());
    }

    @Test
    public void updateTest() {
        PhysicalPerson physicalPerson = physicalPersonService.findAll().get(0);
        physicalPerson.setFullName("Arya Stark");
        physicalPerson.setBirthdate(LocalDate.now().minusYears(22));
        physicalPerson = physicalPersonService.update(physicalPerson);
        Assertions.assertEquals(physicalPerson.getFullName(), "Arya Stark");
        Assertions.assertEquals(physicalPerson.getBirthdate(), LocalDate.now().minusYears(22));
    }

    @Test
    public void deleteTest() {
        List<PhysicalPerson> physicalPeople = physicalPersonService.findAll();
        Integer initialSize = physicalPeople.size();
        physicalPersonService.delete(physicalPeople.get(0));
        physicalPeople = physicalPersonService.findAll();
        Assertions.assertTrue(physicalPeople.size() < initialSize);
    }



}
